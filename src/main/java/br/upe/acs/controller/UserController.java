package br.upe.acs.controller;

import br.upe.acs.config.JwtService;
import br.upe.acs.controller.responses.UsuarioResposta;
import br.upe.acs.model.dto.RegistroDTO;
import br.upe.acs.utils.exceptions.InvalidRegisterException;
import br.upe.acs.service.UserService;
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
@RequestMapping("api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService servico;
    private final JwtService jwtService;

    @Operation(summary = "Criar usuário")
    @PostMapping
    public ResponseEntity<UsuarioResposta> createUser(@Valid @RequestBody RegistroDTO registerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidRegisterException(String.join("; ", bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).toList()));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioResposta(servico.createUser(registerDto)));
    }

    @Operation(summary = "Buscar usuário por id")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResposta> findUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new UsuarioResposta(servico.findUserById(id)));
    }

    @Operation(summary = "Buscar usuário pelo token")
    @GetMapping("/me")
    public ResponseEntity<UsuarioResposta> findUserByEmail(HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        return ResponseEntity.ok(new UsuarioResposta(servico.findUserByEmail(email)));
    }

    //TODO: reajustar para receber um DTO
    @Operation(summary = "Atualizar usuário pelo token")
    @PutMapping
    public ResponseEntity<?> updateUser(HttpServletRequest request, @RequestParam String nomeCompleto,
                                        @RequestParam String telefone, @RequestParam Long cursoId) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        servico.updateUser(email, nomeCompleto, telefone, cursoId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Apagar usuário pelo token")
    @DeleteMapping
    public ResponseEntity<?> deactivateUser(HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        servico.deactivateUser(email);
        return ResponseEntity.noContent().build();
    }
}
