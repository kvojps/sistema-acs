package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.respostas.UsuarioResposta;
import br.upe.acs.servico.UsuarioServico;
import br.upe.acs.utils.AcsExcecao;
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
    private final UsuarioServico servico;
    
    private final JwtService jwtService;
    
    @Operation(summary = "Buscar usuário por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable("id") Long id){
    	ResponseEntity<?> resposta;
    	try {
    		UsuarioResposta usuarioResposta = new UsuarioResposta(servico.buscarUsuarioPorId(id));
    		resposta = ResponseEntity.ok(usuarioResposta);
    	} catch(AcsExcecao e){
    		resposta = ResponseEntity.badRequest().body(e.getMessage());  		
    	}
    	
    	return resposta;
    }
    
    @Operation(
            summary = "Listar requisicões do aluno páginada",
            description = "Atualmente somente para Coordenadores e Administradores"
    )
    @GetMapping("/requisicao/paginacao")
    public  ResponseEntity<?> listarRequisicaoPorAlunoPaginacao(
            @RequestParam Long alunoId,
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int quantidade
    ) {
        ResponseEntity<?> resposta;
        try {
            resposta = ResponseEntity.ok(servico.listarRequisicoesPorAlunoPaginadas(alunoId, pagina, quantidade));

        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

    @Operation(summary = "Retornar dados de perfil do usuário")
    @GetMapping("/me")
    public ResponseEntity<?> retornarPerfilDoUsuario(HttpServletRequest request) {

        ResponseEntity<?> resposta;
        try {
            String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
            var usuarioResposta = new UsuarioResposta(servico.buscarUsuarioPorEmail(email));
            resposta = ResponseEntity.ok(usuarioResposta);
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

    @Operation(summary = "Verificar usuário")
    @PostMapping("/verificacao")
    public ResponseEntity<?> verificarUsuario(HttpServletRequest request,
                                              @RequestParam(value = "codigoDeVerificacao") String codigo) {
        ResponseEntity<?> resposta;
        try {
            String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
            resposta = ResponseEntity.ok(servico.verificarUsuario(email, codigo));
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

}
