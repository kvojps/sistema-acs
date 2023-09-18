package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import br.upe.acs.dominio.dto.AlterarSenhaDTO;
import br.upe.acs.dominio.dto.LoginDTO;
import br.upe.acs.dominio.dto.RecuperacaoDeContaDTO;
import br.upe.acs.dominio.dto.RegistroDTO;
import br.upe.acs.servico.AccessControlService;
import br.upe.acs.utils.AcsException;
import br.upe.acs.utils.InvalidRegisterException;
import br.upe.acs.utils.MensagemUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ControleAcessoControlador {

    private final AccessControlService servico;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistroDTO registerDto, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                throw new InvalidRegisterException(String.join("; ", bindingResult.getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage).toList()));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(servico.registerUser(registerDto));
        }catch (InvalidRegisterException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (AcsException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
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
        } catch (AcsException e) {
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
        } catch (AcsException e) {
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
        } catch (AcsException e) {
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
        } catch (AcsException e) {
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
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return  resposta;
    }
}
