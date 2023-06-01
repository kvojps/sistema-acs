package br.upe.acs.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.upe.acs.dominio.Curso;
import br.upe.acs.repositorio.CursoRepositorio;
import br.upe.acs.utils.AcsExcecao;

@Service
public class CursoServico {
	
	@Autowired
	private CursoRepositorio repositorio;
	
	public List<Curso> listarCursos() {
		return repositorio.findAll();
	}
	
	public Optional<Curso> buscarCursoPorId(Long id) throws AcsExcecao {
		if (repositorio.findById(id).isEmpty()) {
			throw new AcsExcecao("Não existe um curso associada a este id!");
		}
		
		return repositorio.findById(id);
	}
}
