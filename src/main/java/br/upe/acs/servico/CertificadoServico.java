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
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.dto.CertificadoDTO;
import br.upe.acs.repositorio.CertificadoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CertificadoServico {

	private final CertificadoRepositorio repositorio;
	private final RequisicaoServico requisicaoServico;
	private final AtividadeServico atividadeServico;

	public Optional<Certificado> buscarCertificadoPorId(Long id) throws AcsExcecao {
		if (repositorio.findById(id).isEmpty()) {
			throw new AcsExcecao("Não existe um certificado associado a este id!");
		}

		return repositorio.findById(id);
	}

	public void adicionarCertificado(CertificadoDTO certificado, MultipartFile file)
			throws IOException, ParseException, AcsExcecao {
		byte[] certificadoArquivo = file.getBytes();

		Certificado certificadoSalvar = new Certificado();
		certificadoSalvar.setTitulo(certificado.getTitulo());
		certificadoSalvar.setDescricao(certificado.getDescricao());
		certificadoSalvar.setData(converterParaData(certificado.getData()));
		certificadoSalvar.setHoras(certificado.getHoras());
		certificadoSalvar.setChTotal(0);
		certificadoSalvar.setCertificado(certificadoArquivo);

		Optional<Requisicao> requisicaoSalvar = requisicaoServico.buscarRequisicaoPorId(certificado.getRequisicaoId());
		certificadoSalvar.setRequisicao(requisicaoSalvar.orElseThrow());

		Optional<Atividade> atividadeSalvar = atividadeServico.buscarAtividadePorId(certificado.getAtividadeId());
		certificadoSalvar.setAtividade(atividadeSalvar.orElseThrow());
		certificadoSalvar.setChMaxima(atividadeSalvar.get().getChMaxima());

		repositorio.save(certificadoSalvar);
	}

	private static Date converterParaData(String dataString) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formato.parse(dataString);
	}
}
