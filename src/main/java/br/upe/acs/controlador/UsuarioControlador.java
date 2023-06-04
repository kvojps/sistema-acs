package br.upe.acs.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.upe.acs.servico.UsuarioServico;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
@CrossOrigin
public class UsuarioControlador {
	
	private final UsuarioServico servico;

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
