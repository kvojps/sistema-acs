package br.upe.acs.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.upe.acs.dominio.dto.ProtocoloFullDTO;
import br.upe.acs.servico.ProtocoloServico;

@RestController
@RequestMapping("api/protocolo")
@CrossOrigin
public class ProtocoloControlador {
	
	@Autowired
	private ProtocoloServico servico;
	
	@PostMapping(consumes = {"multipart/form-data"})
	public ResponseEntity<?> adicionarProtocolo(
			@RequestPart(value="protocolo", required=true) MultipartFile protocolo,
			@RequestPart(value="certificados", required=true) MultipartFile[] certificados,
			@RequestPart(value="protocoloJson", required=true) MultipartFile protocoloJson
			){
		ProtocoloFullDTO protocoloDTO = new ProtocoloFullDTO();
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
