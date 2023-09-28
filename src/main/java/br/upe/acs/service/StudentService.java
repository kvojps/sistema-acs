package br.upe.acs.service;

import br.upe.acs.model.Activity;
import br.upe.acs.model.Certificado;
import br.upe.acs.model.Requisicao;
import br.upe.acs.model.Usuario;
import br.upe.acs.model.vo.AtividadeComplementarVO;
import br.upe.acs.model.vo.MinhasHorasNaAtividadeVO;
import br.upe.acs.utils.exceptions.AcsException;
import br.upe.acs.repository.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final UsuarioRepositorio repository;
    private final ActivityService activityService;

    public AtividadeComplementarVO getStudentAcs(String email) {
        Usuario student = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this id"));

        return new AtividadeComplementarVO(student);
    }

    public MinhasHorasNaAtividadeVO getHoursAcsStatusByActivity(String email, Long activityId) {
        Activity activity = activityService.findActivityById(activityId);

        Usuario student = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this id"));

        return calculateActivityHours(student, activity.getWorkloadMax());
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
