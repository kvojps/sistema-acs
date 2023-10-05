package br.upe.acs.controller;

import br.upe.acs.config.JwtService;
import br.upe.acs.controller.responses.AuthenticationResponse;
import br.upe.acs.model.dto.ChangePasswordDTO;
import br.upe.acs.model.dto.LoginDTO;
import br.upe.acs.model.dto.AccountRecoveryDTO;
import br.upe.acs.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Realizar login")
    @PostMapping
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody LoginDTO login) {
        return ResponseEntity.ok(service.login(login));
    }

    @Operation(summary = "Verificar usuário por token")
    @GetMapping("/verify")
    public ResponseEntity<?> verifyEmail(HttpServletRequest request,
                                         @RequestParam(value = "code") String code) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.verifyEmail(email, code);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Obter novo código de verificação por token")
    @GetMapping("/verify/new-code")
    public ResponseEntity<?> getNewVerificationCode(HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.getNewVerificationCode(email);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Atualizar senha por token")
    @PatchMapping("/password")
    public ResponseEntity<?> updatePassword(HttpServletRequest request, @RequestBody ChangePasswordDTO changePasswordDTO) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.updatePassword(email, changePasswordDTO.getPassword(), changePasswordDTO.getNewPassword());

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Esquecer senha")
    @GetMapping("/password/forgot")
    public ResponseEntity<?> forgotPassword(@RequestParam String email) {
        service.forgotPassword(email);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Recuperar senha por token")
    @PatchMapping("/password/recovery")
    public ResponseEntity<?> recoveryPassword(HttpServletRequest request,
                                              @RequestBody AccountRecoveryDTO accountRecoveryDTO) {
        String token = request.getHeader("Authorization").substring(7);
        service.recoveryPassword(token, accountRecoveryDTO.newPassword());

        return ResponseEntity.noContent().build();
    }
}
