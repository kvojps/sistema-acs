package br.upe.acs.model.vo;

import br.upe.acs.model.Usuario;
import lombok.Getter;

@Getter
public class AtividadeComplementarVO {

    private final float horasExtensao;

    private final float horasGestao;

    private final float horasEnsino;

    private final float horasPesquisa;

    private final String horasExtensaoPercentual;

    private final String horasGestaoPercentual;

    private final String horasEnsinoPercentual;

    private final String horasPesquisaPercentual;

    private final int horasTotaisCurso;

    public AtividadeComplementarVO(Usuario aluno) {
        this.horasExtensao = aluno.getHorasExtensao();
        this.horasGestao = aluno.getHorasGestao();
        this.horasEnsino = aluno.getHorasEnsino();
        this.horasPesquisa = aluno.getHorasPesquisa();
        this.horasExtensaoPercentual = percentual(aluno.getHorasExtensao(), aluno.getCurso().getAdditionalHours());
        this.horasGestaoPercentual = percentual(aluno.getHorasGestao(), aluno.getCurso().getAdditionalHours());
        this.horasEnsinoPercentual = percentual(aluno.getHorasEnsino(), aluno.getCurso().getAdditionalHours());
        this.horasPesquisaPercentual = percentual(aluno.getHorasPesquisa(), aluno.getCurso().getAdditionalHours());
        this.horasTotaisCurso = aluno.getCurso().getAdditionalHours();
    }

    private String percentual(float f, int divisor) {
        return Math.round((f /divisor) * 100.0) + "%";
    }
}