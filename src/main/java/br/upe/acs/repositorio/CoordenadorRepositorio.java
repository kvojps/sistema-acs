package br.upe.acs.repositorio;

import br.upe.acs.dominio.Comissao;
import br.upe.acs.dominio.Coordenador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoordenadorRepositorio extends JpaRepository<Coordenador, Long> {
    Optional<Coordenador> findByEmail(String email);

    Optional<Coordenador> findByCpf(String cpf);
}
