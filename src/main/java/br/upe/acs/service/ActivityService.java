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

    public List<Activity> listActivities(AxleEnum axle) {
        return repository.findWithFilters(axle);
    }

    public Activity findActivityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new AcsException("Activity not found"));
    }

    public void updateActivity(Long id, ActivityDTO activity) {
        Activity activityToUpdate = repository.findById(id).orElseThrow(() ->
                new AcsException("Activity not found"));

        activityToUpdate.setAxle(activity.getAxle());
        activityToUpdate.setDescription(activity.getDescription());
        activityToUpdate.setEvaluationMethods(activity.getEvaluationMethods());
        activityToUpdate.setWorkloadMax(activity.getWorkloadMax());
        activityToUpdate.setWorkloadCertificate(activity.getWorkloadCertificate());

        repository.save(activityToUpdate);
    }

    public void deleteActivity(Long id) {
        repository.findById(id).orElseThrow(() -> new AcsException("Activity not found"));
        repository.deleteById(id);
    }
}
