package br.upe.acs.controlador;

import java.util.Map;

import br.upe.acs.utils.MensagemUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.upe.acs.controlador.respostas.CursoResposta;
import br.upe.acs.servico.CourseService;
import br.upe.acs.exceptions.AcsException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/curso")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CursoControlador {

	private final CourseService servico;

	@Operation(summary = "Listar todos os cursos",
			description = "Esse endpoint deve retornar todos os cursos existentes no banco de dados do sistema\n"
					+ "\nPré-condição: O usuário deve estar logado e verificado\n"
					+ "\nPós-condição: Nenhuma")
	@GetMapping
	public ResponseEntity<Map<String, ?>> listarCursos(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int amount
	) {
		return ResponseEntity.ok(servico.listCourses(page, amount));
	}

	@Operation(summary = "Buscar curso por id",
			description = "Esse endpoint deve retornar o curso correspondente ao id informado.\n"
    				+ "\nPré-condição: É necessário que o usuário esteja logado e verificado no sistema. \n"
    				+ "\nPós-condição: Nenhuma")
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarCursoPorId(@PathVariable("id") Long id) {
		ResponseEntity<?> resposta;
		try {
			CursoResposta cursoResposta = new CursoResposta(servico.findCourseById(id));
			resposta =  ResponseEntity.ok(cursoResposta);
		} catch (AcsException e) {
			resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
		}

		return resposta;
	}
}
