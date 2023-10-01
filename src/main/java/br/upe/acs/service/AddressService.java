package br.upe.acs.service;

import br.upe.acs.model.Address;
import br.upe.acs.model.dto.ViaCepDTO;
import br.upe.acs.utils.exceptions.CepInvalidException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.upe.acs.model.dto.AddressDTO;
import br.upe.acs.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository repository;

    public Address createAddress(AddressDTO addressDto) {
        ModelMapper modelMapper = new ModelMapper();
        Address addressToSave = modelMapper.map(addressDto, Address.class);

        return repository.save(addressToSave);
    }

    public ViaCepDTO findAddressByCep(String cep) {
        if (!cep.matches("\\d{8}")) {
            throw new CepInvalidException("CEP must be an 8-digit numeric value.");
        }

        try {
            String apiUrl = String.format("https://viacep.com.br/ws/%s/json/", cep);
            ViaCepDTO viaCepDTO = new RestTemplate().getForEntity(apiUrl, ViaCepDTO.class).getBody();

            if (viaCepDTO != null && !viaCepDTO.getLocalidade().isEmpty()) {
                return viaCepDTO;
            } else {
                throw new CepInvalidException("CEP not found");
            }
        } catch (HttpClientErrorException.NotFound e) {
            throw new CepInvalidException("CEP not found: " + e.getMessage());
        } catch (RestClientException e) {
            throw new CepInvalidException("Failed to fetch CEP data: " + e.getMessage());
        }
    }
}
