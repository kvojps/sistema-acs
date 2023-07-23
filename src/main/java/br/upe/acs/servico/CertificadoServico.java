package br.upe.acs.servico;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import br.upe.acs.dominio.Atividade;
import br.upe.acs.dominio.dto.CertificadoDTO;
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

	public Certificado buscarCertificadoPorId(Long id) throws AcsExcecao {
		Optional<Certificado> certificado = repositorio.findById(id);
		if (certificado.isEmpty()) {
			throw new AcsExcecao("Não existe um certificado associado a este id!");
		}

		return certificado.get();
	}

	public Long adicionarCertificado(MultipartFile file, Long requisicaoId, String email) throws AcsExcecao, IOException {
		Requisicao requisicao = requisicaoServico.buscarRequisicaoPorId(requisicaoId);
		if (!requisicao.getAluno().getEmail().equals(email)) {
			throw new AcsExcecao("Esse id não pertence a nenhuma requisição do aluno!");
		}

		if (requisicao.getCertificados().size() >= 10) {
			throw new AcsExcecao("Essa requisição já possui muitos certificados!");
		}

		Certificado certificado = new Certificado();
		certificado.setCertificado(file.getBytes());
		certificado.setRequisicao(requisicao);
		certificado.setStatusCertificado(CertificadoStatusEnum.RASCUNHO);
		Certificado certificadoSalvo = repositorio.save(certificado);
		return certificadoSalvo.getId();
	}

	public void alterarCertificado(Long certificadoId, CertificadoDTO certificadoDTO, String email) throws AcsExcecao, ParseException {
		Certificado certificado = buscarCertificadoPorId(certificadoId);
		if (!certificado.getRequisicao().getAluno().getEmail().equals(email)) {
			throw new AcsExcecao("Esse id não pertence a nenhuma certificado do aluno!");
		}
		Atividade atividade = atividadeServico.buscarAtividadePorId(certificadoDTO.getAtividadeId());
		certificado.setTitulo(certificadoDTO.getTitulo());
		certificado.setAtividade(atividade);
		certificado.setDataInicial(converterParaData(certificadoDTO.getDataIncial()));
		certificado.setDataFinal(converterParaData(certificadoDTO.getDataFinal()));
		certificado.setCargaHoraria((int) (certificadoDTO.getQuantidadeDeHoras() * 60));
		repositorio.save(certificado);
	}

	public void excluirCertificado(Long certificadoId, String email) throws AcsExcecao {
		Certificado certificado = buscarCertificadoPorId(certificadoId);
		if (!certificado.getRequisicao().getAluno().getEmail().equals(email)) {
			throw new AcsExcecao("Usuário sem premissão para excluir esse certificado!");
		}

		if (!certificado.getStatusCertificado().equals(CertificadoStatusEnum.RASCUNHO)) {
			throw new AcsExcecao("Um certificado já submetido não pode ser apagado!");
		}
		repositorio.deleteById(certificadoId);
	}

	private static Date converterParaData(String dataString) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.parse(dataString);
	}
}
