package br.upe.acs.service;

import br.upe.acs.model.Activity;
import br.upe.acs.model.Certificate;
import br.upe.acs.model.Request;
import br.upe.acs.model.User;
import br.upe.acs.model.vo.AdditionalActivitiesVO;
import br.upe.acs.model.vo.MyHoursInActivityVO;
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

    public MyHoursInActivityVO getHoursAcsStatusByActivity(String email, Long activityId) {
        Activity activity = activityService.findActivityById(activityId);

        User student = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this id"));

        return calculateActivityHours(student, activity.getWorkloadMax());
    }

    private MyHoursInActivityVO calculateActivityHours(User student, int chMax) {
        float sketchHours = 0;
        float progressHours = 0;
        float acceptedHours = 0;
        float problemHours = 0;
        for (Request request : student.getRequests()) {
            for (Certificate certificate : request.getCertificates()) {
                switch (certificate.getStatus()) {
                    case RASCUNHO -> sketchHours += certificate.getWorkload();
                    case PROBLEMA -> problemHours += certificate.getWorkload();
                    case CONCLUIDO -> acceptedHours += certificate.getWorkload();
                    default -> progressHours += certificate.getWorkload();
                }
            }
        }

        float remainingHours = chMax - (acceptedHours + progressHours + sketchHours + problemHours);

        return new MyHoursInActivityVO(acceptedHours, progressHours, sketchHours, problemHours, remainingHours);
    }
}
