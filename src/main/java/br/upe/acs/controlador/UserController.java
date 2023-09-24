package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.respostas.UsuarioResposta;
import br.upe.acs.dominio.dto.RegistroDTO;
import br.upe.acs.exceptions.InvalidRegisterException;
import br.upe.acs.servico.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService servico;
    private final JwtService jwtService;

    @PostMapping("/")
    public ResponseEntity<UsuarioResposta> createUser(@Valid @RequestBody RegistroDTO registerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidRegisterException(String.join("; ", bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).toList()));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioResposta(servico.createUser(registerDto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResposta> findUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new UsuarioResposta(servico.findUserById(id)));
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioResposta> findUserByEmail(HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        return ResponseEntity.ok(new UsuarioResposta(servico.findUserByEmail(email)));
    }

    //TODO: reajustar para receber um DTO
    @PutMapping("/")
    public ResponseEntity<?> updateUser(HttpServletRequest request, @RequestParam String nomeCompleto,
                                        @RequestParam String telefone, @RequestParam Long cursoId) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        servico.updateUser(email, nomeCompleto, telefone, cursoId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deactivateUser(HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        servico.deactivateUser(email);
        return ResponseEntity.noContent().build();
    }
}
