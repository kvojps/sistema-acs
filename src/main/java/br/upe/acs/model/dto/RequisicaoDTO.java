package br.upe.acs.model.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequisicaoDTO {
	
	private int semestre;
	
	private int qtdCertificados;
	
	private String observacao;
	
	private Long usuarioId;
	
	private MultipartFile[] certificados;
	
	private MultipartFile certificadosMetadados;
}
