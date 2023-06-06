package br.upe.acs.servico;

import org.springframework.stereotype.Service;

import br.upe.acs.dominio.Endereco;
import br.upe.acs.dominio.dto.EnderecoDTO;
import br.upe.acs.repositorio.EnderecoRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnderecoServico {

	private final EnderecoRepositorio repositorio;

	public Endereco adicionarEndereco(EnderecoDTO enderecoDTO) {
		Endereco enderecoSalvar = new Endereco();
		enderecoSalvar.setCep(enderecoDTO.getCep());
		enderecoSalvar.setUF(enderecoDTO.getUF());
		enderecoSalvar.setCidade(enderecoDTO.getCidade());
		enderecoSalvar.setBairro(enderecoDTO.getBairro());
		enderecoSalvar.setRua(enderecoDTO.getRua());
		enderecoSalvar.setNumero(enderecoDTO.getNumero());

		return repositorio.save(enderecoSalvar);
	}
}
