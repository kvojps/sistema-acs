package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.CertificadoResposta;
import br.upe.acs.controlador.respostas.RequisicaoSimplesResposta;
import br.upe.acs.dominio.Curso;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.enums.EixoEnum;
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
import java.util.concurrent.CompletableFuture;

import static br.upe.acs.utils.AuthUtils.generateVerificationCode;
import static br.upe.acs.utils.AuthUtils.validatePassword;
import static br.upe.acs.servico.RequisicaoServico.gerarPaginacaoRequisicoes;

@Service
@RequiredArgsConstructor
public class UsuarioServico {
	
    private final UsuarioRepositorio repositorio;

	private final CursoServico cursoServico;

	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;

	private final EmailServico emailServico;

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
    public Map<String, Object> listarRequisicoesPorAlunoPaginadasEixo(Long alunoId, EixoEnum eixo, int pagina, int quantidade) throws AcsExcecao {
		
    	Usuario usuario = buscarUsuarioPorId(alunoId);
		List<Requisicao> requisicoes = usuario.getRequisicoes().stream()
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

	public String alterarCodigoVerificacao(String email) throws AcsExcecao {
		Usuario usuario = buscarUsuarioPorEmail(email);

		if (usuario.isVerificado()) {
			throw new AcsExcecao("Usuário já é verificado!");
		}

		String novoCodigoVerificacao = generateVerificationCode();

		usuario.setCodigoVerificacao(novoCodigoVerificacao);

		repositorio.save(usuario);

		CompletableFuture.runAsync(() -> emailServico.enviarEmailCodigoVerificacao(email, novoCodigoVerificacao));

		return "O código de verificação reenviado.";
	}

	public void alterarSenha(String email, String senha, String novaSenha) throws AcsExcecao {
		validatePassword(novaSenha);
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, senha));
		if (repositorio.findByEmail(email).isPresent()) {
			Usuario usuario = repositorio.findByEmail(email).orElseThrow();
			usuario.setSenha(passwordEncoder.encode(novaSenha));
			repositorio.save(usuario);
		}
	}

	public void alterarDados(String email, String nomeCompleto, String telefone, Long cursoId) throws AcsExcecao {
		if (repositorio.findByEmail(email).isPresent()) {
			Usuario usuario = repositorio.findByEmail(email).orElseThrow();
			usuario.setNomeCompleto(nomeCompleto);
			usuario.setTelefone(telefone);
			Curso curso = cursoServico.buscarCursoPorId(cursoId);
            usuario.setCurso(curso);
            repositorio.save(usuario);
		}
	}

	public void desativarPerfilDoUsuario(String email) throws AcsExcecao {
		Usuario usuario = buscarUsuarioPorEmail(email);

		if (usuario.getRequisicoes().isEmpty()) {
			repositorio.deleteById(usuario.getId());
		} else {
			usuario.setEnabled(false);
		}
	}

}
