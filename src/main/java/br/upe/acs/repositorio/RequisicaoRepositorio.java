package br.upe.acs.repositorio;

import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequisicaoRepositorio extends JpaRepository<Requisicao, Long> {
	List<Requisicao> findByUsuario(Usuario usuario);
}
