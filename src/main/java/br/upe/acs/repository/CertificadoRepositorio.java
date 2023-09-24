package br.upe.acs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.model.Certificado;

public interface CertificadoRepositorio extends JpaRepository<Certificado, Long> {

}
