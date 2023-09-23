package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.RequisicaoSimplesResposta;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.enums.EixoEnum;
import br.upe.acs.repositorio.RequisicaoRepositorio;
import br.upe.acs.exceptions.AcsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

import static br.upe.acs.utils.PaginationUtils.generatePagination;

@Service
@RequiredArgsConstructor
public class ReadRequestsUseCase {

    private final RequisicaoRepositorio repository;

    public Map<String, Object> listRequests(int page, int amount) {
        List<RequisicaoSimplesResposta> requests = repository.findAll().stream()
                .map(RequisicaoSimplesResposta::new).toList();
        return generatePagination(requests, page, amount);
    }

    public List<Requisicao> listArchivedRequests(Long studentId) {
        return repository.findRequestsByUserIdAndArchived(studentId);
    }

    public Map<String, Object> listNonSketchRequests(int page, int quantity) {
        List<RequisicaoSimplesResposta> requests = repository.findAllRequestsNotSketch().stream()
                .map(RequisicaoSimplesResposta::new).toList();

        return generatePagination(requests, page, quantity);
    }

    public Map<String, Object> listRequestByStudent(Long studentId, int page, int amount) {
        List<RequisicaoSimplesResposta> studentRequests = repository.findByUsuarioId(studentId).stream()
                .map(RequisicaoSimplesResposta::new).toList();
        return generatePagination(studentRequests, page, amount);
    }

    public Map<String, Object> listStudentUnarchivedRequests(Long studentId, int page, int amount) {
        List<RequisicaoSimplesResposta> studentRequests = repository
                .findRequestsByUsuarioIdAndNotArchived(studentId).stream()
                .sorted(Comparator.comparing(Requisicao::getStatusRequisicao))
                .map(RequisicaoSimplesResposta::new).toList();

        return generatePagination(studentRequests, page, amount);
    }

    public Map<String, Object> listStudentRequestsByAxle(Long studentId, EixoEnum axle, int page, int amount) {

        List<RequisicaoSimplesResposta> studentRequests = repository.findRequestsByUserIdAndAxle(studentId, axle)
                .stream().map(RequisicaoSimplesResposta::new).toList();

        return generatePagination(studentRequests, page, amount);
    }

    public Requisicao findRequestById(Long id) {
        return repository.findById(id).orElseThrow(() -> new AcsException("Request not found"));
    }
}
