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

import br.upe.acs.controlador.respostas.ProtocoloResposta;
import br.upe.acs.dominio.dto.ProtocoloDTO;
import br.upe.acs.servico.ProtocoloCertificadoServico;
import br.upe.acs.servico.ProtocoloServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/protocolo")
@RequiredArgsConstructor
@CrossOrigin
public class ProtocoloControlador {

	private final ProtocoloServico servico;

	private final ProtocoloCertificadoServico protocoloCertificadoServico;

	@Operation(summary = "Listar todos os protocolos")
	@GetMapping
	public ResponseEntity<List<ProtocoloResposta>> listarProtocolos() {
		return ResponseEntity.ok(servico.listarProtocolos().stream().map(protocolo -> new ProtocoloResposta(protocolo))
				.collect(Collectors.toList()));
	}

	@Operation(summary = "Buscar protocolo por id")
	@GetMapping("/{id}")
	public ResponseEntity<ProtocoloResposta> buscarProtocoloPorId(@PathVariable("id") Long id) throws AcsExcecao {
		ProtocoloResposta protocoloResposta = new ProtocoloResposta(servico.buscarProtocoloPorId(id).get());

		return ResponseEntity.ok(protocoloResposta);
	}

	@Operation(summary = "Adicionar protocolo com certificados")
	@PostMapping(consumes = { "multipart/form-data" })
	public ResponseEntity<?> adicionarProtocolo(@RequestParam(value = "data", required = true) String data,
			@RequestParam(value = "usuarioId", required = true) Long usuarioId,
			@RequestParam(value = "cursoId", required = true) Long cursoId,
			@RequestParam(value = "semestre", required = true) int semestre,
			@RequestParam(value = "qtdCertificados", required = true) int qtdCertificados,
			@RequestPart(value = "protocolo", required = true) MultipartFile protocolo,
			@RequestPart(value = "certificados", required = true) MultipartFile[] certificados,
			@RequestPart(value = "certificadosMetadados", required = true) MultipartFile certificadosMetadados) {
		ProtocoloDTO protocoloDTO = new ProtocoloDTO();
		protocoloDTO.setCursoId(cursoId);
		protocoloDTO.setUsuarioId(usuarioId);
		protocoloDTO.setData(data);
		protocoloDTO.setSemestre(semestre);
		protocoloDTO.setQtdCertificados(qtdCertificados);
		protocoloDTO.setProtocolo(protocolo);
		protocoloDTO.setCertificados(certificados);
		protocoloDTO.setCertificadosMetadados(certificadosMetadados);

		try {
			return ResponseEntity.ok(protocoloCertificadoServico.adicionarProtocolo(protocoloDTO));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
