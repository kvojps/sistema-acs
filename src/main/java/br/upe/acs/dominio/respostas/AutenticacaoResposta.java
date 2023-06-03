package br.upe.acs.dominio.respostas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AutenticacaoResposta {

	private String token;
}
