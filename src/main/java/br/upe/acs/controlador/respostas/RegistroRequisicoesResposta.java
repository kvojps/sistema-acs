package br.upe.acs.controlador.respostas;

import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.vo.RegistroRequisicoesVO;
import lombok.Getter;

import java.util.List;

@Getter
public class RegistroRequisicoesResposta {

    private int horasExtensao;

    private int horasGestao;

    private int horasEnsino;

    private int horasPesquisa;

    private int horasTotaisCurso;

    private List<RequisicaoResposta> requisicoes;

    public RegistroRequisicoesResposta(RegistroRequisicoesVO registroRequisicoesVO) {
        this.horasExtensao = registroRequisicoesVO.getHorasExtensao();
        this.horasGestao = registroRequisicoesVO.getHorasGestao();
        this.horasEnsino = registroRequisicoesVO.getHorasEnsino();
        this.horasPesquisa = registroRequisicoesVO.getHorasPesquisa();
        this.horasTotaisCurso = registroRequisicoesVO.getHorasTotaisCurso();
        this.requisicoes = registroRequisicoesVO.getRequisicoes().stream().map(RequisicaoResposta::new).toList();
    }


}
