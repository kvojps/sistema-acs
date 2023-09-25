package br.upe.acs.service;

import br.upe.acs.model.Atividade;
import br.upe.acs.model.dto.AtividadeDTO;
import br.upe.acs.model.enums.EixoEnum;
import br.upe.acs.repository.AtividadeRepositorio;
import br.upe.acs.utils.exceptions.AcsException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final AtividadeRepositorio repository;

    public Atividade createActivity(AtividadeDTO activity) {
        ModelMapper modelMapper = new ModelMapper();
        Atividade activityToSave = modelMapper.map(activity, Atividade.class);

        return repository.save(activityToSave);
    }

    public List<Atividade> listActivities() {
        return repository.findAll();
    }

    public Atividade findActivityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new AcsException("Activity not found"));
    }

    public List<Atividade> findActivityByAxle(EixoEnum axle) {
        return repository.findByEixo(axle);
    }

    public void updateActivity(Long id, AtividadeDTO activity) {
        Atividade activityUpdated = repository.findById(id).orElseThrow(() ->
                new AcsException("Activity not found"));

        activityUpdated.setEixo(activity.getEixo());
        activityUpdated.setDescricao(activity.getDescricao());
        activityUpdated.setCriteriosParaAvaliacao(activity.getCriteriosParaAvaliacao());
        activityUpdated.setChMaxima(activity.getChMaxima());
        activityUpdated.setChPorCertificado(activity.getChPorCertificado());

        repository.save(activityUpdated);
    }

    public void deleteActivity(Long id) {
        repository.findById(id).orElseThrow(() -> new AcsException("Activity not found"));
        repository.deleteById(id);
    }
}
