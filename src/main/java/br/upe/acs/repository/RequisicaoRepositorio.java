package br.upe.acs.repository;

import br.upe.acs.model.Course;
import br.upe.acs.model.Requisicao;
import br.upe.acs.model.User;
import br.upe.acs.model.enums.AxleEnum;
import br.upe.acs.model.enums.RequisicaoStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequisicaoRepositorio extends JpaRepository<Requisicao, Long> {

	@Query("SELECT r FROM Requisicao r " +
			"WHERE (:arquivada IS NULL OR r.arquivada = :arquivada) " +
			"AND (:statusRequisicao IS NULL OR r.statusRequisicao = :statusRequisicao) " +
			"AND (:userId IS NULL OR r.user.id = :userId) " +
			"AND (:courseId IS NULL OR r.user.course.id = :courseId)")
	List<Requisicao> findWithFilters(
			Boolean arquivada, RequisicaoStatusEnum statusRequisicao, Long userId, Long courseId);

	@Query(
			"SELECT request FROM Requisicao request " +
					"WHERE NOT request.arquivada " +
					"AND request.user.id = :userId " +
					"AND EXISTS (SELECT 1 FROM Certificado certificate " +
					"WHERE certificate.requisicao.id = request.id " +
					"AND certificate.activity.axle = :axle)" +
					"ORDER BY request.dataDeSubmissao"
	)
	List<Requisicao> findRequestsByUserIdAndAxle(Long userId, AxleEnum axle);
}
