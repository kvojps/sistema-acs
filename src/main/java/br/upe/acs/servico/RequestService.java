package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.RequisicaoSimplesResposta;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.enums.EixoEnum;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import br.upe.acs.repositorio.RequisicaoRepositorio;
import br.upe.acs.exceptions.AcsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

import static br.upe.acs.utils.PaginationUtils.generateRequestsPagination;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequisicaoRepositorio repository;
    private final UserService userService;

    public List<Requisicao> listRequests() {
        return repository.findAll();
    }

    public List<Requisicao> listRequestByStudent(Long studentId) throws AcsException {
        Usuario student = userService.findUserById(studentId);
        return student.getRequisicoes();
    }

    public Map<String, Object> listRequestsPaginated(int page, int quantity) {

        List<RequisicaoSimplesResposta> requests = repository.findAll().stream()
                .filter(requisicao -> requisicao.getStatusRequisicao() != RequisicaoStatusEnum.RASCUNHO)
                .sorted(Comparator.comparing(Requisicao::getDataDeSubmissao).reversed())
                .map(RequisicaoSimplesResposta::new).toList();

        return generateRequestsPagination(requests, page, quantity);
    }

    public Map<String, Object> listStudentRequestsPaginatedByAxle(Long studentId, EixoEnum axle, int page, int amount)
            throws AcsException {
        List<Requisicao> requests = repository.findByUsuarioId(studentId);

        List<RequisicaoSimplesResposta> studentRequests = requests.stream()
                .filter(request -> request.getStatusRequisicao() != RequisicaoStatusEnum.RASCUNHO)
                .filter(request -> !request.isArquivada())
                .filter(
                        request -> request.getCertificados().stream()
                                .anyMatch(certificado -> certificado.getAtividade().getEixo().equals(axle)))
                .sorted(Comparator.comparing(Requisicao::getStatusRequisicao).reversed())
                .map(RequisicaoSimplesResposta::new).toList();

        return generateRequestsPagination(studentRequests, page, amount);
    }

    public Requisicao findRequestById(Long id) throws AcsException {
        return repository.findById(id).orElseThrow(() -> new AcsException("Request not found"));
    }

    public void archiveRequest(Long id, String email) throws AcsException {
        boolean isFinished = false;
        Requisicao requisicao = repository.findById(id).orElseThrow(() -> new AcsException("Request not found"));
        Usuario usuario = userService.findUserByEmail(email);
        RequisicaoStatusEnum status = requisicao.getStatusRequisicao();

        if (!usuario.equals(requisicao.getUsuario())) {
            throw new AcsException("User not authorized to archive this request");
        }
        if (status == RequisicaoStatusEnum.ACEITO || status == RequisicaoStatusEnum.NEGADO) {
            isFinished = true;
        }
        if (!isFinished) {
            throw new AcsException("Unable to archive an unfinished request");
        }

        if (!requisicao.isArquivada()) {
            requisicao.setArquivada(true);
            repository.save(requisicao);
        } else {
            throw new AcsException("Request already archived");
        }
    }

    public void unarchiveRequest(Long id, String email) throws AcsException {
        Requisicao request = repository.findById(id).orElseThrow();
        Usuario usuario = userService.findUserByEmail(email);

        if (!usuario.equals(request.getUsuario())) {
            throw new AcsException("User not authorized to unarchive this request");
        }

        if (request.isArquivada()) {
            request.setArquivada(false);
            repository.save(request);
        } else {
            throw new AcsException("The request is not archived");
        }
    }

    public List<Requisicao> listArchivedRequests(String email) throws AcsException {
        Usuario student = userService.findUserByEmail(email);

        return student.getRequisicoes().stream().filter(Requisicao::isArquivada).toList();
    }

}
