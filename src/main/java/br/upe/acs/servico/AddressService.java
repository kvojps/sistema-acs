package br.upe.acs.servico;

import br.upe.acs.dominio.dto.ViaCepDTO;
import br.upe.acs.exceptions.CepInvalidException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.upe.acs.dominio.Endereco;
import br.upe.acs.dominio.dto.EnderecoDTO;
import br.upe.acs.repositorio.EnderecoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final EnderecoRepositorio repository;

    public Endereco createAddress(EnderecoDTO addressDto) {
        ModelMapper modelMapper = new ModelMapper();
        Endereco addressToSave = modelMapper.map(addressDto, Endereco.class);

        return repository.save(addressToSave);
    }

    public ViaCepDTO findAddressByCep(String cep) {
        ViaCepDTO viaCepDTO;

        try {
            viaCepDTO = new RestTemplate().getForEntity(String.format("https://viacep.com.br/ws/%s/json/", cep), ViaCepDTO.class).getBody();
            assert viaCepDTO != null;
            if (viaCepDTO.getLocalidade().isEmpty()) {
                throw new CepInvalidException("CEP not found");
            }
        } catch (Exception e) {
            throw new CepInvalidException("Invalid CEP");
        }

        return viaCepDTO;
    }
}
