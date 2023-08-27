package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.RequisicaoSimplesResposta;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.enums.CertificadoStatusEnum;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import br.upe.acs.repositorio.CertificadoRepositorio;
import br.upe.acs.repositorio.RequisicaoRepositorio;
import br.upe.acs.utils.AcsExcecao;
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
import java.time.Instant;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
public class RequisicaoServico {

	private final RequisicaoRepositorio repositorio;
	private final UsuarioServico usuarioServico;
	private final TemplateEngine templateEngine;
	private final CertificadoRepositorio certificadoRepositorio;

	private final EmailServico emailServico;

	public RequisicaoServico(RequisicaoRepositorio repositorio, UsuarioServico usuarioServico, TemplateEngine templateEngine, CertificadoRepositorio certificadoRepositorio, EmailServico emailServico) {
		this.repositorio = repositorio;
		this.usuarioServico = usuarioServico;
		this.emailServico = emailServico;
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateEngine.setTemplateResolver(templateResolver);
		this.templateEngine = templateEngine;
		this.certificadoRepositorio = certificadoRepositorio;
	}

	public List<Requisicao> listarRequisicoes() {
		return repositorio.findAll();
	}

	public List<Requisicao> listarRequisicoesPorAluno(Long alunoId) throws AcsExcecao {
		Usuario aluno = usuarioServico.buscarUsuarioPorId(alunoId);
		return aluno.getRequisicoes();
	}

	public Map<String, Object> listarRequisicoesPaginadas(int pagina, int quantidade) {

		List<RequisicaoSimplesResposta> requisicoes = repositorio.findAll().stream()
				.filter(requisicao -> requisicao.getStatusRequisicao() != RequisicaoStatusEnum.RASCUNHO)
				.sorted(Comparator.comparing(Requisicao::getDataDeSubmissao).reversed())
				.map(RequisicaoSimplesResposta::new).toList();

		return gerarPaginacaoRequisicoes(requisicoes, pagina, quantidade);
	}
	

	public Requisicao buscarRequisicaoPorId(Long id) throws AcsExcecao {
		Optional<Requisicao> requisicao = repositorio.findById(id);
		if (requisicao.isEmpty()) {
			throw new AcsExcecao("Não existe uma requisição associada a este id!");
		}

		return requisicao.get();
	}
	
	public String arquivarRequisicao(Long id, String email) throws AcsExcecao{
		Requisicao requisicao = repositorio.findById(id).orElseThrow();
		String resposta;
		Usuario usuario = usuarioServico.buscarUsuarioPorEmail(email);
		RequisicaoStatusEnum status = requisicao.getStatusRequisicao();
		boolean finalizada = false;
		System.out.println(status);
		
		if(!usuario.equals(requisicao.getUsuario())) {
			throw new AcsExcecao("Usuário não tem permissão para arquivar essa requisição");
		}
		
		if(status == RequisicaoStatusEnum.ACEITO || status == RequisicaoStatusEnum.NEGADO) {
			finalizada = true;
		}	
		
		if(!finalizada) {
			throw new AcsExcecao("Não é possível arquivar uma requisição não finalizada");
		}
		
		if(!requisicao.isArquivada()) {
			requisicao.setArquivada(true);
			repositorio.save(requisicao);
			resposta = "Requisição arquivada com sucesso";			
		} else {
			resposta = "Requisição já está arquivada!";				
		}
		return resposta;
		
	}
	
	public String desarquivarRequisicao(Long id, String email) throws AcsExcecao{
		Requisicao requisicao = repositorio.findById(id).orElseThrow();
		Usuario usuario = usuarioServico.buscarUsuarioPorEmail(email);
		
		if(!usuario.equals(requisicao.getUsuario())) {
			throw new AcsExcecao("Usuário não tem permissão para desarquivar essa requisição");
		}
		
		String resposta;
		if(requisicao.isArquivada()) {
			requisicao.setArquivada(false);
			repositorio.save(requisicao);
			resposta = "Requisicao desarquivada com sucesso!";
		} else {
			resposta = "Requisicao não está arquivada";
		}		
		return resposta;
	}
	
	public List<Requisicao> listarRequisicoesArquivadas(String email) throws AcsExcecao{
		Usuario aluno = usuarioServico.buscarUsuarioPorEmail(email);

		List<Requisicao> requisicoesArquivadas = aluno.getRequisicoes().stream()
				.filter(Requisicao::isArquivada).toList();

		return requisicoesArquivadas;
	}

	public byte[] gerarRequisicaoPDF(Long id) throws AcsExcecao {
		Requisicao requisicao = buscarRequisicaoPorId(id);

		if (requisicao.getStatusRequisicao() != RequisicaoStatusEnum.TRANSITO) {
			throw new AcsExcecao("Não possivel gerar um pdf de uma requisição que não esteja trânsito!");
		}

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

	protected static Map<String, Object> gerarPaginacaoRequisicoes(List<RequisicaoSimplesResposta> lista, int pagina, int quantidade) {
		Map<String, Object> resposta = new HashMap<>();
		resposta.put("requisicoes", gerarPaginacao(lista, pagina, quantidade));
		resposta.put("paginaAtual", pagina);
		resposta.put("totalItens", lista.size());
		resposta.put("totalPaginas", Math.floorDiv(lista.size(), quantidade) + (lista.size() % quantidade == 0? 0: 1));

		return resposta;
	}

	private static  <T> List<T> gerarPaginacao(List<T> lista, int pagina, int quantidade) {
		int inicio = pagina * quantidade;
		int fim = Math.min(inicio + quantidade, lista.size());

		if (inicio >= fim) {
			return Collections.emptyList();
		}

		return lista.subList(inicio, fim);
	}

	private Context definirValoresTemplateHTML(Requisicao requisicao) {
		Context contexto = new Context();

		contexto.setVariable("protocolo", requisicao.getToken());
		contexto.setVariable("cpf", requisicao.getUsuario().getCpf());
		contexto.setVariable("data", requisicao.getDataDeSubmissao().toString());
		contexto.setVariable("nome", requisicao.getUsuario().getNomeCompleto());
		contexto.setVariable("curso", requisicao.getUsuario().getCurso().getNome());
		contexto.setVariable("periodo", requisicao.getUsuario().getPeriodo());
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

	private boolean validarCertificado(Certificado certificado) {
		boolean isValid = true;

			if (certificado.getCertificado() == null){
				isValid = false;
			} else if (certificado.getTitulo() == null || certificado.getTitulo().isBlank()) {
				isValid = false;
			} else if (certificado.getDataInicial().after(new Date())) {
				isValid = false;
			} else if (certificado.getDataFinal().after(new Date())) {
				isValid = false;
			} else if (certificado.getCargaHoraria() < 1) {
				isValid = false;
			} else if (certificado.getAtividade() == null) {
				isValid = false;
			}

			return isValid;
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
		long epocaSegundos = timeStamp.getEpochSecond();

		return tokenParcial + Long.toString(epocaSegundos);
	}

	private void modificarCertificados(List<Certificado> certificados) {
		for (Certificado certificado: certificados) {
			certificado.setStatusCertificado(CertificadoStatusEnum.ENCAMINHADO_COORDENACAO);
			certificadoRepositorio.save(certificado);
		}
	}

}
