package br.upe.acs.servico;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import br.upe.acs.dominio.enums.CertificadoStatusEnum;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.Requisicao;
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

	public Long adicionarCertificado(MultipartFile file, Long requisicaoId, String email) throws AcsExcecao, IOException {
		Requisicao requisicao = requisicaoServico.buscarRequisicaoPorId(requisicaoId);
		if (!requisicao.getAluno().getEmail().equals(email)) {
			throw new AcsExcecao("Esse id não pertence a nenhuma requisição do aluno!");
		}
		Certificado certificado = new Certificado();
		certificado.setCertificado(file.getBytes());
		certificado.setRequisicao(requisicao);
		certificado.setStatusCertificado(CertificadoStatusEnum.RASCUNHO);
		Certificado certificadoSalvo = repositorio.save(certificado);
		return certificadoSalvo.getId();
	}

	private static Date converterParaData(String dataString) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formato.parse(dataString);
	}
}
