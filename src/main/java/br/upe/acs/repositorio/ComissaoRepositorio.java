package br.upe.acs.repositorio;

import br.upe.acs.dominio.Comissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComissaoRepositorio extends JpaRepository<Comissao, Long> {
    Optional<Comissao> findByEmail(String email);

    Optional<Comissao> findByCpf(String cpf);
}
