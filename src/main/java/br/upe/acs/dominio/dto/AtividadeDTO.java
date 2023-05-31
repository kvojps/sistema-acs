package br.upe.acs.dominio.dto;

import br.upe.acs.dominio.enums.EixoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtividadeDTO {
	
	private EixoEnum eixo;
	
	private String descricao;
}
