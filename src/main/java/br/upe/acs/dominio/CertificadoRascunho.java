package br.upe.acs.dominio;

import br.upe.acs.dominio.enums.EixoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificadoRascunho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    private String descricao;
    
    private String observacao;

    @Temporal(TemporalType.DATE)
    private Date data;

    private int horas;

    private int chMaxima;

    private byte[] certificadoArquivo;

    @Enumerated(EnumType.STRING)
    private EixoEnum eixoAtividade;

    private String descricaoAtividade;

    @ManyToOne
    private RequisicaoRascunho requisicaoRascunho;
}
