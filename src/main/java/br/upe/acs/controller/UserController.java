package br.upe.acs.controller;

import br.upe.acs.config.JwtService;
import br.upe.acs.controller.responses.UserResponse;
import br.upe.acs.model.User;
import br.upe.acs.model.dto.RegistrationDTO;
import br.upe.acs.model.dto.UserUpdateDTO;
import br.upe.acs.utils.exceptions.InvalidRegisterException;
import br.upe.acs.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;
    private final JwtService jwtService;

    @Operation(summary = "Criar usuário")
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody RegistrationDTO registerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidRegisterException(String.join("; ", bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).toList()));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse(service.createUser(registerDto)));
    }

    @Operation(summary = "Buscar usuário por id")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new UserResponse(service.findUserById(id)));
    }

    @Operation(summary = "Buscar usuário pelo token")
    @GetMapping("/me")
    public ResponseEntity<UserResponse> findUserByEmail(HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        return ResponseEntity.ok(new UserResponse(service.findUserByEmail(email)));
    }
    
    @Operation(summary = "Atualizar usuário pelo token")
    @PutMapping
    public ResponseEntity<?> updateUser(@AuthenticationPrincipal User user, @RequestBody UserUpdateDTO userUpdateDTO) {
        service.updateUser(user.getId(), userUpdateDTO);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Apagar usuário por token")
    @DeleteMapping
    public ResponseEntity<?> deactivateUser(HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.deactivateUser(email);
        return ResponseEntity.noContent().build();
    }
}
