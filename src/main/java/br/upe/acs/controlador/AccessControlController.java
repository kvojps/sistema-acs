package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.respostas.AutenticacaoResposta;
import br.upe.acs.dominio.dto.AlterarSenhaDTO;
import br.upe.acs.dominio.dto.LoginDTO;
import br.upe.acs.dominio.dto.RecuperacaoDeContaDTO;
import br.upe.acs.dominio.dto.RegistroDTO;
import br.upe.acs.exceptions.InvalidRegisterException;
import br.upe.acs.servico.AccessControlService;
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
public class AccessControlController {

    private final AccessControlService service;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AutenticacaoResposta> registerUser(@Valid @RequestBody RegistroDTO registerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidRegisterException(String.join("; ", bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).toList()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registerUser(registerDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AutenticacaoResposta> loginUser(@RequestBody LoginDTO login) {
        return ResponseEntity.ok(service.loginUser(login));
    }

    @PatchMapping("/password/change")
    public ResponseEntity<?> changePassword(HttpServletRequest request, @RequestBody AlterarSenhaDTO alterarSenhaDTO) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.changePassword(email, alterarSenhaDTO.getSenha(), alterarSenhaDTO.getNovaSenha());

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyUser(HttpServletRequest request,
                                        @RequestParam(value = "code") String code) {
            String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
            service.verifyUser(email, code);

            return ResponseEntity.noContent().build();
    }

    @PatchMapping("/verify/new-code")
    public ResponseEntity<?> changeVerificationCode(HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.resendVerificationCode(email);

        return ResponseEntity.noContent().build();

    }

    @PostMapping("/recovery")
    public ResponseEntity<?> recoveryAccount(@RequestParam String email) {
        service.recoveryAccount(email);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/password/forgot")
    public ResponseEntity<?> changePassword(HttpServletRequest request,
            @RequestBody RecuperacaoDeContaDTO recuperacaoDeContaDTO) {
        String token = request.getHeader("Authorization").substring(7);
        service.forgotPassword(token, recuperacaoDeContaDTO.novaSenha());

        return ResponseEntity.noContent().build();
    }
}
