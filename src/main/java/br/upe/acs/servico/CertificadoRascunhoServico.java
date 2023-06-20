package br.upe.acs.servico;

import br.upe.acs.dominio.Atividade;
import br.upe.acs.dominio.CertificadoRascunho;
import br.upe.acs.dominio.RequisicaoRascunho;
import br.upe.acs.dominio.dto.CertificadoDTO;
import br.upe.acs.repositorio.CertificadoRascunhoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CertificadoRascunhoServico {

    private final CertificadoRascunhoRepositorio repositorio;
    private final AtividadeServico atividadeServico;
    private final RequisicaoRascunhoServico requisicaoRascunhoServicoServico;

    public void adicionarCertificadoRascunho(CertificadoDTO certificado, MultipartFile arquivo) throws IOException, ParseException, AcsExcecao {
        byte[] certificadoArquivo = arquivo.getBytes();
        Optional<Atividade> atividadeSalvar = atividadeServico.buscarAtividadePorId(certificado.getAtividadeId());
        Optional<RequisicaoRascunho> requisicaoRascunhoSalvar = requisicaoRascunhoServicoServico.buscarRequisicaoRascunhoPorId(certificado.getRequisicaoId());

        CertificadoRascunho certificadoRascunhoSalvar = new CertificadoRascunho();
        certificadoRascunhoSalvar.setTitulo(certificado.getTitulo());
        certificadoRascunhoSalvar.setDescricao(certificado.getDescricao());
        certificadoRascunhoSalvar.setData(converterParaData(certificado.getData()));
        certificadoRascunhoSalvar.setHoras(certificado.getHoras());
        certificadoRascunhoSalvar.setChMaxima(atividadeSalvar.orElseThrow().getChMaxima());
        certificadoRascunhoSalvar.setCertificadoArquivo(certificadoArquivo);
        certificadoRascunhoSalvar.setEixoAtividade(atividadeSalvar.orElseThrow().getEixo());
        certificadoRascunhoSalvar.setDescricaoAtividade(atividadeSalvar.orElseThrow().getDescricao());
        certificadoRascunhoSalvar.setRequisicaoRascunho(requisicaoRascunhoSalvar.orElseThrow());

        repositorio.save(certificadoRascunhoSalvar);
    }

    private static Date converterParaData(String dataString) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formato.parse(dataString);
    }
}
