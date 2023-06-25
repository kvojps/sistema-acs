package br.upe.acs.controlador.respostas;

import br.upe.acs.dominio.Atividade;
import br.upe.acs.dominio.enums.EixoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class AtividadeResposta {

    private final Long id;

    @Enumerated(EnumType.STRING)
    private final EixoEnum eixo;

    private final String descricao;

    private final int chMaxima;

    public AtividadeResposta(Atividade atividade) {
        super();
        this.id = atividade.getId();
        this.eixo = atividade.getEixo();
        this.descricao = atividade.getDescricao();
        this.chMaxima = atividade.getChMaxima();
    }
}
