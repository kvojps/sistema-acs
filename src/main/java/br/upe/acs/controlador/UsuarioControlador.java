package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.respostas.UsuarioResposta;
import br.upe.acs.dominio.dto.AlterarSenhaDTO;
import br.upe.acs.servico.UserService;
import br.upe.acs.utils.AcsExcecao;
import br.upe.acs.utils.MensagemUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioControlador {

    private final UserService servico;
    
    private final JwtService jwtService;
    
    @Operation(
            summary = "Buscar usuário por id",
            description = "Esta rota permite buscar um usuário via seu id. As informações retornadas incluem " +
                    "informações como id, nome completo, número de matricula, telefone, email, perfis, curso, " +
                    "periodo e se é verificado. Essa rota séra util para gerenciamento de usuarios."
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable("id") Long id){
    	ResponseEntity<?> resposta;
    	try {
    		UsuarioResposta usuarioResposta = new UsuarioResposta(servico.findUserById(id));
    		resposta = ResponseEntity.ok(usuarioResposta);
    	} catch(AcsExcecao e){
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

    @Operation(summary = "Alterar informações de cadastro")
    @PutMapping("/informacoes")
    public ResponseEntity<?> alterarInformacoes(
            HttpServletRequest request,
            @RequestParam String nomeCompleto,
            @RequestParam String telefone,
            @RequestParam Long cursoId
    ) throws AcsExcecao {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        ResponseEntity<?> resposta;
        try {
            servico.updateUser(email, nomeCompleto, telefone, cursoId);
            resposta = ResponseEntity.noContent().build();
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }
        return resposta;
    }

    @Operation( summary = "Desativar meu Perfil")
    @DeleteMapping("/me")
    public ResponseEntity<?> desativarPerfilDoUsuário(HttpServletRequest request) {
        ResponseEntity<?> resposta;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            servico.deactivateUser(email);
            resposta = ResponseEntity.noContent().build();
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

}
