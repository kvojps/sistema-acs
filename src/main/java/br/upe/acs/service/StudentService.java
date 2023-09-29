package br.upe.acs.service;

import br.upe.acs.model.Activity;
import br.upe.acs.model.Certificado;
import br.upe.acs.model.Requisicao;
import br.upe.acs.model.User;
import br.upe.acs.model.vo.AdditionalActivitiesVO;
import br.upe.acs.model.vo.MinhasHorasNaAtividadeVO;
import br.upe.acs.utils.exceptions.AcsException;
import br.upe.acs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final UserRepository repository;
    private final ActivityService activityService;

    public AdditionalActivitiesVO getStudentAcs(String email) {
        User student = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this id"));

        return new AdditionalActivitiesVO(student);
    }

    public MinhasHorasNaAtividadeVO getHoursAcsStatusByActivity(String email, Long activityId) {
        Activity activity = activityService.findActivityById(activityId);

        User student = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this id"));

        return calculateActivityHours(student, activity.getWorkloadMax());
    }

    private MinhasHorasNaAtividadeVO calculateActivityHours(User student, int chMax) {
        float sketchHours = 0;
        float progressHours = 0;
        float acceptedHours = 0;
        float problemHours = 0;
        for (Requisicao request : student.getRequests()) {
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
