package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.RequisicaoSimplesResposta;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import br.upe.acs.repositorio.RequisicaoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequisicaoRepositorio repository;
    private final UserService userService;

    public List<Requisicao> listRequests() {
        return repository.findAll();
    }

    public List<Requisicao> listRequestByStudent(Long studentId) throws AcsExcecao {
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

    public Requisicao findRequestById(Long id) throws AcsExcecao {
        return repository.findById(id).orElseThrow(() -> new AcsExcecao("Request not found"));
    }

    public void archiveRequest(Long id, String email) throws AcsExcecao {
        boolean isFinished = false;
        Requisicao requisicao = repository.findById(id).orElseThrow(() -> new AcsExcecao("Request not found"));
        Usuario usuario = userService.findUserByEmail(email);
        RequisicaoStatusEnum status = requisicao.getStatusRequisicao();

        if (!usuario.equals(requisicao.getUsuario())) {
            throw new AcsExcecao("User not authorized to archive this request");
        }
        if (status == RequisicaoStatusEnum.ACEITO || status == RequisicaoStatusEnum.NEGADO) {
            isFinished = true;
        }
        if (!isFinished) {
            throw new AcsExcecao("Unable to archive an unfinished request");
        }

        if (!requisicao.isArquivada()) {
            requisicao.setArquivada(true);
            repository.save(requisicao);
        } else {
            throw new AcsExcecao("Request already archived");
        }
    }

    public void unarchiveRequest(Long id, String email) throws AcsExcecao {
        Requisicao request = repository.findById(id).orElseThrow();
        Usuario usuario = userService.findUserByEmail(email);

        if (!usuario.equals(request.getUsuario())) {
            throw new AcsExcecao("User not authorized to unarchive this request");
        }

        if (request.isArquivada()) {
            request.setArquivada(false);
            repository.save(request);
        } else {
            throw new AcsExcecao("The request is not archived");
        }
    }

    public List<Requisicao> listArchivedRequests(String email) throws AcsExcecao {
        Usuario student = userService.findUserByEmail(email);

        return student.getRequisicoes().stream().filter(Requisicao::isArquivada).toList();
    }

    //TODO: Change this method to utils
    protected static Map<String, Object> generateRequestsPagination(List<RequisicaoSimplesResposta> list, int page, int amount) {
        Map<String, Object> response = new HashMap<>();
        response.put("requisicoes", generatePagination(list, page, amount));
        response.put("paginaAtual", page);
        response.put("totalItens", list.size());
        response.put("totalPaginas", Math.floorDiv(list.size(), amount) + (list.size() % amount == 0 ? 0 : 1));

        return response;
    }

    //TODO: Change this method to utils
    private static <T> List<T> generatePagination(List<T> list, int page, int amount) {
        int starts = page * amount;
        int end = Math.min(starts + amount, list.size());

        if (starts >= end) {
            return Collections.emptyList();
        }

        return list.subList(starts, end);
    }
}
