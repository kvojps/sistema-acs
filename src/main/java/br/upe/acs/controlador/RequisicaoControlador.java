package br.upe.acs.controlador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.upe.acs.controlador.respostas.RequisicaoResposta;
import br.upe.acs.dominio.dto.RequisicaoDTO;
import br.upe.acs.servico.RequisicaoCertificadoServico;
import br.upe.acs.servico.RequisicaoServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/requisicao")
@RequiredArgsConstructor
@CrossOrigin
public class RequisicaoControlador {

	private final RequisicaoServico servico;

	private final RequisicaoCertificadoServico requisicaoCertificadoServico;

	@Operation(summary = "Listar todas as requisições")
	@GetMapping
	public ResponseEntity<List<RequisicaoResposta>> listarRequisicoes() {
		return ResponseEntity.ok(servico.listarRequisicoes().stream()
				.map(requisicao -> new RequisicaoResposta(requisicao)).collect(Collectors.toList()));
	}

	@Operation(summary = "Buscar requisição por id")
	@GetMapping("/{id}")
	public ResponseEntity<RequisicaoResposta> buscarRequisicaoPorId(@PathVariable("id") Long id) throws AcsExcecao {
		RequisicaoResposta requisicaoResposta = new RequisicaoResposta(servico.buscarRequisicaoPorId(id).get());

		return ResponseEntity.ok(requisicaoResposta);
	}

	@Operation(summary = "Adicionar requisição com certificados")
	@PostMapping(consumes = { "multipart/form-data" })
	public ResponseEntity<?> adicionarRequisicao(@RequestParam(value = "usuarioId", required = true) Long usuarioId,
			@RequestParam(value = "cursoId", required = true) Long cursoId,
			@RequestParam(value = "semestre", required = true) int semestre,
			@RequestParam(value = "qtdCertificados", required = true) int qtdCertificados,
			@RequestPart(value = "certificados", required = true) MultipartFile[] certificados,
			@RequestPart(value = "certificadosMetadados", required = true) MultipartFile certificadosMetadados) {
		RequisicaoDTO requisicaoDTO = new RequisicaoDTO();
		requisicaoDTO.setCursoId(cursoId);
		requisicaoDTO.setUsuarioId(usuarioId);
		requisicaoDTO.setSemestre(semestre);
		requisicaoDTO.setQtdCertificados(qtdCertificados);
		requisicaoDTO.setCertificados(certificados);
		requisicaoDTO.setCertificadosMetadados(certificadosMetadados);

		try {
			return ResponseEntity.ok(requisicaoCertificadoServico.adicionarRequisicao(requisicaoDTO));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
