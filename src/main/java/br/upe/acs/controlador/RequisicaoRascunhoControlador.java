package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import br.upe.acs.servico.RequestSketchService;
import br.upe.acs.utils.AcsException;
import br.upe.acs.utils.MensagemUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/requisicao")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RequisicaoRascunhoControlador {

    private final RequestSketchService servico;

    private final JwtService jwtService;

    @Operation(
            summary = "Adicionar requisição",
            description = "Descrição: Através deste endpoint, o usuário pode cadastrar uma requisição com o intuito" +
                    " de ratificar uma determinada quantidade de horas das suas atividades complementares.\n" +
                    "Pré-condições: O usuário deve estar logado.\n" +
                    "Pós-condições: O usuário é redirecionado para a tela específica da requisição enviada, " +
                    "e a coordenação recebe a notificação por e-mail."
    )
    @PostMapping
    public ResponseEntity<?> adicionarRequisicao(HttpServletRequest request) {
        ResponseEntity<?> resposta;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            resposta = ResponseEntity.status(201).body(servico.addRequest(email));
        } catch (Exception e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

    @Operation(
            summary = "Submissão de requisição",
            description = "Descrição: Através deste endpoint, o usuário pode submeter uma requisição.\n" +
                    "Pré-condições: O usuário deve estar logado.\n" +
                    "Pós-condições: O usuário recebe uma mensagem de confirmação de requisição submetida."
    )
    @PutMapping("/submissão/{id}")
    public ResponseEntity<?> submeterRequisicao(@PathVariable("id") Long requisicaoId) {
        ResponseEntity<?> resposta;
        try {
            resposta = ResponseEntity.ok(new MensagemUtil(servico.submitRequest(requisicaoId)));
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

    @Operation(
            summary = "Excluir requisição",
            description = "Descrição: Através deste endpoint, o usuário pode excluir um certificado.\n" +
                    "Pré-condições: O usuário deve estar logado.\n" +
                    "Pós-condições: O usuário recebe uma mensagem de confirmação de certificado excluído."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirCertificado(HttpServletRequest request, @PathVariable("id") Long requisicaoId) {
        ResponseEntity<?> resposta;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            servico.deleteRequest(requisicaoId, email);
            resposta = ResponseEntity.noContent().build();
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

}
