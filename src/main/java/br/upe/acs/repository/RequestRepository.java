package br.upe.acs.repository;

import br.upe.acs.model.Request;
import br.upe.acs.model.enums.AxleEnum;
import br.upe.acs.model.enums.RequestStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

	@Query("SELECT r FROM Request r " +
			"WHERE (:arquivada IS NULL OR r.archived = :arquivada) " +
			"AND (:statusRequisicao IS NULL OR r.status = :statusRequisicao) " +
			"AND (:userId IS NULL OR r.user.id = :userId) " +
			"AND (:courseId IS NULL OR r.user.course.id = :courseId)")
	List<Request> findWithFilters(
            Boolean arquivada, RequestStatusEnum statusRequisicao, Long userId, Long courseId);

	@Query(
			"SELECT request FROM Request request " +
					"WHERE NOT request.archived " +
					"AND request.user.id = :userId " +
					"AND EXISTS (SELECT 1 FROM Certificate certificate " +
					"WHERE certificate.request.id = request.id " +
					"AND certificate.activity.axle = :axle)" +
					"ORDER BY request.sentIn"
	)
	List<Request> findRequestsByUserIdAndAxle(Long userId, AxleEnum axle);
}
