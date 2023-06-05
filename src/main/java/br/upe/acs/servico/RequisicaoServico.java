package br.upe.acs.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.upe.acs.dominio.Requisicao;
import br.upe.acs.repositorio.RequisicaoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequisicaoServico {
	
	private final RequisicaoRepositorio repositorio;
	
	public List<Requisicao> listarRequisicoes() {
		return repositorio.findAll();
	}

	public Optional<Requisicao> buscarRequisicaoPorId(Long id) throws AcsExcecao {
		if (repositorio.findById(id).isEmpty()) {
			throw new AcsExcecao("Não existe uma requisição associada a este id!");
		}

		return repositorio.findById(id);
	}

}
