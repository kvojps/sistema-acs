package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.respostas.AutenticacaoResposta;
import br.upe.acs.controlador.respostas.UsuarioResposta;
import br.upe.acs.dominio.dto.RegistroDTO;
import br.upe.acs.exceptions.AcsException;
import br.upe.acs.exceptions.InvalidRegisterException;
import br.upe.acs.servico.UserService;
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
@RequestMapping("api/usuario")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioControlador {

    private final UserService servico;

    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<UsuarioResposta> registerUser(@Valid @RequestBody RegistroDTO registerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidRegisterException(String.join("; ", bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).toList()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioResposta(servico.createUser(registerDto)));
    }

    @Operation(
            summary = "Buscar usuário por id",
            description = "Esta rota permite buscar um usuário via seu id. As informações retornadas incluem " +
                    "informações como id, nome completo, número de matricula, telefone, email, perfis, curso, " +
                    "periodo e se é verificado. Essa rota séra util para gerenciamento de usuarios."
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable("id") Long id) {
        ResponseEntity<?> resposta;
        try {
            UsuarioResposta usuarioResposta = new UsuarioResposta(servico.findUserById(id));
            resposta = ResponseEntity.ok(usuarioResposta);
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

    @Operation(
            summary = "Retornar dados de perfil do usuário",
            description = "Esta Rota permite o usuário ter acesso a suas informações no registrados. Possui com retorno " +
                    "informações como id, nome completo, número de matricula, telefone, email, perfis, curso, " +
                    "periodo e se é verificado. Essa rota séra util para acesso de suas informações pelo usuário."
    )
    @GetMapping("/me")
    public ResponseEntity<?> retornarPerfilDoUsuario(HttpServletRequest request) {

        ResponseEntity<?> resposta;
        try {
            String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
            var usuarioResposta = new UsuarioResposta(servico.findUserByEmail(email));
            resposta = ResponseEntity.ok(usuarioResposta);
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

    @Operation(summary = "Alterar informações de cadastro")
    @PutMapping("/informacoes")
    public ResponseEntity<?> alterarInformacoes(
            HttpServletRequest request,
            @RequestParam String nomeCompleto,
            @RequestParam String telefone,
            @RequestParam Long cursoId
    ) throws AcsException {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        ResponseEntity<?> resposta;
        try {
            servico.updateUser(email, nomeCompleto, telefone, cursoId);
            resposta = ResponseEntity.noContent().build();
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }
        return resposta;
    }

    @Operation(summary = "Desativar meu Perfil")
    @DeleteMapping("/me")
    public ResponseEntity<?> desativarPerfilDoUsuario(HttpServletRequest request) {
        ResponseEntity<?> resposta;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            servico.deactivateUser(email);
            resposta = ResponseEntity.noContent().build();
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

}
