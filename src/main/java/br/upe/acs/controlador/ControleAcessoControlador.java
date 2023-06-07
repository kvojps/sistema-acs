package br.upe.acs.controlador;

import br.upe.acs.utils.AcsExcecao;
import jakarta.validation.Valid;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.upe.acs.controlador.respostas.AutenticacaoResposta;
import br.upe.acs.dominio.dto.LoginDTO;
import br.upe.acs.dominio.dto.RegistroDTO;
import br.upe.acs.servico.ControleAcessoServico;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RestController
@RequestMapping("api/acesso/auth")
@RequiredArgsConstructor
@CrossOrigin
public class ControleAcessoControlador {
	
	private final ControleAcessoServico servico;
	
	@Operation(summary = "Cadastro de usuário")
	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastrarUsuario(@Valid @RequestBody RegistroDTO registro, BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors()) {
				throw new AcsExcecao(String.join("; ", bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList()));
			}
			return ResponseEntity.ok(servico.cadastrarUsuario(registro));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@Operation(summary = "Login de usuário")
	@PostMapping("/login")
	public ResponseEntity<AutenticacaoResposta> loginUsuario(@RequestBody LoginDTO login) {
		return ResponseEntity.ok(servico.loginUsuario(login));
	}
}
