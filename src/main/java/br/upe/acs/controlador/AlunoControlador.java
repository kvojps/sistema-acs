package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.respostas.AlunoResposta;
import br.upe.acs.controlador.respostas.RequisicaoRascunhoResposta;
import br.upe.acs.controlador.respostas.RequisicaoResposta;
import br.upe.acs.dominio.Aluno;
import br.upe.acs.servico.RequisicaoRascunhoServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.upe.acs.servico.AlunoServico;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/aluno")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AlunoControlador {

    private final AlunoServico servico;
    private final JwtService jwtService;
    private final RequisicaoRascunhoServico requisicaoRascunhoServico;

    @Operation(summary = "Buscar aluno por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAlunoPorId(@PathVariable("id") Long id) {
        ResponseEntity<?> resposta;
        try {
			AlunoResposta alunoResposta = new AlunoResposta(servico.buscarAlunoPorId(id).orElseThrow());
			resposta = ResponseEntity.ok(alunoResposta);
		} catch (AcsExcecao e) {
			resposta = ResponseEntity.badRequest().body(e.getMessage());
		}

        return resposta;
    }

    @Operation(summary = "Verificar aluno")
    @PostMapping("/verificacao")
    public ResponseEntity<?> verificarAluno(@RequestParam(value = "usuarioId") Long alunoId,
                                              @RequestParam(value = "codigoVerificacao") String codigo) {
        ResponseEntity<?> resposta;
        try {
            resposta = ResponseEntity.ok(servico.verificarAluno(alunoId, codigo));
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

    @Operation(summary = "Listar todas as requisições do aluno")
    @GetMapping("/requisicao")
    public  ResponseEntity<?> listarRequisicaoDeAluno(HttpServletRequest request) {
        //TODO AS:
        ResponseEntity<?> resposta;
        try {
            String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
            Aluno aluno = servico.buscarAlunoPorEmail(email);
            List<Object> requisicoesRascunhosRespostas = new ArrayList<>(aluno.getRequisicoes()
                    .stream().map(RequisicaoResposta::new).toList());
            requisicoesRascunhosRespostas.addAll(requisicaoRascunhoServico.buscarRequisicaoRascunhoPorAluno(aluno.getId())
                    .stream().map(RequisicaoRascunhoResposta::new).toList());


            resposta = ResponseEntity.ok(requisicoesRascunhosRespostas);

        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

}
