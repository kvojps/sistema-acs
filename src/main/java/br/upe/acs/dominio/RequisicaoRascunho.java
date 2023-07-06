package br.upe.acs.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequisicaoRascunho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int semestre;

    private int qtdCertificados;
    
    private String observacao;

    private Long usuarioId;

    private Long cursoId;

    @Temporal(TemporalType.DATE)
    private Date dataExpiracao;

    @OneToMany(mappedBy = "requisicaoRascunho")
    private List<CertificadoRascunho> certificadosRascunho;
}
