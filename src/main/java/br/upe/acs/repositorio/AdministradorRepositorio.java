package br.upe.acs.repositorio;

import br.upe.acs.dominio.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministradorRepositorio extends JpaRepository<Administrador, Long> {
    Optional<Administrador> findByEmail(String email);

    Optional<AdministradorRepositorio> findByCpf(String cpf);
}
