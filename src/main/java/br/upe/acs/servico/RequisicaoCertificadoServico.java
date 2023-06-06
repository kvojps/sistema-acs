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
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.dto.CertificadoDTO;
import br.upe.acs.dominio.dto.CertificadosMetadadosDTO;
import br.upe.acs.dominio.dto.RequisicaoDTO;
import br.upe.acs.dominio.enums.requisicaoStatusEnum;
import br.upe.acs.repositorio.RequisicaoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequisicaoCertificadoServico {

	private final UsuarioServico usuarioServico;

	private final CursoServico cursoServico;

	private final CertificadoServico certificadoServico;

	private final AtividadeServico atividadeServico;

	private final RequisicaoRepositorio repositorio;

	public String adicionarRequisicao(RequisicaoDTO requisicao) throws Exception {
		if (!validarRequisicao(requisicao)) {
			throw new AcsExcecao("Os metadados da requisção enviada não são válidos!");
		}

		Requisicao requisicaoSalvar = new Requisicao();
		Curso cursoSalvar = cursoServico.buscarCursoPorId(requisicao.getCursoId()).get();
		Usuario usuarioSalvar = usuarioServico.buscarUsuarioPorId(requisicao.getUsuarioId()).get();
		
		requisicaoSalvar.setData(obterDataAtual());
		requisicaoSalvar.setSemestre(requisicao.getSemestre());
		requisicaoSalvar.setQtdCertificados(requisicao.getQtdCertificados());
		requisicaoSalvar.setStatusRequisicao(requisicaoStatusEnum.ENCAMINHADO);
		requisicaoSalvar.setCurso(cursoSalvar);
		requisicaoSalvar.setUsuario(usuarioSalvar);

		CertificadosMetadadosDTO certificadosMetadados = new CertificadosMetadadosDTO();
		try {
			byte[] certificadoMetadadosBytes = requisicao.getCertificadosMetadados().getBytes();
			certificadosMetadados = converter(certificadoMetadadosBytes);
		} catch (IOException e) {
			throw new AcsExcecao("Falha na conversão dos metadados relacionados aos certificados!");
		}

		Requisicao requisicaoSalva = repositorio.save(requisicaoSalvar);

		MultipartFile[] certificadoArquivos = requisicao.getCertificados();
		List<CertificadoDTO> certificadosMetaDados = certificadosMetadados.getCertificados();
		if (certificadosMetaDados.size() != requisicaoSalva.getQtdCertificados()) {
			throw new AcsExcecao(
					"A quantidade de certificados informadas não é igual a quantidade de certificados cadastrados!");
		}

		if (validarCertificados(certificadosMetaDados)) {
			adicionarCertificados(certificadoArquivos, certificadosMetaDados, requisicaoSalva.getId());
		} else {
			throw new AcsExcecao("Os metadados dos certificados enviados não são válidos!");
		}

		String token = gerarTokenRequisicao();

		requisicaoSalva.setToken(token);
		repositorio.save(requisicaoSalva);

		return token;
	}

	private boolean validarRequisicao(RequisicaoDTO requisicao) {
		boolean isValid = true;

		if (!verificarUsuario(requisicao.getUsuarioId())) {
			isValid = false;
		} else if (!verificarCurso(requisicao.getCursoId())) {
			isValid = false;
		} else if (requisicao.getSemestre() <= 0 || requisicao.getSemestre() > 2) {
			isValid = false;
		} else if (requisicao.getQtdCertificados() <= 0 && requisicao.getQtdCertificados() > 20) {
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

	private static Date obterDataAtual() throws ParseException {
        SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date data = new Date();
        final String dataString = dataFormato.format(data);
        
		return dataFormato.parse(dataString);
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

	private boolean verificarUsuario(Long usuarioId) {
		try {
			usuarioServico.buscarUsuarioPorId(usuarioId);
			return true;
		} catch (AcsExcecao e) {
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
			Long idRequisicao) throws IOException, ParseException, AcsExcecao {
		for (int i = 0; i < certificadoArquivos.length; i++) {

			MultipartFile certificadoArquivoSalvar = certificadoArquivos[i];
			CertificadoDTO certificadoSalvar = certificados.get(i);
			certificadoSalvar.setRequisicaoId(idRequisicao);

			certificadoServico.adicionarCertificado(certificadoSalvar, certificadoArquivoSalvar);
		}
	}

	private CertificadosMetadadosDTO converter(byte[] certificadosMetadadosJson)
			throws StreamReadException, DatabindException, IOException {
		String jsonString = new String(certificadosMetadadosJson);

		ObjectMapper objectMapper = new ObjectMapper();
		CertificadosMetadadosDTO certificadosMetadados = objectMapper.readValue(jsonString,
				CertificadosMetadadosDTO.class);

		return certificadosMetadados;
	}

	private String gerarTokenRequisicao() {
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
