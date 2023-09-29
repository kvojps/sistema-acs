package br.upe.acs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.model.Address;

public interface EnderecoRepositorio extends JpaRepository<Address, Long> {

}
