package br.upe.acs.controlador;

import br.upe.acs.dominio.dto.LoginDTO;
import br.upe.acs.dominio.dto.RegistroDTO;
import br.upe.acs.servico.ControleAcessoServico;
import br.upe.acs.utils.AcsExcecao;
import br.upe.acs.utils.MensagemUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/acesso/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ControleAcessoControlador {

    private final ControleAcessoServico servico;

    @Operation(summary = "Cadastro de usuário",
    		description = "Esse endpoint deve ser capaz de cadastrar um usuário no sistema.\n"
    				+ "\nPré-condição: Cadastar-se com email institucional, senha com 8 ou mais caracteres incluindo caracteres especiais, letras maiúsculas e minúsculas. \n"
    				+ "\nPós-condição: O usuário será direcionado para a tela de perfil para certificar que é membro da instituição, passando por um processo de verificação.")
    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrarUsuario(@Valid @RequestBody RegistroDTO registro, BindingResult bindingResult) {
        ResponseEntity<?> resposta;
        try {
            if (bindingResult.hasErrors()) {
                throw new AcsExcecao(String.join("; ", bindingResult.getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage).toList()));
            }
            resposta = ResponseEntity.ok(servico.cadastrarUsuario(registro));
        } catch (Exception e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

    @Operation(summary = "Login de usuário",
    		description = "Esse endpoint deve ser capaz de realizar o login do usuário.\n"
    				+ "\nPré-condição: O usuário deve estar cadastrado. \n"
    				+ "\nPós-condição: O usuário será direcionado para a tela inicial do sistema, caso informe as credenciais corretamente (e-mail e senha).")
    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody LoginDTO login) {
        ResponseEntity<?> resposta;
        try {
            resposta = ResponseEntity.ok(servico.loginUsuario(login));
        } catch (Exception e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }
}
