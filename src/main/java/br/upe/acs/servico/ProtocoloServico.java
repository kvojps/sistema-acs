package br.upe.acs.servico;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.upe.acs.dominio.Protocolo;
import br.upe.acs.dominio.dto.CertificadoDTO;
import br.upe.acs.dominio.dto.ProtocoloDTO;
import br.upe.acs.dominio.dto.ProtocoloFullDTO;
import br.upe.acs.repositorio.ProtocoloRepositorio;

@Service
public class ProtocoloServico {
	
	@Autowired
	private CertificadoServico certificadoServico;
	
	@Autowired
	private ProtocoloRepositorio repositorio;
	
	public String adicionarProtocolo(ProtocoloFullDTO protocolo) throws IOException {
		byte[] protocoloArquivo = protocolo.getProtocolo().getBytes();
		byte[] protocoloJsonBytes = protocolo.getProtocoloJson().getBytes();
		
		ProtocoloDTO protocoloJson = converter(protocoloJsonBytes);
		
		Protocolo protocoloSalvar = new Protocolo();
		protocoloSalvar.setData(null);
		protocoloSalvar.setSemestre(protocolo.getSemestre());
		protocoloSalvar.setQtdCertificados(protocolo.getQtdCertificados());
		protocoloSalvar.setProtocoloArquivo(protocoloArquivo);
		
		Protocolo protocoloSalvo = repositorio.save(protocoloSalvar);
		
		MultipartFile[] certificadoArquivos = protocolo.getCertificados();
		List<CertificadoDTO> certificados = protocoloJson.getCertificados();
		
		for (int i = 0; i < certificadoArquivos.length; i++) {
			
			MultipartFile certificadoArquivoSalvar = certificadoArquivos[i];
			CertificadoDTO certificadoSalvar = certificados.get(i);
			certificadoSalvar.setProtocoloId(protocoloSalvo.getId());
			
			certificadoServico.adicionarCertificado(certificadoSalvar, certificadoArquivoSalvar);
		}
		
		return "token";
	}
	
	private ProtocoloDTO converter(byte[] protocoloJson) throws StreamReadException, DatabindException, IOException {
		String jsonString = new String(protocoloJson);
		
		ObjectMapper objectMapper = new ObjectMapper();
		ProtocoloDTO protocolo = objectMapper.readValue(jsonString, ProtocoloDTO.class);
		
		return protocolo;
	}
}
