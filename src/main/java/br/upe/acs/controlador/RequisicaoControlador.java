package br.upe.acs.controlador;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.upe.acs.config.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.upe.acs.controlador.respostas.RequisicaoResposta;
import br.upe.acs.servico.RequisicaoServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/requisicao")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RequisicaoControlador {

    private final RequisicaoServico servico;

    private final JwtService jwtService;

    private final RequisicaoServico requisicaoServico;
    
    @Operation(summary = "Listar todas as requisições")
    @GetMapping
    public ResponseEntity<List<RequisicaoResposta>> listarRequisicoes() {
        return ResponseEntity.ok(servico.listarRequisicoes().stream()
                .map(RequisicaoResposta::new).collect(Collectors.toList()));
    }

    @Operation(summary = "Listar as requisições com paginação")
    @GetMapping("/paginacao")
    public ResponseEntity<Map<String, Object>> listarRequisicoesPaginas(@RequestParam(defaultValue = "0") int pagina,
                                                                        @RequestParam(defaultValue = "10") int quantidade) {
        return ResponseEntity.ok(servico.listarRequisicoesPaginadas(pagina, quantidade));
    }

    @Operation(summary = "Listar as requisições de um usuário específico")
    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> listarRequisicoesPorAluno(@PathVariable("id") Long alunoId) {
        try {
            return ResponseEntity.ok(servico.listarRequisicoesPorAluno(alunoId).stream()
                    .map(RequisicaoResposta::new).toList());
        } catch (AcsExcecao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Buscar requisição por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarRequisicaoPorId(@PathVariable("id") Long id) {
        try {
            RequisicaoResposta requisicaoResposta = new RequisicaoResposta(servico.buscarRequisicaoPorId(id));
            return ResponseEntity.ok(requisicaoResposta);
        } catch (AcsExcecao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Adicionar requisição")
    @PostMapping
    public ResponseEntity<?> adicionarRequisicao(HttpServletRequest request) {
        ResponseEntity<?> resposta;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            resposta = ResponseEntity.ok(requisicaoServico.adicionarRequisicao(email));
        } catch (Exception e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }
   
    @Operation(summary = "Baixar pdf de uma requisição")
    @GetMapping("{id}/pdf")
    public ResponseEntity<?> gerarRequisicaoPDF(@PathVariable("id") Long requisicaoId) {
        ResponseEntity<?> resposta;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.attachment()
                    .filename("requisição" + requisicaoId + ".pdf").build());
            resposta = ResponseEntity.ok().headers(headers).body(servico.gerarRequisicaoPDF(requisicaoId));
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }
    
    
}
