package br.upe.acs.controlador.respostas;

import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.dominio.Endereco;
import br.upe.acs.dominio.Usuario;
import lombok.Getter;

@Getter
public class EnderecoResposta {

	private Long id;
	
	private String cep;
	
	private String rua;
	
	private String bairro;
	
	private String cidade;
	
	private String UF;
	
	private int numero;
	
	private List<UsuarioResposta> usuarios;

	public EnderecoResposta(Endereco endereco) {
		super();
		this.id = endereco.getId();
		this.cep = endereco.getCep();
		this.rua = endereco.getRua();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		UF = endereco.getUF();
		this.numero = endereco.getNumero();
		this.usuarios = converterUsuario(endereco.getUsuarios());
	}
	
	private List<UsuarioResposta> converterUsuario(List<Usuario> usuarios) {
		List<UsuarioResposta> resposta = usuarios.stream().map(requisicao -> new UsuarioResposta(requisicao))
				.collect(Collectors.toList());

		return resposta;
	}
	
}
