package br.upe.acs.repository;

import br.upe.acs.model.Requisicao;
import br.upe.acs.model.enums.EixoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequisicaoRepositorio extends JpaRepository<Requisicao, Long> {

	List<Requisicao> findByUsuarioId(Long usuarioId);

	@Query(
			"SELECT request FROM Requisicao request " +
					"WHERE request.arquivada " +
					"AND request.usuario.id = :userId " +
					"ORDER BY request.dataDeSubmissao"
	)
	List<Requisicao> findRequestsByUserIdAndArchived(Long userId);

	@Query(
			"SELECT request FROM Requisicao request " +
					"WHERE (request.statusRequisicao != 'RASCUNHO') " +
					"AND NOT request.arquivada " +
					"ORDER BY request.dataDeSubmissao"
	)
	List<Requisicao> findAllRequestsNotSketch();

	@Query(
			"SELECT request FROM Requisicao request " +
					"WHERE NOT request.arquivada " +
					"AND request.usuario.id = :userId " +
					"ORDER BY request.dataDeSubmissao"
	)
	List<Requisicao> findRequestsByUsuarioIdAndNotArchived(Long userId);

	@Query(
			"SELECT request FROM Requisicao request " +
					"WHERE NOT request.arquivada " +
					"AND request.usuario.id = :userId " +
					"AND EXISTS (SELECT 1 FROM Certificado certificate " +
					"WHERE certificate.requisicao.id = request.id " +
					"AND certificate.atividade.eixo = :axle)" +
					"ORDER BY request.dataDeSubmissao"
	)
	List<Requisicao> findRequestsByUserIdAndAxle(Long userId, EixoEnum axle);
}
