package br.upe.acs.servico;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.respostas.RequisicaoSimplesResposta;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import br.upe.acs.repositorio.UsuarioRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Comparator;

import static br.upe.acs.servico.ControleAcessoServico.validarSenha;
import static br.upe.acs.servico.RequisicaoServico.gerarPaginacaoRequisicoes;

@Service
@RequiredArgsConstructor
public class UsuarioServico {
	
    private final UsuarioRepositorio repositorio;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;

    public Usuario buscarUsuarioPorId(Long id) throws AcsExcecao {
		Optional<Usuario> usuario = repositorio.findById(id);
		if (usuario.isEmpty()) {
			throw new AcsExcecao("Não existe um usuário associado a este id!");
		}

		return usuario.get();
    }
    
    public Usuario buscarUsuarioPorEmail(String email) throws AcsExcecao{
    	Optional<Usuario> usuario = repositorio.findByEmail(email);
    	if (usuario.isEmpty()) {
			throw new AcsExcecao("Não existe um usuário associado a este id!");
		}
		return usuario.get();
    	
    }

    public String verificarUsuario(String email, String codigoVerificacao) throws AcsExcecao {
        Usuario usuario = buscarUsuarioPorEmail(email);

		if (usuario.isVerificado()) {
			throw new AcsExcecao("Este usuário já é verificado!");
		} else if (!codigoVerificacao.equals(usuario.getCodigoVerificacao())) {
			throw new AcsExcecao("O código de verificação está incorreto!");
		}
		usuario.setVerificado(true);
		repositorio.save(usuario);
		return "Aluno verificado com sucesso!";
    }

    public Map<String, Object> listarRequisicoesPorAlunoPaginadas(Long alunoId, int pagina, int quantidade) throws AcsExcecao {
		Usuario usuario = buscarUsuarioPorId(alunoId);
		List<RequisicaoSimplesResposta> requisicoesAluno = new ArrayList<>(usuario.getRequisicoes().stream()
				.filter(requisicao -> requisicao.getStatusRequisicao() != RequisicaoStatusEnum.RASCUNHO)
				.sorted(Comparator.comparing(Requisicao::getDataDeSubmissao).reversed())
				.map(RequisicaoSimplesResposta::new).toList());

		return gerarPaginacaoRequisicoes(requisicoesAluno, pagina, quantidade);
	}

	public void alterarSenha(String token, String senha, String novaSenha) throws AcsExcecao {
		validarSenha(novaSenha);
		String email = jwtService.extractUsername(token);
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, senha));
		if (repositorio.findByEmail(email).isPresent()) {
			Usuario usuario = repositorio.findByEmail(email).orElseThrow();
			usuario.setSenha(passwordEncoder.encode(novaSenha));
			repositorio.save(usuario);
		}
	}

}
