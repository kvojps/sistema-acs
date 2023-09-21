package br.upe.acs.repositorio;

import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.enums.EixoEnum;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequisicaoRepositorio extends JpaRepository<Requisicao, Long> {

	List<Requisicao> findByUsuarioId(Long usuarioId);

}
