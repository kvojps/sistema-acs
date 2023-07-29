package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.RequisicaoResposta;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.vo.AtividadeComplementarVO;
import br.upe.acs.repositorio.UsuarioRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServico {
	
    private final UsuarioRepositorio repositorio;

    public Optional<Usuario> buscarUsuarioPorId(Long id) throws AcsExcecao {
        if (repositorio.findById(id).isEmpty()) {
            throw new AcsExcecao("Não existe um usuário associado a este id!");
        }

        return repositorio.findById(id);
    }
    
    public Usuario buscarUsuarioPorEmail(String email) throws AcsExcecao{
    	Optional<Usuario> usuario = repositorio.findByEmail(email);
    	if (usuario.isEmpty()) {
			throw new AcsExcecao("Não existe um usuário associado a este id!");
		}
		return usuario.get();
    	
    }

    public String verificarUsuario(Long usuarioId, String codigoVerificacao) throws AcsExcecao {
        Usuario usuario = buscarUsuarioPorId(usuarioId).orElseThrow();
        String resposta;
        if (usuario.isVerificado()) {
            resposta = "Este usuário já é verificado!";
        } else if (codigoVerificacao.equals(usuario.getCodigoVerificacao())) {
            usuario.setVerificado(true);
            repositorio.save(usuario);
            resposta = "Aluno verificado com sucesso!";
        } else {
            resposta = "O código de verificação está incorreto!";
        }
        
        return resposta;
    }
    
    public Map<String, Object> requisicoesAlunoPaginada(String email, int pagina, int quantidade) throws AcsExcecao {
		Usuario usuario = buscarUsuarioPorEmail(email);
		Pageable paginaFormato = PageRequest.of(pagina, quantidade);
		List<RequisicaoResposta> requisicoesAluno = new ArrayList<>(usuario.getRequisicoes()
				.stream().map(RequisicaoResposta::new).toList());

		return gerarPaginacaoRequisicoes(requisicoesAluno, pagina, quantidade);
	}
    
    private Map<String, Object> gerarPaginacaoRequisicoes(List<RequisicaoResposta> lista, int pagina, int quantidade) {
		Map<String, Object> resposta = new HashMap<>();
		resposta.put("requisicoes", gerarPaginacao(lista, pagina, quantidade));
		resposta.put("paginaAtual", pagina);
		resposta.put("totalItens", lista.size());
		resposta.put("totalPaginas", Math.floorDiv(lista.size(), quantidade) + (lista.size() % quantidade == 0? 0: 1));

		return resposta;
	}
    
    private <T> List<T> gerarPaginacao(List<T> lista, int pagina, int quantidade) {
		int inicio = pagina * quantidade;
		int fim = Math.min(inicio + quantidade, lista.size());

		if (inicio >= fim) {
			return Collections.emptyList();
		}

		return lista.subList(inicio, fim);
	}
    
	public AtividadeComplementarVO atividadesComplementaresAluno(String email) throws AcsExcecao {
		Usuario aluno = buscarUsuarioPorEmail(email);
		return new AtividadeComplementarVO(aluno);
	}
}
