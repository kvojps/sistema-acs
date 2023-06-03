package br.upe.acs.servico;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.upe.acs.dominio.Curso;
import br.upe.acs.dominio.Protocolo;
import br.upe.acs.dominio.dto.CertificadoDTO;
import br.upe.acs.dominio.dto.CertificadosProtocoloDTO;
import br.upe.acs.dominio.dto.ProtocoloDTO;
import br.upe.acs.repositorio.ProtocoloRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProtocoloCertificadoServico {

	private final CursoServico cursoServico;

	private final CertificadoServico certificadoServico;

	private final AtividadeServico atividadeServico;

	private final ProtocoloRepositorio repositorio;

	public String adicionarProtocolo(ProtocoloDTO protocolo) throws Exception {
		if (!validarProtocolo(protocolo)) {
			throw new AcsExcecao("Os metadados do protocolo enviado não são válidos!");
		}

		Protocolo protocoloSalvar = new Protocolo();
		protocoloSalvar.setData(converterParaData(protocolo.getData()));
		protocoloSalvar.setSemestre(protocolo.getSemestre());
		protocoloSalvar.setQtdCertificados(protocolo.getQtdCertificados());
		Curso cursoSalvar = cursoServico.buscarCursoPorId(protocolo.getCursoId()).get();
		protocoloSalvar.setCurso(cursoSalvar);

		CertificadosProtocoloDTO certificadosProtocoloMetaDados = new CertificadosProtocoloDTO();
		try {
			byte[] certificadosProtocoloJsonBytes = protocolo.getProtocoloJson().getBytes();
			certificadosProtocoloMetaDados = converter(certificadosProtocoloJsonBytes);
		} catch (IOException e) {
			protocoloSalvar = null;
		}

		Protocolo protocoloSalvo = new Protocolo();
		if (protocoloSalvar != null) {
			byte[] protocoloArquivo = protocolo.getProtocolo().getBytes();
			protocoloSalvar.setProtocoloArquivo(protocoloArquivo);
			protocoloSalvo = repositorio.save(protocoloSalvar);
		} else {
			throw new AcsExcecao("Falha na conversão do protocoloJson!");
		}

		MultipartFile[] certificadoArquivos = protocolo.getCertificados();
		List<CertificadoDTO> certificadosMetaDados = certificadosProtocoloMetaDados.getCertificados();
		if (certificadosMetaDados.size() != protocoloSalvo.getQtdCertificados()) {
			throw new AcsExcecao(
					"A quantidade de certificados informadas não é igual a quantidade de certificados cadastrados!");
		}

		if (validarCertificados(certificadosMetaDados)) {
			adicionarCertificados(certificadoArquivos, certificadosMetaDados, protocoloSalvo.getId());
		} else {
			throw new AcsExcecao("Os metadados dos certificados enviados não são válidos!");
		}

		String token = gerarTokenProtocolo();

		protocoloSalvo.setToken(token);
		repositorio.save(protocoloSalvo);

		return token;
	}

	private boolean validarProtocolo(ProtocoloDTO protocolo) {
		boolean isValid = true;

		if (!verificarData(protocolo.getData())) {
			isValid = false;
		} else if (!verificarCurso(protocolo.getCursoId())) {
			isValid = false;
		} else if (protocolo.getSemestre() <= 0 || protocolo.getSemestre() > 2) {
			isValid = false;
		} else if (protocolo.getQtdCertificados() <= 0 && protocolo.getQtdCertificados() > 20) {
			isValid = false;
		}

		return isValid;
	}

	private boolean verificarCurso(Long cursoId) {
		try {
			cursoServico.buscarCursoPorId(cursoId);
			return true;
		} catch (AcsExcecao e) {
			return false;
		}
	}

	private static Date converterParaData(String dataString) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formato.parse(dataString);
	}

	private boolean validarCertificados(List<CertificadoDTO> certificados) {
		boolean isValid = true;

		for (CertificadoDTO certificado : certificados) {

			if (certificado.getDescricao().isBlank()) {
				isValid = false;
			} else if (!verificarData(certificado.getData())) {
				isValid = false;
			} else if (certificado.getHoras() <= 1) {
				isValid = false;
			} else if (!verificarAtividade(certificado.getAtividadeId())) {
				isValid = false;
			}

			if (!isValid) {
				break;
			}
		}

		return isValid;
	}

	private static boolean verificarData(String dataString) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		formato.setLenient(false);

		try {
			formato.parse(dataString);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	private boolean verificarAtividade(Long atividadeId) {
		try {
			atividadeServico.buscarAtividadePorId(atividadeId);
			return true;
		} catch (AcsExcecao e) {
			return false;
		}
	}

	private void adicionarCertificados(MultipartFile[] certificadoArquivos, List<CertificadoDTO> certificados,
			Long idProtocolo) throws IOException, ParseException, AcsExcecao {
		for (int i = 0; i < certificadoArquivos.length; i++) {

			MultipartFile certificadoArquivoSalvar = certificadoArquivos[i];
			CertificadoDTO certificadoSalvar = certificados.get(i);
			certificadoSalvar.setProtocoloId(idProtocolo);

			certificadoServico.adicionarCertificado(certificadoSalvar, certificadoArquivoSalvar);
		}
	}

	private CertificadosProtocoloDTO converter(byte[] protocoloJson)
			throws StreamReadException, DatabindException, IOException {
		String jsonString = new String(protocoloJson);

		ObjectMapper objectMapper = new ObjectMapper();
		CertificadosProtocoloDTO protocolo = objectMapper.readValue(jsonString, CertificadosProtocoloDTO.class);

		return protocolo;
	}

	private String gerarTokenProtocolo() {
		String caracteres = "0123456789!@#$%.*";
		Random random = new Random();
		StringBuilder tokenParcial = new StringBuilder();

		for (int i = 0; i < 6; i++) {
			int index = random.nextInt(caracteres.length());
			tokenParcial.append(caracteres.charAt(index));
		}

		Instant timeStamp = Instant.now();
		Long epocaSegundos = timeStamp.getEpochSecond();
		String tokenFinal = tokenParcial.toString() + epocaSegundos.toString();

		return tokenFinal;
	}
}
