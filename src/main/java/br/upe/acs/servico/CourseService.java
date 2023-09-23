package br.upe.acs.servico;

import java.util.List;
import java.util.Map;

import br.upe.acs.controlador.respostas.CursoResposta;
import org.springframework.stereotype.Service;

import br.upe.acs.dominio.Curso;
import br.upe.acs.repositorio.CursoRepositorio;
import br.upe.acs.exceptions.AcsException;
import lombok.RequiredArgsConstructor;

import static br.upe.acs.utils.PaginationUtils.generatePagination;

@Service
@RequiredArgsConstructor
public class CourseService {
	
	private final CursoRepositorio repository;

	public Map<String, Object> listCourses(int page, int amount) {

		List<CursoResposta> courses = repository.findAll().stream().map(CursoResposta::new).toList();

		return generatePagination(courses, page, amount);
	}
	
	public Curso findCourseById(Long id) throws AcsException {
		return repository.findById(id).orElseThrow(() ->
				new AcsException("There is no course associated with this id"));
	}
}
