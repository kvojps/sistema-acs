package br.upe.acs.controlador.respostas;

import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import lombok.Getter;

import java.util.Date;

@Getter
public class RequisicaoSimplesResposta {

    private final Long id;

    private final RequisicaoStatusEnum status;

    private final Date data;

    private final float QuantidadeDeHoras;

    public RequisicaoSimplesResposta(Requisicao requisicao) {
        this.id = requisicao.getId();
        this.status = requisicao.getStatusRequisicao();
        this.data = requisicao.getStatusRequisicao() == RequisicaoStatusEnum.RASCUNHO?
                requisicao.getCriacao():
                requisicao.getDataDeSubmissao();
        QuantidadeDeHoras = quantidadeDeHorasDaRequisicao(requisicao.getCertificados().stream()
                .mapToInt(Certificado::getCargaHoraria).sum());
    }

    private float quantidadeDeHorasDaRequisicao(int minutos) {
        return minutos / 60.0f;
    }
}
