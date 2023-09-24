package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import br.upe.acs.exceptions.AcsException;
import br.upe.acs.utils.MensagemUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.upe.acs.servico.StudentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/aluno")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AlunoControlador {

    private final StudentService servico;

    private final JwtService jwtService;

    @Operation(
            summary = "Carga horaria dos alunos",
            description = "Esta rota permite o aluno acessar as informações sobre suas horas complementares, " +
                    "retornando os horas já contabilizadas de Ensino, Extensão, Gestão e Pesquisa."
    )
    @GetMapping("/horas")
    public ResponseEntity<?> atividadesComplementaresAluno(HttpServletRequest request) {
        ResponseEntity<?> resposta;
        try {
            String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
            resposta = ResponseEntity.ok(servico.getStudentAcs(email));
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }


    @Operation(summary = "Busca horas de aluno por atividade")
    @GetMapping("/horas/{atividadeId}")
    public ResponseEntity<?> minhasHorasNaAtividade(
            HttpServletRequest request,
            @PathVariable("atividadeId") Long atividadeId
    ) {
        ResponseEntity<?> resposta;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            resposta =  ResponseEntity.ok(servico.getHoursAcsStatusByActivity(email, atividadeId));
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

}
