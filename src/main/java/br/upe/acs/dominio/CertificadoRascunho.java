package br.upe.acs.dominio;

import br.upe.acs.dominio.enums.EixoEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class CertificadoRascunho extends CertificadoBase {

    @Enumerated(EnumType.STRING)
    private EixoEnum eixoAtividade;

    private String descricaoAtividade;

    @ManyToOne
    private RequisicaoRascunho requisicaoRascunho;

}
