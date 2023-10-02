package br.upe.acs.service;

import br.upe.acs.model.Activity;
import br.upe.acs.model.dto.ActivityDTO;
import br.upe.acs.model.enums.AxleEnum;
import br.upe.acs.repository.ActivityRepository;
import br.upe.acs.utils.exceptions.AcsException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository repository;

    public Activity createActivity(ActivityDTO activity) {
        ModelMapper modelMapper = new ModelMapper();
        Activity activityToSave = modelMapper.map(activity, Activity.class);

        return repository.save(activityToSave);
    }

    public List<Activity> listActivities() {
        return repository.findAll();
    }

    public Activity findActivityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new AcsException("Activity not found"));
    }

    public List<Activity> findActivityByAxle(AxleEnum axle) {
        return repository.findByAxle(axle);
    }

    public void updateActivity(Long id, ActivityDTO activity) {
        Activity activityToUpdate = repository.findById(id).orElseThrow(() ->
                new AcsException("Activity not found"));

        activityToUpdate.setAxle(activity.axle());
        activityToUpdate.setDescription(activity.description());
        activityToUpdate.setEvaluationMethods(activity.evaluationMethods());
        activityToUpdate.setWorkloadMax(activity.workloadMax());
        activityToUpdate.setWorkloadCertificate(activity.workloadCertificate());

        repository.save(activityToUpdate);
    }

    public void deleteActivity(Long id) {
        repository.findById(id).orElseThrow(() -> new AcsException("Activity not found"));
        repository.deleteById(id);
    }
}
