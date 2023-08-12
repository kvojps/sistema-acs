package br.upe.acs.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.dominio.Atividade;
import br.upe.acs.dominio.enums.EixoEnum;

public interface AtividadeRepositorio extends JpaRepository<Atividade, Long> {
	List<Atividade> findByEixo(EixoEnum eixo);

}
