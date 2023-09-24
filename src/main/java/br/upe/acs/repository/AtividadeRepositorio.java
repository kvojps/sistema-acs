package br.upe.acs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.model.Atividade;
import br.upe.acs.model.enums.EixoEnum;

public interface AtividadeRepositorio extends JpaRepository<Atividade, Long> {
	List<Atividade> findByEixo(EixoEnum eixo);

}
