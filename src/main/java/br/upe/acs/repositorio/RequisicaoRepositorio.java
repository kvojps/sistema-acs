package br.upe.acs.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.dominio.Requisicao;

public interface RequisicaoRepositorio extends JpaRepository<Requisicao, Long> {

}
