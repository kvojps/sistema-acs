package br.upe.acs.dominio.dto;

import br.upe.acs.dominio.enums.EixoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class CertificadoRascunhoDTO {

    private String titulo;

    private String descricao;

    private String data;

    private int horas;

    private Long atividadeId;

    private Long requisicaoRascunhoId;
}
