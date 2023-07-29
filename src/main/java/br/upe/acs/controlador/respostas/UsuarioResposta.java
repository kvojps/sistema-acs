package br.upe.acs.controlador.respostas;

import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.Endereco;
import br.upe.acs.dominio.Requisicao;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UsuarioResposta {

	private final Long id;

	private final String nomeCompleto;

	private final String cpf;
	
	private final String matricula;

	private final String telefone;

	private final String email;

	private final String senha;

	private final CursoResposta curso;

	private final int periodo;

	private final String codigoVerificacao;

	private final boolean verificado;

	private final List<RequisicaoResposta> requisicoes;

	private final EnderecoResposta endereco;

	public UsuarioResposta(Usuario usuario) {
		this.id = usuario.getId();
		this.nomeCompleto = usuario.getNomeCompleto();
		this.cpf = usuario.getCpf();
		this.matricula = usuario.getMatricula();
		this.telefone = usuario.getTelefone();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.curso = new CursoResposta(usuario.getCurso());
		this.periodo = usuario.getPeriodo();
		this.codigoVerificacao = usuario.getCodigoVerificacao();
		this.verificado = usuario.isVerificado();
		this.requisicoes = converterRequisicoes(usuario.getRequisicoes());
		this.endereco = converterEndereco(usuario.getEndereco());
	}

	private List<RequisicaoResposta> converterRequisicoes(List<Requisicao> requisicoesAluno) {
		return requisicoesAluno.stream().map(RequisicaoResposta::new).collect(Collectors.toList());
	}

	private EnderecoResposta converterEndereco(Endereco enderecoAluno) {
		return new EnderecoResposta(enderecoAluno);
	}
}
