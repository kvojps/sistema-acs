package br.upe.acs.controlador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.upe.acs.controlador.respostas.AtividadeResposta;
import br.upe.acs.servico.AtividadeServico;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/atividade")
@RequiredArgsConstructor
@CrossOrigin
public class AtividadeControlador {

	private final AtividadeServico servico;

	@GetMapping
	public ResponseEntity<List<AtividadeResposta>> listarAtividades() {
		return ResponseEntity.ok(servico.listarAtividades().stream().map(atividade -> new AtividadeResposta(atividade))
				.collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<AtividadeResposta> buscarAtividadePorId(@PathVariable("id") Long id) throws AcsExcecao {
		AtividadeResposta atividadeResposta = new AtividadeResposta(servico.buscarAtividadePorId(id).get());

		return ResponseEntity.ok(atividadeResposta);
	}
}
