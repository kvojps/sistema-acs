package br.upe.acs.controlador.respostas;

import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.dominio.Endereco;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.enums.PerfilEnum;
import lombok.Getter;

@Getter
public class UsuarioResposta {

	private Long id;

	private String nomeCompleto;

	private String cpf;

	private int periodo;

	private String telefone;

	private String email;

	private String senha;

	private String codigoVerificacao;

	private boolean verificado;

	private PerfilEnum perfil;

	private Endereco endereco;

	private CursoResposta curso;

	private List<RequisicaoResposta> requisicoes;

	public UsuarioResposta(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nomeCompleto = usuario.getNomeCompleto();
		this.cpf = usuario.getCpf();
		this.periodo = usuario.getPeriodo();
		this.telefone = usuario.getTelefone();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.codigoVerificacao = usuario.getCodigoVerificacao();
		this.verificado = usuario.isVerificado();
		this.perfil = usuario.getPerfil();
		this.endereco = null; // TODO
		this.curso = new CursoResposta(usuario.getCurso());
		this.requisicoes = converterRequisicoes(usuario.getRequisicoes());
	}

	private List<RequisicaoResposta> converterRequisicoes(List<Requisicao> requisicoes) {
		List<RequisicaoResposta> resposta = requisicoes.stream().map(requisicao -> new RequisicaoResposta(requisicao))
				.collect(Collectors.toList());

		return resposta;
	}
}
