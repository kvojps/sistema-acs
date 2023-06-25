package br.upe.acs.repositorio;

import java.util.List;

import br.upe.acs.dominio.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.Usuario;

public interface RequisicaoRepositorio extends JpaRepository<Requisicao, Long> {
	List<Requisicao> findByAluno(Aluno aluno);
}
