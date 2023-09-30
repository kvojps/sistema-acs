package br.upe.acs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.model.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {

}
