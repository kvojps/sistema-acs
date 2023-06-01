package br.upe.acs.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.upe.acs.dominio.Atividade;
import br.upe.acs.repositorio.AtividadeRepositorio;
import br.upe.acs.utils.AcsExcecao;

@Service
public class AtividadeServico {

	@Autowired
	private AtividadeRepositorio repositorio;
	
	public List<Atividade> listarAtividades() {
		return repositorio.findAll();
	}
	
	public Optional<Atividade> buscarAtividadePorId(Long id) throws AcsExcecao {
		if (repositorio.findById(id).isEmpty()) {
			throw new AcsExcecao("Não existe uma atividade associada a este id!");
		}
		
		return repositorio.findById(id);
	}
}
