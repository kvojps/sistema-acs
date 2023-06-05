package br.upe.acs.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.upe.acs.controlador.respostas.UsuarioResposta;
import br.upe.acs.servico.UsuarioServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
@CrossOrigin
public class UsuarioControlador {

	private final UsuarioServico servico;

	@Operation(summary = "Buscar usuário por id")
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResposta> buscarUsuarioPorId(@PathVariable("id") Long id) throws AcsExcecao {
		UsuarioResposta usuarioResposta = new UsuarioResposta(servico.buscarUsuarioPorId(id).get());

		return ResponseEntity.ok(usuarioResposta);
	}

	@Operation(summary = "Verificar usuário")
	@PostMapping("/verificacao")
	public ResponseEntity<?> verificarUsuario(@RequestParam(value = "usuarioId", required = true) Long usuarioId,
			@RequestParam(value = "codigoVerificacao", required = true) String codigo) {
		try {
			return ResponseEntity.ok(servico.verificarUsuario(usuarioId, codigo));
		} catch (AcsExcecao e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
