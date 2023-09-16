package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.CertificadoResposta;
import br.upe.acs.controlador.respostas.RequisicaoSimplesResposta;
import br.upe.acs.dominio.Atividade;
import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.enums.EixoEnum;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import br.upe.acs.dominio.vo.AtividadeComplementarVO;
import br.upe.acs.dominio.vo.MinhasHorasNaAtividadeVO;
import br.upe.acs.repositorio.UsuarioRepositorio;
import br.upe.acs.utils.AcsExcecao;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.*;

import static br.upe.acs.servico.RequisicaoServico.gerarPaginacaoRequisicoes;

@Service
@RequiredArgsConstructor
public class AlunoServico {

	private final UsuarioRepositorio repositorio;

	private final AtividadeServico atividadeServico;

	//TODO: Eliminar método -> Está no serviço de usuário
	public Usuario buscarAlunoPorId(Long id) throws AcsExcecao {
		Optional<Usuario> usuario = repositorio.findById(id);
		if (usuario.isEmpty()) {
			throw new AcsExcecao("Não existe um usuário associado a este id!");
		}

		return usuario.get();
	}

	//TODO: Eliminar método -> Está no serviço de usuário
	public Usuario buscarAlunoPorEmail(String email) throws AcsExcecao {
		Optional<Usuario> aluno = repositorio.findByEmail(email);
		if (aluno.isEmpty()) {
			throw new AcsExcecao("Não existe um usuário associado a este email!");
		}

		return aluno.get();
	}

	public Map<String, Object> listarRequisicoesPaginadas(String email, int pagina, int quantidade) throws AcsExcecao {
		Usuario aluno = buscarAlunoPorEmail(email);
		List<RequisicaoSimplesResposta> requisicoesAluno = new ArrayList<>(aluno.getRequisicoes().stream()
				.filter(requisicao -> !requisicao.isArquivada())
				.sorted(Comparator.comparing(Requisicao::getStatusRequisicao))
				.map(RequisicaoSimplesResposta::new).toList());
		return gerarPaginacaoRequisicoes(requisicoesAluno, pagina, quantidade);
	}

	//TODO: ADICIONAR NO CONTROLLER
	public Map<String, Object> listarRequisicoesPorAlunoPaginadasEixo(Long alunoId, EixoEnum eixo, int pagina, int quantidade) throws AcsExcecao {

		Optional<Usuario> usuario = repositorio.findById(alunoId);
		List<Requisicao> requisicoes = usuario.orElseThrow().getRequisicoes().stream()
				.filter(requisicao -> requisicao.getStatusRequisicao() != RequisicaoStatusEnum.RASCUNHO).toList();

		List<Requisicao> requisicoesFiltro = new ArrayList<>();
		List<CertificadoResposta> certificados = new ArrayList<>();

		for (Requisicao req : requisicoes) {
			certificados = req.getCertificados().stream()
					.filter(certificado -> certificado.getAtividade().getEixo().equals(eixo))
					.map(CertificadoResposta::new).toList();
			if(!certificados.isEmpty()) {
				requisicoesFiltro.add(req);
			}
		}

		List<RequisicaoSimplesResposta> requisicoesAluno = new ArrayList<>(requisicoesFiltro.stream()
				.map(RequisicaoSimplesResposta::new).toList());


		return gerarPaginacaoRequisicoes(requisicoesAluno, pagina, quantidade);
	}

	public AtividadeComplementarVO atividadesComplementaresAluno(String email) throws AcsExcecao {
		Usuario aluno = buscarAlunoPorEmail(email);

		return new AtividadeComplementarVO(aluno);
	}

    public MinhasHorasNaAtividadeVO minhasHorasDeNaAtividade(String email, Long atividadeId) throws AcsExcecao {
		Atividade atividade = atividadeServico.buscarAtividadePorId(atividadeId);

		Usuario aluno = buscarAlunoPorEmail(email);

		return calcularMinhasHoras(aluno, atividade.getChMaxima());


    }

	private MinhasHorasNaAtividadeVO calcularMinhasHoras(Usuario aluno, int chMaximo) {
		float horasRacunhos = 0;
		float horasAndamento = 0;
		float horasAceitas = 0;
		float horasComProblemas = 0;
		for (Requisicao requisicao: aluno.getRequisicoes()) {
			for (Certificado certificado: requisicao.getCertificados()) {
				switch (certificado.getStatusCertificado()) {
					case RASCUNHO -> horasRacunhos += certificado.getCargaHoraria();
					case PROBLEMA -> horasComProblemas += certificado.getCargaHoraria();
					case CONCLUIDO -> horasAceitas += certificado.getCargaHoraria();
					default -> horasAndamento += certificado.getCargaHoraria();
				}
			}
		}

		float horasRestantes = chMaximo - (horasAceitas + horasAndamento + horasRacunhos + horasComProblemas);

		return new MinhasHorasNaAtividadeVO(horasAceitas, horasAndamento, horasRacunhos, horasComProblemas, horasRestantes);
	}
}
