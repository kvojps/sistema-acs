package br.upe.acs.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.upe.acs.dominio.Protocolo;
import br.upe.acs.dominio.dto.ProtocoloDTO;
import br.upe.acs.servico.ProtocoloServico;

@RestController
@RequestMapping("api/protocolo")
@CrossOrigin
public class ProtocoloControlador {
	
	@Autowired
	private ProtocoloServico servico;
	
	@GetMapping
	public ResponseEntity<List<Protocolo>> listarProtocolos() {
		return ResponseEntity.ok(servico.listarProtocolos());
	}
	
	//adicionar cursoID
	@PostMapping(consumes = {"multipart/form-data"})
	public ResponseEntity<?> adicionarProtocolo(
			@RequestParam(value="data", required=true) String data,
			@RequestParam(value="semestre", required=true) int semestre,
			@RequestParam(value="qtdCertificados", required=true) int qtdCertificados,
			@RequestPart(value="protocolo", required=true) MultipartFile protocolo,
			@RequestPart(value="certificados", required=true) MultipartFile[] certificados,
			@RequestPart(value="protocoloJson", required=true) MultipartFile protocoloJson
			){
		ProtocoloDTO protocoloDTO = new ProtocoloDTO();
		protocoloDTO.setData(data);
		protocoloDTO.setSemestre(semestre);
		protocoloDTO.setQtdCertificados(qtdCertificados);
		protocoloDTO.setProtocolo(protocolo);
		protocoloDTO.setCertificados(certificados);
		protocoloDTO.setProtocoloJson(protocoloJson);
		
		try {
			return ResponseEntity.ok(servico.adicionarProtocolo(protocoloDTO));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
