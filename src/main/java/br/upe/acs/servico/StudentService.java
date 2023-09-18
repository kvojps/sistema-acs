package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.CertificadoResposta;
import br.upe.acs.controlador.respostas.RequisicaoSimplesResposta;
import br.upe.acs.dominio.Atividade;
import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.enums.EixoEnum;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import br.upe.acs.dominio.vo.AtividadeComplementarVO;
import br.upe.acs.dominio.vo.MinhasHorasNaAtividadeVO;
import br.upe.acs.repositorio.UsuarioRepositorio;
import br.upe.acs.utils.AcsExcecao;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.*;

import static br.upe.acs.servico.RequestService.generateRequestsPagination;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final UsuarioRepositorio repository;
    private final ActivityService activityService;

    public Map<String, Object> listRequestsPaginated(int page, String email, int amount) throws AcsExcecao {
        Usuario student = repository.findByEmail(email).orElseThrow(() ->
                new AcsExcecao("There is no user associated with this id"));

        List<RequisicaoSimplesResposta> studentRequests = new ArrayList<>(student.getRequisicoes().stream()
                .filter(requisicao -> !requisicao.isArquivada())
                .sorted(Comparator.comparing(Requisicao::getStatusRequisicao))
                .map(RequisicaoSimplesResposta::new).toList());
        return generateRequestsPagination(studentRequests, page, amount);
    }

    //TODO: ADD TO CONTROLLER
    //TODO: REFACTOR THIS METHOD TO USE JUST REPO
    public Map<String, Object> listStudentRequestsPaginatedByAxle(Long studentId, EixoEnum axle, int page, int amount)
            throws AcsExcecao {

        Optional<Usuario> student = repository.findById(studentId);
        List<Requisicao> requests = student.orElseThrow(() -> new AcsExcecao("")).getRequisicoes().stream()
                .filter(requisicao -> requisicao.getStatusRequisicao() != RequisicaoStatusEnum.RASCUNHO).toList();

        List<Requisicao> requestFiltered = new ArrayList<>();
        List<CertificadoResposta> certificates;

        for (Requisicao req : requests) {
            certificates = req.getCertificados().stream()
                    .filter(certificado -> certificado.getAtividade().getEixo().equals(axle))
                    .map(CertificadoResposta::new).toList();
            if (!certificates.isEmpty()) {
                requestFiltered.add(req);
            }
        }

        List<RequisicaoSimplesResposta> studentRequests = new ArrayList<>(requestFiltered.stream()
                .map(RequisicaoSimplesResposta::new).toList());


        return generateRequestsPagination(studentRequests, page, amount);
    }

    public AtividadeComplementarVO generateStudentAcs(String email) throws AcsExcecao {
        Usuario student = repository.findByEmail(email).orElseThrow(() ->
                new AcsExcecao("There is no user associated with this id"));

        return new AtividadeComplementarVO(student);
    }

    public MinhasHorasNaAtividadeVO generateHoursAcsStatusByActivity(String email, Long activityId) throws AcsExcecao {
        Atividade atividade = activityService.findActivityById(activityId);

        Usuario student = repository.findByEmail(email).orElseThrow(() ->
                new AcsExcecao("There is no user associated with this id"));

        return calculateActivityHours(student, atividade.getChMaxima());
    }

    private MinhasHorasNaAtividadeVO calculateActivityHours(Usuario student, int chMax) {
        float sketchHours = 0;
        float progressHours = 0;
        float acceptedHours = 0;
        float problemHours = 0;
        for (Requisicao request : student.getRequisicoes()) {
            for (Certificado certificate : request.getCertificados()) {
                switch (certificate.getStatusCertificado()) {
                    case RASCUNHO -> sketchHours += certificate.getCargaHoraria();
                    case PROBLEMA -> problemHours += certificate.getCargaHoraria();
                    case CONCLUIDO -> acceptedHours += certificate.getCargaHoraria();
                    default -> progressHours += certificate.getCargaHoraria();
                }
            }
        }

        float remainingHours = chMax - (acceptedHours + progressHours + sketchHours + problemHours);

        return new MinhasHorasNaAtividadeVO(acceptedHours, progressHours, sketchHours, problemHours, remainingHours);
    }
}
