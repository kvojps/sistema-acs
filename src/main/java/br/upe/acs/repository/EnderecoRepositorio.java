package br.upe.acs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.model.Endereco;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {

}
