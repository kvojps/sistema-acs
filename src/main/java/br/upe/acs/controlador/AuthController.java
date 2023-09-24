package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.respostas.AutenticacaoResposta;
import br.upe.acs.dominio.dto.AlterarSenhaDTO;
import br.upe.acs.dominio.dto.LoginDTO;
import br.upe.acs.dominio.dto.RecuperacaoDeContaDTO;
import br.upe.acs.servico.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService service;
    private final JwtService jwtService;

    @PostMapping("/")
    public ResponseEntity<AutenticacaoResposta> loginUser(@RequestBody LoginDTO login) {
        return ResponseEntity.ok(service.login(login));
    }

    @GetMapping("/verify")
    public ResponseEntity<?> verifyEmail(HttpServletRequest request,
                                             @RequestParam(value = "code") String code) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.verifyEmail(email, code);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/verify/new-code")
    public ResponseEntity<?> getNewVerificationCode(HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.getNewVerificationCode(email);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/password")
    public ResponseEntity<?> updatePassword(HttpServletRequest request, @RequestBody AlterarSenhaDTO alterarSenhaDTO) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.updatePassword(email, alterarSenhaDTO.getSenha(), alterarSenhaDTO.getNovaSenha());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("password/forgot")
    public ResponseEntity<?> forgotPassword(@RequestParam String email) {
        service.forgotPassword(email);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/password/recovery")
    public ResponseEntity<?> recoveryPassword(HttpServletRequest request,
                                              @RequestBody RecuperacaoDeContaDTO recuperacaoDeContaDTO) {
        String token = request.getHeader("Authorization").substring(7);
        service.recoveryPassword(token, recuperacaoDeContaDTO.novaSenha());

        return ResponseEntity.noContent().build();
    }
}
