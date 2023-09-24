package br.upe.acs.controller.responses;

import br.upe.acs.model.Certificado;
import br.upe.acs.model.Requisicao;
import br.upe.acs.model.enums.RequisicaoStatusEnum;
import lombok.Getter;

import java.util.Date;

@Getter
public class RequisicaoSimplesResposta {

    private final Long id;

    private final String idRequisicao;

    private final RequisicaoStatusEnum status;

    private final Date data;

    private final float quantidadeDeHoras;

    public RequisicaoSimplesResposta(Requisicao requisicao) {
        this.id = requisicao.getId();
        this.idRequisicao = getIdRequisicao();
        this.status = requisicao.getStatusRequisicao();
        this.data = requisicao.getDataDeSubmissao();
        this.quantidadeDeHoras = (float) requisicao.getCertificados().stream()
                .mapToDouble(Certificado::getCargaHoraria).sum();
    }
}