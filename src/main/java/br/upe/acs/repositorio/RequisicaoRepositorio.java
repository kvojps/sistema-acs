package br.upe.acs.repositorio;

import br.upe.acs.dominio.Aluno;
import br.upe.acs.dominio.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequisicaoRepositorio extends JpaRepository<Requisicao, Long> {
	List<Requisicao> findByAluno(Aluno aluno);
}
