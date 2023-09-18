package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import br.upe.acs.dominio.dto.AlterarSenhaDTO;
import br.upe.acs.dominio.dto.LoginDTO;
import br.upe.acs.dominio.dto.RecuperacaoDeContaDTO;
import br.upe.acs.dominio.dto.RegistroDTO;
import br.upe.acs.servico.AccessControlService;
import br.upe.acs.utils.AcsExcecao;
import br.upe.acs.utils.MensagemUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
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

    private final AccessControlService servico;

    private final JwtService jwtService;

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
            resposta = ResponseEntity.ok(servico.registerUser(registro));
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
            resposta = ResponseEntity.ok(servico.loginUser(login));
        } catch (Exception e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

    @Operation(
            summary = "Alterar senha do usuário",
            description = "Esta rota permite ao usuário modificar sua senha por uma nova e está disponíveis " +
                    "para todos os usuários."
    )
    @PatchMapping("/senha")
    public ResponseEntity<?> alterarSenha(
            HttpServletRequest request,
            @RequestBody AlterarSenhaDTO alterarSenhaDTO
    ) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        ResponseEntity<?> resposta;
        try {
            servico.changePassword(email, alterarSenhaDTO.getSenha(), alterarSenhaDTO.getNovaSenha());
            resposta = ResponseEntity.noContent().build();
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

    @Operation(
            summary = "Verificar usuário",
            description = "Esta rota permite o usuário se verificar via código enviando para o email." +
                    "Essa rota é util para o sistema se certificar que o usuário se cadastro com um email que " +
                    "ele possui acesso."
    )
    @PostMapping("/verificacao")
    public ResponseEntity<?> verificarUsuario(HttpServletRequest request,
                                              @RequestParam(value = "codigoDeVerificacao") String codigo) {
        ResponseEntity<?> resposta;
        try {
            String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
            servico.verifyUser(email, codigo);
            resposta = ResponseEntity.ok(new MensagemUtil("O usuário foi verificado"));
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.status(406).body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

    @Operation(
            summary = "Solicitar novo código de veríficação",
            description = """
                    Esta rota permite ao usuário solicitar o envio de um novo código de veríficação para seu email.
                    \nPré-condição: É necessário que o usuário esteja logado
                    \nPós-condição: Usuario deve receber um email"""
    )
    @PatchMapping("/verificacao/novo")
    public ResponseEntity<?> alterarCodigoVerificacao(HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        ResponseEntity<?> resposta;
        try {
            servico.resendVerificationCode(email);
            resposta = ResponseEntity.ok(new MensagemUtil("Código de verificação reenviado"));
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

    @PostMapping("recuperar")
    public ResponseEntity<?> recuperarConta(@RequestParam String email) {
        ResponseEntity<?> resposta;
        try{
            servico.recoveryAccount(email);
            return ResponseEntity.noContent().build();
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }
        return resposta;
    }

    @PostMapping("alterar-senha")
    public ResponseEntity<?> alterarSenha(
            HttpServletRequest request,
            @RequestBody RecuperacaoDeContaDTO recuperacaoDeContaDTO
    ) {
        ResponseEntity<?> resposta;
        String token = request.getHeader("Authorization").substring(7);
        try {
            servico.forgotPassword(token, recuperacaoDeContaDTO.novaSenha());
            resposta = ResponseEntity.noContent().build();
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return  resposta;
    }
}
