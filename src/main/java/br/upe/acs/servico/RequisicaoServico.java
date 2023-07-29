package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.RequisicaoResposta;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.repositorio.RequisicaoRepositorio;
import br.upe.acs.utils.AcsExcecao;
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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class RequisicaoServico {

	private final RequisicaoRepositorio repositorio;
	private final UsuarioServico usuarioServico;
	private final TemplateEngine templateEngine;

	public RequisicaoServico(RequisicaoRepositorio repositorio, UsuarioServico usuarioServico, TemplateEngine templateEngine) {
		this.repositorio = repositorio;
		this.usuarioServico = usuarioServico;
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateEngine.setTemplateResolver(templateResolver);
		this.templateEngine = templateEngine;
	}

	public List<Requisicao> listarRequisicoes() {
		return repositorio.findAll();
	}

	public Map<String, Object> listarRequisicoesPaginadas(int pagina, int quantidade) {
		Pageable paginaFormato = PageRequest.of(pagina, quantidade);

		Page<Requisicao> requisicoesPagina = repositorio.findAll(paginaFormato);

		return gerarPaginacao(requisicoesPagina);
	}

	public List<Requisicao> listarRequisicoesPorAluno(Long alunoId) throws AcsExcecao {
		Usuario aluno = usuarioServico.buscarUsuarioPorId(alunoId).orElseThrow();
		return aluno.getRequisicoes();
	}

	public Requisicao buscarRequisicaoPorId(Long id) throws AcsExcecao {
		Optional<Requisicao> requisicao = repositorio.findById(id);
		if (requisicao.isEmpty()) {
			throw new AcsExcecao("Não existe uma requisição associada a este id!");
		}

		return requisicao.get();
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
		Requisicao requisicao = buscarRequisicaoPorId(id);

		Context contexto = definirValoresTemplateHTML(requisicao);

		String htmlDoDocumento = templateEngine.process("requisicao.html", contexto);
		Path pathDoPdf = Paths.get("src/main/resources/requisicao" + id +".pdf");

		try (FileOutputStream outputStream = new FileOutputStream("src/main/resources/requisicao" + id +".pdf")) {
			ITextRenderer renderer = new ITextRenderer();
			SharedContext sharedContext = renderer.getSharedContext();
			sharedContext.setPrint(true);
			sharedContext.setInteractive(false);
			renderer.setDocumentFromString(htmlDoDocumento);
			renderer.layout();
			renderer.createPDF(outputStream);
			outputStream.close();

			byte[] arquivoPDF = Files.readAllBytes(pathDoPdf);
			Files.delete(pathDoPdf);
			return arquivoPDF;

		} catch (Exception e) {
			throw new AcsExcecao("Erro ao gerar o arquivo pdf!");
		}

	}

	private Context definirValoresTemplateHTML(Requisicao requisicao) {
		Context contexto = new Context();

		contexto.setVariable("protocolo", requisicao.getToken());
		contexto.setVariable("cpf", requisicao.getUsuario().getCpf());
		contexto.setVariable("data", requisicao.getData().toString());
		contexto.setVariable("nome", requisicao.getUsuario().getNomeCompleto());
		contexto.setVariable("curso", requisicao.getUsuario().getCurso().getNome());
		contexto.setVariable("periodo", requisicao.getSemestre());
		contexto.setVariable("rua", requisicao.getUsuario().getEndereco().getRua());
		contexto.setVariable("bairro", requisicao.getUsuario().getEndereco().getBairro());
		contexto.setVariable("numero", requisicao.getUsuario().getEndereco().getNumero());
		contexto.setVariable("cidade", requisicao.getUsuario().getEndereco().getCidade());
		contexto.setVariable("uf", requisicao.getUsuario().getEndereco().getUF());
		contexto.setVariable("cep", requisicao.getUsuario().getEndereco().getCep());
		contexto.setVariable("email", requisicao.getUsuario().getEmail());
		contexto.setVariable("telefone", requisicao.getUsuario().getTelefone());

		return contexto;
	}

}
