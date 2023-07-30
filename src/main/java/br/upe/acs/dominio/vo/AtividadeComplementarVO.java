package br.upe.acs.dominio.vo;

import br.upe.acs.dominio.Usuario;
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
        this.horasExtensaoPercentual = percentual(aluno.getHorasExtensao(), aluno.getCurso().getHorasComplementares());
        this.horasGestaoPercentual = percentual(aluno.getHorasGestao(), aluno.getCurso().getHorasComplementares());
        this.horasEnsinoPercentual = percentual(aluno.getHorasEnsino(), aluno.getCurso().getHorasComplementares());
        this.horasPesquisaPercentual = percentual(aluno.getHorasPesquisa(), aluno.getCurso().getHorasComplementares());
        this.horasTotaisCurso = aluno.getCurso().getHorasComplementares();
    }

    private String percentual(float f, int divisor) {
        return Math.round((f /divisor) * 100.0) + "%";
    }
}