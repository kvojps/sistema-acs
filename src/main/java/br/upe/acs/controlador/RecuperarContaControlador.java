package br.upe.acs.controlador;

import br.upe.acs.dominio.dto.RecuperacaoDeContaDTO;
import br.upe.acs.servico.RecuperarContaServico;
import br.upe.acs.utils.AcsExcecao;
import br.upe.acs.utils.MensagemUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario/conta/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RecuperarContaControlador {

    private final RecuperarContaServico servico;

    @PostMapping("recuperar")
    public ResponseEntity<?> recuperarConta(@RequestParam String email) {
        servico.recuperarConta(email);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("alterar-senha")
    public ResponseEntity<?> alterarSenha(
            HttpServletRequest request,
            @RequestBody RecuperacaoDeContaDTO recuperacaoDeContaDTO
    ) {
        ResponseEntity<?> resposta;
        String token = request.getHeader("Authorization").substring(7);
        try {
            servico.alterarSenha(token, recuperacaoDeContaDTO.novaSenha());
            resposta = ResponseEntity.noContent().build();
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return  resposta;
    }

}
