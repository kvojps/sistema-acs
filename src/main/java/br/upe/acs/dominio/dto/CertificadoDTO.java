package br.upe.acs.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CertificadoDTO {

	private String descricao;
	
	private String data;
	
	private int semestre;
	
	private int horas;
	
	private int chMaxima;
	
	private int chTotal;
	
	private Long certificadoId;
	
	private Long protocoloId;
}
