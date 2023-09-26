package br.upe.acs.controller;

import java.util.Map;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.upe.acs.controller.responses.CursoResposta;
import br.upe.acs.service.CourseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/courses")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CourseController {

    private final CourseService service;

    @Operation(summary = "Listar cursos")
    @GetMapping
    public ResponseEntity<Map<String, ?>> listCourses(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int amount) {
        return ResponseEntity.ok(service.listCourses(page, amount));
    }

    @Operation(summary = "Buscar curso por id")
    @GetMapping("/{id}")
    public ResponseEntity<CursoResposta> findCourseById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new CursoResposta(service.findCourseById(id)));
    }
}
