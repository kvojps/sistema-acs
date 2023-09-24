package br.upe.acs.controller.responses;

import br.upe.acs.model.Endereco;
import lombok.Getter;

@Getter
public class EnderecoResposta {

	private final Long id;
	
	private final String cep;
	
	private final String rua;
	
	private final String bairro;
	
	private final String cidade;
	
	private final String UF;
	
	private final int numero;

	public EnderecoResposta(Endereco endereco) {
		super();
		this.id = endereco.getId();
		this.cep = endereco.getCep();
		this.rua = endereco.getRua();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		UF = endereco.getUF();
		this.numero = endereco.getNumero();
	}
	
}
