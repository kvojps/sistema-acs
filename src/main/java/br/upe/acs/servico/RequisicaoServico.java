package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.RequisicaoResposta;
import br.upe.acs.dominio.Aluno;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.vo.RegistroRequisicoesVO;
import br.upe.acs.repositorio.RequisicaoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
@RequiredArgsConstructor
public class RequisicaoServico {

	private final RequisicaoRepositorio repositorio;
	private final AlunoServico alunoServico;
	private final TemplateEngine templateEngine;
	
	public List<Requisicao> listarRequisicoes() {
		return repositorio.findAll();
	}

	public Map<String, Object> listarRequisicoesPaginadas(int pagina, int quantidade) {
		Pageable paginaFormato = PageRequest.of(pagina, quantidade);

		Page<Requisicao> requisicoesPagina = repositorio.findAll(paginaFormato);

		return gerarPaginacao(requisicoesPagina);
	}

	public RegistroRequisicoesVO listarRequisicoesPorAluno(Long alunoId) throws AcsExcecao {
		Aluno aluno = alunoServico.buscarAlunoPorId(alunoId).orElseThrow();
		RegistroRequisicoesVO registroRequisicoesVO = new RegistroRequisicoesVO();
		registroRequisicoesVO.setHorasEnsino(aluno.getHorasEnsino());
		registroRequisicoesVO.setHorasExtensao(aluno.getHorasExtensao());
		registroRequisicoesVO.setHorasGestao(aluno.getHorasGestao());
		registroRequisicoesVO.setHorasPesquisa(aluno.getHorasPesquisa());
		registroRequisicoesVO.setHorasTotaisCurso(aluno.getCurso().getHorasComplementares());
		registroRequisicoesVO.setRequisicoes(aluno.getRequisicoes());
		return registroRequisicoesVO;
	}

	public Optional<Requisicao> buscarRequisicaoPorId(Long id) throws AcsExcecao {
		if (repositorio.findById(id).isEmpty()) {
			throw new AcsExcecao("Não existe uma requisição associada a este id!");
		}

		return repositorio.findById(id);
	}

	private Map<String, Object> gerarPaginacao (Page<Requisicao> pagina) {
		List<RequisicaoResposta> requisicoesConteudo = pagina.getContent().stream()
				.map(RequisicaoResposta::new).toList();

		Map<String, Object> resposta = new HashMap<>();
		resposta.put("requisicoes", requisicoesConteudo);
		resposta.put("paginaAtual", pagina.getNumber());
		resposta.put("totalItens", requisicoesConteudo.size());
		resposta.put("totalPaginas", pagina.getTotalPages());

		return resposta;
	}

	public byte[] gerarRequisicaoPDF(Long id) throws AcsExcecao {
		Optional<Requisicao> requisicao = repositorio.findById(id);
		if (requisicao.isEmpty()) {
			throw new AcsExcecao("Requisição não encontrada!");
		}

		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateEngine.setTemplateResolver(templateResolver);

		Context contexto = definirVariaveis(requisicao.get());

		String texto = templateEngine.process("requisicao.html", contexto);

		try (FileOutputStream outputStream = new FileOutputStream("src/main/resources/requisicao.pdf")) {
			ITextRenderer renderer = new ITextRenderer();
			SharedContext sharedContext = renderer.getSharedContext();
			sharedContext.setPrint(true);
			sharedContext.setInteractive(false);
			renderer.setDocumentFromString(texto);
			renderer.layout();
			renderer.createPDF(outputStream);
			outputStream.close();
			byte[] arquivoPDF = Files.readAllBytes(Paths.get("src/main/resources/requisicao.pdf"));
			Files.delete(Paths.get("src/main/resources/requisicao.pdf"));
			return arquivoPDF;

		} catch (Exception e) {
			throw new AcsExcecao("Erro ao gerar o arquivo pdf!");
		}

	}

	private Context definirVariaveis(Requisicao requisicao) {
		Context contexto = new Context();

		contexto.setVariable("protocolo", requisicao.getToken());
		contexto.setVariable("cpf", requisicao.getAluno().getCpf());
		contexto.setVariable("data", requisicao.getData().toString());
		contexto.setVariable("nome", requisicao.getAluno().getNomeCompleto());
		contexto.setVariable("curso", requisicao.getAluno().getCurso().getNome());
		contexto.setVariable("periodo", requisicao.getSemestre());
		contexto.setVariable("rua", requisicao.getAluno().getEndereco().getRua());
		contexto.setVariable("bairro", requisicao.getAluno().getEndereco().getBairro());
		contexto.setVariable("numero", requisicao.getAluno().getEndereco().getNumero());
		contexto.setVariable("cidade", requisicao.getAluno().getEndereco().getCidade());
		contexto.setVariable("uf", requisicao.getAluno().getEndereco().getUF());
		contexto.setVariable("cep", requisicao.getAluno().getEndereco().getCep());
		contexto.setVariable("email", requisicao.getAluno().getEmail());
		contexto.setVariable("telefone", requisicao.getAluno().getTelefone());

		return contexto;
	}

}
