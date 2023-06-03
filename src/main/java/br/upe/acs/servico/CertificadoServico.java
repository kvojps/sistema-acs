package br.upe.acs.servico;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.upe.acs.dominio.Atividade;
import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.Protocolo;
import br.upe.acs.dominio.dto.CertificadoDTO;
import br.upe.acs.repositorio.CertificadoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CertificadoServico {

	private final CertificadoRepositorio repositorio;

	private final ProtocoloServico protocoloServico;

	private final AtividadeServico atividadeServico;

	public Certificado adicionarCertificado(CertificadoDTO certificado, MultipartFile file)
			throws IOException, ParseException, AcsExcecao {

		byte[] certificadoArquivo = file.getBytes();

		Certificado certificadoSalvar = new Certificado();
		certificadoSalvar.setDescricao(certificado.getDescricao());
		certificadoSalvar.setData(converterParaData(certificado.getData()));
		certificadoSalvar.setHoras(certificado.getHoras());
		certificadoSalvar.setChMaxima(0);
		certificadoSalvar.setChTotal(0);
		certificadoSalvar.setCertificado(certificadoArquivo);
		Optional<Protocolo> protocoloSalvar = protocoloServico.buscarProtocoloPorId(certificado.getProtocoloId());
		certificadoSalvar.setProtocolo(protocoloSalvar.get());
		Optional<Atividade> atividadeSalvar = atividadeServico.buscarAtividadePorId(certificado.getAtividadeId());
		certificadoSalvar.setAtividade(atividadeSalvar.get());

		return repositorio.save(certificadoSalvar);
	}

	private static Date converterParaData(String dataString) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formato.parse(dataString);
	}
}
