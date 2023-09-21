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
public class ReadRequestsUseCase {

    private final RequisicaoRepositorio repository;
    private final UserService userService;

    //TODO: Adicionar paginação
    public List<Requisicao> listRequests() {
        return repository.findAll();
    }

    //TODO: Configurar uma query JPA para fazer esta busca
    public List<Requisicao> listArchivedRequests(String email) throws AcsException {
        Usuario student = userService.findUserByEmail(email);

        return student.getRequisicoes().stream().filter(Requisicao::isArquivada).toList();
    }

    //TODO: Configurar uma query JPA para fazer esta busca
    public Map<String, Object> listNonSketchRequests(int page, int quantity) {

        List<RequisicaoSimplesResposta> requests = repository.findAll().stream()
                .filter(requisicao -> requisicao.getStatusRequisicao() != RequisicaoStatusEnum.RASCUNHO)
                .sorted(Comparator.comparing(Requisicao::getDataDeSubmissao).reversed())
                .map(RequisicaoSimplesResposta::new).toList();

        return generateRequestsPagination(requests, page, quantity);
    }

    //TODO: Adicionar paginação
    public List<Requisicao> listRequestByStudent(Long studentId) throws AcsException {
        Usuario student = userService.findUserById(studentId);
        return student.getRequisicoes();
    }

    //TODO: Configurar uma query JPA para fazer esta busca
    public Map<String, Object> listStudentUnarchivedRequests(int page, String email, int amount) throws AcsException {
        Usuario student = userService.findUserByEmail(email);

        List<RequisicaoSimplesResposta> studentRequests = new ArrayList<>(student.getRequisicoes().stream()
                .filter(requisicao -> !requisicao.isArquivada())
                .sorted(Comparator.comparing(Requisicao::getStatusRequisicao))
                .map(RequisicaoSimplesResposta::new).toList());
        return generateRequestsPagination(studentRequests, page, amount);
    }

    //TODO: Configurar uma query no JPA para fazer esta busca
    public Map<String, Object> listStudentRequestsByAxle(Long studentId, EixoEnum axle, int page, int amount) {
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
}
