package br.upe.acs.servico;

import br.upe.acs.dominio.Atividade;
import br.upe.acs.dominio.dto.AtividadeDTO;
import br.upe.acs.dominio.enums.EixoEnum;
import br.upe.acs.repositorio.AtividadeRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AtividadeServico {

	private final AtividadeRepositorio repositorio;

	public List<Atividade> listarAtividades() {
		return repositorio.findAll();
	}

	public Atividade buscarAtividadePorId(Long id) throws AcsExcecao {
		Optional<Atividade> atividade = repositorio.findById(id);
		if (atividade.isEmpty()) {
			throw new AcsExcecao("Não existe uma atividade associada a este id!");
		}

		return atividade.get();
	}

	public List<Atividade> buscarAtividadePorEixo(String eixo) throws AcsExcecao{
		boolean existe = false;
		EixoEnum eixoFormato = null;
		for(EixoEnum c : EixoEnum.values()) {
			if(c.toString().equalsIgnoreCase(eixo)) {
				existe = true;
				eixoFormato = c;
			};
		}
		if(!existe) {
			throw new AcsExcecao("Não existe um eixo correspondente");
		}

		List<Atividade> atividade = repositorio.findByEixo(eixoFormato);

		if(atividade.isEmpty()) {
			throw new AcsExcecao("Não existe atividade associada a esse eixo");
		}

		return atividade;
	}

	public Atividade criarAtividade(AtividadeDTO atividade) throws AcsExcecao {
		Atividade atividadeNova = new Atividade();
		atividadeNova.setEixo(atividade.getEixo());
		atividadeNova.setDescricao(atividade.getDescricao());
		atividadeNova.setCriteriosParaAvaliacao(atividade.getCriteriosParaAvaliacao());
		atividadeNova.setChPorCertificado(atividade.getChPorCertificado());
        repositorio.save(atividadeNova);
		return atividadeNova;
	}

	public void excluirAtividade(Long id) throws AcsExcecao {
		Atividade atividade = buscarAtividadePorId(id);
        repositorio.deleteById(id);
    }

    public Atividade alterarAtividade(Long id, AtividadeDTO atividade) throws AcsExcecao {
        Optional<Atividade> atividadeAtualizada = repositorio.findById(id);

        if (atividadeAtualizada.isEmpty()) {
            throw new AcsExcecao("Não foi encontrada nenhuma atividade com esse id");
        }

        atividadeAtualizada.get().setEixo(atividade.getEixo());
        atividadeAtualizada.get().setDescricao(atividade.getDescricao());
        atividadeAtualizada.get().setCriteriosParaAvaliacao(atividade.getCriteriosParaAvaliacao());
        atividadeAtualizada.get().setChPorCertificado(atividade.getChPorCertificado());
        repositorio.save(atividadeAtualizada.get());
        return atividadeAtualizada.get();
    }
}
