package br.upe.acs.servico;

import br.upe.acs.dominio.Aluno;
import br.upe.acs.repositorio.AlunoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoServico {

	private final AlunoRepositorio repositorio;

	public Optional<Aluno> buscarAlunoPorId(Long id) throws AcsExcecao {
		if (repositorio.findById(id).isEmpty()) {
			throw new AcsExcecao("Não existe um usuário associado a este id!");
		}

		return repositorio.findById(id);
	}

	public Aluno buscarAlunoPorEmail(String email) throws AcsExcecao {
		Optional<Aluno> aluno = repositorio.findByEmail(email);
		if (aluno.isEmpty()) {
			throw new AcsExcecao("Não existe um usuário associado a este email!");
		}

		return aluno.get();
	}
	
	public String verificarAluno(Long alunoId, String codigoVerificacao) throws AcsExcecao {
		Aluno usuario = buscarAlunoPorId(alunoId).orElseThrow();
		String resposta;

		if (usuario.isVerificado()) {
			resposta = "Este Aluno já é verificado!";
		} else if (codigoVerificacao.equals(usuario.getCodigoVerificacao())) {
			usuario.setVerificado(true);
			repositorio.save(usuario);
			resposta = "Aluno verificado com sucesso!";
		} else {
			resposta = "O código de verificação está incorreto!";
		}

		return resposta;
	}
}
