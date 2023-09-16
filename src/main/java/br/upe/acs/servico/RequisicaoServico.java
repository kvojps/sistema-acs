package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.RequisicaoSimplesResposta;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import br.upe.acs.repositorio.RequisicaoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class RequisicaoServico {

	private final RequisicaoRepositorio repositorio;

	private final UserService usuarioServico;

	public List<Requisicao> listarRequisicoes() {
		return repositorio.findAll();
	}

	public List<Requisicao> listarRequisicoesPorAluno(Long alunoId) throws AcsExcecao {
		Usuario aluno = usuarioServico.findUserById(alunoId);
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
		Usuario usuario = usuarioServico.findUserByEmail(email);
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
		Usuario usuario = usuarioServico.findUserByEmail(email);
		
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
		Usuario aluno = usuarioServico.findUserByEmail(email);

		List<Requisicao> requisicoesArquivadas = aluno.getRequisicoes().stream()
				.filter(Requisicao::isArquivada).toList();

		return requisicoesArquivadas;
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

}
