package br.upe.acs.model.vo;

import br.upe.acs.model.User;
import lombok.Getter;

@Getter
public class AdditionalActivitiesVO {

    private final float hoursExtensao;
    private final float hoursGestao;
    private final float hoursEnsino;
    private final float hoursPesquisa;
    private final String hoursExtensaoPercentage;
    private final String hoursGestaoPercentage;
    private final String hoursEnsinoPercentage;
    private final String hoursPesquisaPercentage;
    private final int hoursCourse;

    public AdditionalActivitiesVO(User aluno) {
        this.hoursExtensao = aluno.getHoursExtensao();
        this.hoursGestao = aluno.getHoursGestao();
        this.hoursEnsino = aluno.getHoursEnsino();
        this.hoursPesquisa = aluno.getHoursPesquisa();
        this.hoursExtensaoPercentage = percentage(aluno.getHoursExtensao(), aluno.getCourse().getAdditionalHours());
        this.hoursGestaoPercentage = percentage(aluno.getHoursGestao(), aluno.getCourse().getAdditionalHours());
        this.hoursEnsinoPercentage = percentage(aluno.getHoursEnsino(), aluno.getCourse().getAdditionalHours());
        this.hoursPesquisaPercentage = percentage(aluno.getHoursPesquisa(), aluno.getCourse().getAdditionalHours());
        this.hoursCourse = aluno.getCourse().getAdditionalHours();
    }

    private String percentage(float f, int divisor) {
        return Math.round((f /divisor) * 100.0) + "%";
    }
}