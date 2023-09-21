package br.upe.acs.servico;

import br.upe.acs.dominio.Atividade;
import br.upe.acs.dominio.dto.AtividadeDTO;
import br.upe.acs.dominio.enums.EixoEnum;
import br.upe.acs.repositorio.AtividadeRepositorio;
import br.upe.acs.exceptions.AcsException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

	private final AtividadeRepositorio repository;

	public List<Atividade> listActivities() {
		return repository.findAll();
	}

	public Atividade findActivityById(Long id) throws AcsException {
		return repository.findById(id).orElseThrow(() ->
				new AcsException("Activity not found"));
	}

	public List<Atividade> findActivityByAxle(EixoEnum axle) throws AcsException {
		return repository.findByEixo(axle);
	}

	public Atividade createActivity(AtividadeDTO activity) throws AcsException {
		ModelMapper modelMapper = new ModelMapper();
		Atividade activityToSave = modelMapper.map(activity, Atividade.class);

		return repository.save(activityToSave);
	}

	public void deleteActivity(Long id) throws AcsException {
		repository.findById(id).orElseThrow(() ->
				new AcsException("Activity not found"));

        repository.deleteById(id);
    }

    public Atividade updateActivity(Long id, AtividadeDTO activity) throws AcsException {
        Atividade activityUpdated = repository.findById(id).orElseThrow(() ->
				new AcsException("Activity not found"));

        activityUpdated.setEixo(activity.getEixo());
        activityUpdated.setDescricao(activity.getDescricao());
        activityUpdated.setCriteriosParaAvaliacao(activity.getCriteriosParaAvaliacao());
		activityUpdated.setChMaxima(activity.getChMaxima());
        activityUpdated.setChPorCertificado(activity.getChPorCertificado());

        repository.save(activityUpdated);
        return activityUpdated;
    }
}
