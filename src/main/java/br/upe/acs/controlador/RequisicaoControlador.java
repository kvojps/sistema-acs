package br.upe.acs.controlador;

import java.util.List;
import java.util.Map;

import br.upe.acs.config.JwtService;
import br.upe.acs.dominio.enums.EixoEnum;
import br.upe.acs.utils.MensagemUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import br.upe.acs.controlador.respostas.RequisicaoResposta;
import br.upe.acs.servico.ReadRequestsUseCase;
import br.upe.acs.exceptions.AcsException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/requisicao")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RequisicaoControlador {

    private final ReadRequestsUseCase servico;

    private final JwtService jwtService;

    @Operation(
            summary = "Listar todas as requisições",
            description = "Descrição: Através deste endpoint, pode-se visualizar todas as requisições do sistema."
    )
    @GetMapping
    public ResponseEntity<List<RequisicaoResposta>> listarRequisicoes() {
        return ResponseEntity.ok(servico.listRequests().stream().filter(requisicao -> !requisicao.isArquivada())
                .map(RequisicaoResposta::new).toList());
    }

    @Operation(
            summary = "Listar as requisições com paginação",
            description = "Descrição: Através deste endpoint, o usuário pode visualizar sua lista de requisições com paginação.\n" +
                    "Pré-condições: O usuário deve estar logado para utilizar o endpoint.\n" +
                    "Pós-condições: Caso selecione alguma requisição, o usuário é redirecionado para a tela da requisição selecionada."
    )
    @GetMapping("/paginacao")
    public ResponseEntity<Map<String, Object>> listarRequisicoesPaginas(@RequestParam(defaultValue = "0") int pagina,
                                                                        @RequestParam(defaultValue = "10") int quantidade) {
        return ResponseEntity.ok(servico.listNonSketchRequests(pagina, quantidade));
    }

    @Operation(
            summary = "Listar todas as requisições do aluno",
            description = "Esta rota permite o aluno lista todas suas requisições de forma paginada, " +
                    "possuindo com retorno um Map com um lista de requisições, a página atual, total de itens " +
                    "e total de páginas."
    )
    @GetMapping("/requisicao/paginacao")
    public  ResponseEntity<?> listUnarchivedRequests(
            HttpServletRequest request,
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int quantidade
    ) {
        ResponseEntity<?> resposta;
        try {
            String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
            resposta = ResponseEntity.ok(servico.listStudentUnarchivedRequests(pagina, email, quantidade));

        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }


    @Operation(
            summary = "Listar as requisições de um usuário específico",
            description = "Descrição: Através deste endpoint, o usuário pode visualizar sua lista de requisições.\n" +
                    "Pré-condições: O usuário deve estar logado para utilizar o endpoint.\n" +
                    "Pós-condições: Caso selecione alguma requisição, o usuário é redirecionado para a tela da requisição selecionada."
    )
    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> listarRequisicoesPorAluno(@PathVariable("id") Long alunoId) {
        try {
            return ResponseEntity.ok(servico.listRequestByStudent(alunoId).stream()
                    .filter(requisicao -> !requisicao.isArquivada()).map(RequisicaoResposta::new).toList());
        } catch (AcsException e) {
            return ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }
    }

    @Operation(
            summary = "Buscar requisição por id",
            description = "Descrição: Através dest endpoint, o usuário pode visualizar uma requisição específica.\n" +
                    "Pré-condições: O usuário deve estar logado.\n" +
                    "Pós-condições: O usuário é redirecionado para a tela da requisição selecionada."
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarRequisicaoPorId(@PathVariable("id") Long id) {
        try {
            RequisicaoResposta requisicaoResposta = new RequisicaoResposta(servico.findRequestById(id));
            return ResponseEntity.ok(requisicaoResposta);
        } catch (AcsException e) {
            return ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }
    }

    @Operation(
            summary = "Listar requisições arquivadas",
            description = "Descrição: Através deste endpoint, o usuário pode visualizar sua lista de requisições arquivadas.\n" +
                    "Pré-condições: O usuário deve estar logado para utilizar o endpoint.\n" +
                    "Pós-condições: Caso selecione alguma requisição, o usuário é redirecionado para a tela da requisição selecionada."
    )
    @GetMapping("/arquivar")
    public ResponseEntity<?> listarRequisicoesArquivadas(HttpServletRequest request) {
        ResponseEntity<?> resposta;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            resposta = ResponseEntity.ok(servico.listArchivedRequests(email)
                    .stream().map(RequisicaoResposta::new).toList());
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

    @GetMapping("/usuario/{id}/{eixo}")
    public ResponseEntity<Map<String, ?>> listStudentRequestsPaginatedByAxle(
            @PathVariable("id") Long studentId,
            @PathVariable("eixo") EixoEnum axle,
            @RequestParam int page,
            @RequestParam int amount
    ) {
        return ResponseEntity.ok(servico.listStudentRequestsByAxle(studentId, axle, page, amount));
    }
    
}
