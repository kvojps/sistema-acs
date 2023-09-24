package br.upe.acs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.model.Curso;

public interface CursoRepositorio extends JpaRepository<Curso, Long>{

}
