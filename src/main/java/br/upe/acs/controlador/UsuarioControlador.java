package br.upe.acs.controlador;

import br.upe.acs.dominio.dto.AlterarSenhaDTO;
import br.upe.acs.servico.ControleAcessoServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
@CrossOrigin
public class UsuarioControlador {

    private final ControleAcessoServico servico;

    @Operation(summary = "Alterar senha do usuário")
    @PatchMapping
    public ResponseEntity<?> alterarSenha(
            HttpServletRequest request,
            @RequestBody AlterarSenhaDTO alterarSenhaDTO
            ) {
        String token = request.getHeader("Authorization").substring(7);
        ResponseEntity<?> resposta;
        try {
            servico.alterarSenha(token, alterarSenhaDTO.getSenha(), alterarSenhaDTO.getNovaSenha());
            resposta = ResponseEntity.noContent().build();
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

}
