package br.upe.acs.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import br.upe.acs.dominio.Curso;
import br.upe.acs.repositorio.CursoRepositorio;
import br.upe.acs.exceptions.AcsException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {
	
	private final CursoRepositorio repository;
	
	public List<Curso> listCourses() {
		return repository.findAll();
	}
	
	public Curso findCourseById(Long id) throws AcsException {
		return repository.findById(id).orElseThrow(() ->
				new AcsException("There is no course associated with this id"));
	}
}
