package br.upe.acs.controlador.respostas;

import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.dominio.Protocolo;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.enums.PerfilEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class UsuarioResposta {

	private Long id;

	private String primeiroNome;

	private String ultimoNome;

	private String email;

	@Enumerated(EnumType.STRING)
	private PerfilEnum perfil;

	private List<ProtocoloResposta> protocolos;

	public UsuarioResposta(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.primeiroNome = usuario.getPrimeiroNome();
		this.ultimoNome = usuario.getUltimoNome();
		this.email = usuario.getEmail();
		this.perfil = usuario.getPerfil();
		this.protocolos = converterProtocolos(usuario.getProtocolos());
	}

	private List<ProtocoloResposta> converterProtocolos(List<Protocolo> protocolos) {
		List<ProtocoloResposta> resposta = protocolos.stream().map(protocolo -> new ProtocoloResposta(protocolo))
				.collect(Collectors.toList());

		return resposta;
	}
}
