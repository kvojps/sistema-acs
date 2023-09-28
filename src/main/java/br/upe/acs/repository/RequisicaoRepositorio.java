package br.upe.acs.repository;

import br.upe.acs.model.Curso;
import br.upe.acs.model.Requisicao;
import br.upe.acs.model.Usuario;
import br.upe.acs.model.enums.AxleEnum;
import br.upe.acs.model.enums.RequisicaoStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequisicaoRepositorio extends JpaRepository<Requisicao, Long> {

	@Query("SELECT r FROM Requisicao r " +
			"WHERE (:arquivada IS NULL OR r.arquivada = :arquivada) " +
			"AND (:statusRequisicao IS NULL OR r.statusRequisicao = :statusRequisicao) " +
			"AND (:usuario IS NULL OR r.usuario = :usuario) " +
			"AND (:curso IS NULL OR r.curso = :curso)")
	List<Requisicao> findWithFilters(
			Boolean arquivada, RequisicaoStatusEnum statusRequisicao, Usuario usuario, Curso curso);

	@Query(
			"SELECT request FROM Requisicao request " +
					"WHERE NOT request.arquivada " +
					"AND request.usuario.id = :userId " +
					"AND EXISTS (SELECT 1 FROM Certificado certificate " +
					"WHERE certificate.requisicao.id = request.id " +
					"AND certificate.activity.axle = :axle)" +
					"ORDER BY request.dataDeSubmissao"
	)
	List<Requisicao> findRequestsByUserIdAndAxle(Long userId, AxleEnum axle);
}
