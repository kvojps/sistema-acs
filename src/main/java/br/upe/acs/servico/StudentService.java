package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.RequisicaoSimplesResposta;
import br.upe.acs.dominio.Atividade;
import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.vo.AtividadeComplementarVO;
import br.upe.acs.dominio.vo.MinhasHorasNaAtividadeVO;
import br.upe.acs.repositorio.UsuarioRepositorio;
import br.upe.acs.exceptions.AcsException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.*;

import static br.upe.acs.utils.PaginationUtils.generateRequestsPagination;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final UsuarioRepositorio repository;
    private final ActivityService activityService;

    public Map<String, Object> listRequestsPaginated(int page, String email, int amount) throws AcsException {
        Usuario student = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this id"));

        List<RequisicaoSimplesResposta> studentRequests = new ArrayList<>(student.getRequisicoes().stream()
                .filter(requisicao -> !requisicao.isArquivada())
                .sorted(Comparator.comparing(Requisicao::getStatusRequisicao))
                .map(RequisicaoSimplesResposta::new).toList());
        return generateRequestsPagination(studentRequests, page, amount);
    }

    public AtividadeComplementarVO generateStudentAcs(String email) throws AcsException {
        Usuario student = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this id"));

        return new AtividadeComplementarVO(student);
    }

    public MinhasHorasNaAtividadeVO generateHoursAcsStatusByActivity(String email, Long activityId) throws AcsException {
        Atividade atividade = activityService.findActivityById(activityId);

        Usuario student = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this id"));

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
