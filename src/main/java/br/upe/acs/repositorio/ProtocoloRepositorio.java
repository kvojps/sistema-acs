package br.upe.acs.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.dominio.Protocolo;

public interface ProtocoloRepositorio extends JpaRepository<Protocolo, Long> {

}
