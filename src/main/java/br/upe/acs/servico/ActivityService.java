package br.upe.acs.servico;

import br.upe.acs.dominio.Atividade;
import br.upe.acs.dominio.dto.AtividadeDTO;
import br.upe.acs.dominio.enums.EixoEnum;
import br.upe.acs.repositorio.AtividadeRepositorio;
import br.upe.acs.utils.AcsExcecao;
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

	public Atividade findActivityById(Long id) throws AcsExcecao {
		return repository.findById(id).orElseThrow(() ->
				new AcsExcecao("Activity not found"));
	}

	//TODO: REFACTOR THIS METHOD TO USE JUST REPO
	public List<Atividade> findActivityByAxle(String axle) throws AcsExcecao{
		boolean isExists = false;
		EixoEnum axleFormat = null;
		for(EixoEnum c : EixoEnum.values()) {
			if(c.toString().equalsIgnoreCase(axle)) {
				isExists = true;
				axleFormat = c;
			}
		}
		if(!isExists) {
			throw new AcsExcecao("This axle does not exists");
		}

		List<Atividade> activities = repository.findByEixo(axleFormat);
		if(activities.isEmpty()) {
			throw new AcsExcecao("Does not exist one activity related with this axle");
		}

		return activities;
	}

	public Atividade createActivity(AtividadeDTO activity) throws AcsExcecao {
		ModelMapper modelMapper = new ModelMapper();
		Atividade activityToSave = modelMapper.map(activity, Atividade.class);

		return repository.save(activityToSave);
	}

	public void deleteActivity(Long id) throws AcsExcecao {
		repository.findById(id).orElseThrow(() ->
				new AcsExcecao("Activity not found"));

        repository.deleteById(id);
    }

    public Atividade updateActivity(Long id, AtividadeDTO activity) throws AcsExcecao {
        Atividade activityUpdated = repository.findById(id).orElseThrow(() ->
				new AcsExcecao("Activity not found"));

        activityUpdated.setEixo(activity.getEixo());
        activityUpdated.setDescricao(activity.getDescricao());
        activityUpdated.setCriteriosParaAvaliacao(activity.getCriteriosParaAvaliacao());
		activityUpdated.setChMaxima(activity.getChMaxima());
        activityUpdated.setChPorCertificado(activity.getChPorCertificado());

        repository.save(activityUpdated);
        return activityUpdated;
    }
}
