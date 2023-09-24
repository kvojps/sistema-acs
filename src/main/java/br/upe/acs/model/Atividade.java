package br.upe.acs.model;

import java.util.List;

import br.upe.acs.model.enums.EixoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	private EixoEnum eixo;

	private String descricao;

	private String criteriosParaAvaliacao;

	private int chMaxima;

    private Integer chPorCertificado;

	@OneToMany(mappedBy = "atividade")
	private List<Certificado> certificados;

}
