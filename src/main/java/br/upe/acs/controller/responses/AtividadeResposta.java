package br.upe.acs.controller.responses;

import br.upe.acs.model.Atividade;
import br.upe.acs.model.enums.EixoEnum;
import lombok.Getter;

@Getter
public class AtividadeResposta {

    private final Long id;

    private final EixoEnum eixo;

    private final String descricao;

    private final String criteriosParaAvaliacao;

    private final Integer chPorCertificado;

    private final int chMaxima;

    public AtividadeResposta(Atividade atividade) {
        super();
        this.id = atividade.getId();
        this.eixo = atividade.getEixo();
        this.descricao = atividade.getDescricao();
        this.chMaxima = atividade.getChMaxima();
        this.criteriosParaAvaliacao = atividade.getCriteriosParaAvaliacao();
        this.chPorCertificado = atividade.getChPorCertificado();
    }
}
