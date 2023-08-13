package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.RequisicaoSimplesResposta;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.vo.AtividadeComplementarVO;
import br.upe.acs.repositorio.UsuarioRepositorio;
import br.upe.acs.utils.AcsExcecao;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.*;

import static br.upe.acs.servico.RequisicaoServico.gerarPaginacaoRequisicoes;

@Service
@RequiredArgsConstructor
public class AlunoServico {

	private final UsuarioRepositorio repositorio;

	public Usuario buscarAlunoPorId(Long id) throws AcsExcecao {
		Optional<Usuario> usuario = repositorio.findById(id);
		if (usuario.isEmpty()) {
			throw new AcsExcecao("Não existe um usuário associado a este id!");
		}

		return usuario.get();
	}

	public Usuario buscarAlunoPorEmail(String email) throws AcsExcecao {
		Optional<Usuario> aluno = repositorio.findByEmail(email);
		if (aluno.isEmpty()) {
			throw new AcsExcecao("Não existe um usuário associado a este email!");
		}

		return aluno.get();
	}

	public Map<String, Object> listarRequisicoesPaginadas(String email, int pagina, int quantidade) throws AcsExcecao {
		Usuario aluno = buscarAlunoPorEmail(email);
		List<RequisicaoSimplesResposta> requisicoesAluno = new ArrayList<>(aluno.getRequisicoes().stream()
				.filter(requisicao -> !requisicao.isArquivada())
				.sorted(Comparator.comparing(Requisicao::getStatusRequisicao))
				.map(RequisicaoSimplesResposta::new).toList());
		return gerarPaginacaoRequisicoes(requisicoesAluno, pagina, quantidade);
	}

	public AtividadeComplementarVO atividadesComplementaresAluno(String email) throws AcsExcecao {
		Usuario aluno = buscarAlunoPorEmail(email);

		return new AtividadeComplementarVO(aluno);
	}

}
