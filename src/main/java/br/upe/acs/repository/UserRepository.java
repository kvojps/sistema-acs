package br.upe.acs.repository;

import br.upe.acs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByCpf(String cpf);

}
