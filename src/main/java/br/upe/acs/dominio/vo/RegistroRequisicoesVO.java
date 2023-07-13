package br.upe.acs.dominio.vo;

import br.upe.acs.dominio.Requisicao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroRequisicoesVO {

    private int horasExtensao;

    private int horasGestao;

    private int horasEnsino;

    private int horasPesquisa;

    private int horasTotaisCurso;

    private List<Requisicao> requisicoes;

}