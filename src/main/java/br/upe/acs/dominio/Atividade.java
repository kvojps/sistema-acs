package br.upe.acs.dominio;

import java.util.List;

import br.upe.acs.dominio.enums.EixoEnum;
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

	private int chMaxima;

	@OneToMany(mappedBy = "atividade")
	private List<Certificado> certificados;

    private String criteriosParaAvaliacao;

    private String chPorCertificado;
}
