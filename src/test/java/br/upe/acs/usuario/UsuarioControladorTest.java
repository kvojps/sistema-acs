package br.upe.acs.usuario;

import br.upe.acs.controlador.UsuarioControlador;
import br.upe.acs.controlador.respostas.UsuarioResposta;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.dto.AlterarSenhaDTO;
import br.upe.acs.servico.ControleAcessoServico;
import br.upe.acs.servico.UsuarioServico;
import br.upe.acs.utils.AcsExcecao;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UsuarioControladorTest {
    @Mock
    private UsuarioServico servico;
    @Mock
    private HttpServletRequest request;
    @InjectMocks
    private UsuarioControlador controlador;

    @Mock
    private ControleAcessoServico controleAcessoServico;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void retornarPerfilDoUsuario_UsuarioVerificado_RetornaUsuarioResposta() throws AcsExcecao {
// Arrange
        Long usuarioId = 1L;
        String codigoDeVerificacao = "123456";
        String token = "valid_token";
        Usuario aluno = new Usuario();
        UsuarioResposta usuarioResposta = new UsuarioResposta(aluno);
        when(request.getHeader("Authorization")).thenReturn("Bearer " + token);
        when(servico.buscarUsuarioPorId(usuarioId)).thenAnswer(invocation -> {
            if (invocation.getArgument(0).equals(usuarioId)) {
                return Optional.of(usuarioResposta);
            }
            return Optional.empty();
        });
// Act
        ResponseEntity<?> resposta = controlador.retornarPerfilDoUsuario(request, usuarioId, codigoDeVerificacao);
// Assert
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(usuarioResposta, resposta.getBody());
        verify(servico, times(1)).buscarUsuarioPorId(usuarioId);
    }
    @Test
    void retornarPerfilDoUsuario_UsuarioNaoVerificado_RetornaForbidden() throws AcsExcecao {
// Arrange
        Long usuarioId = 1L;
        String codigoDeVerificacao = "123456";
        String token = "valid_token";
        Usuario aluno = new Usuario();
        UsuarioResposta usuarioResposta = new UsuarioResposta(aluno);
        when(request.getHeader("Authorization")).thenReturn("Bearer " + token);
        when(servico.buscarUsuarioPorId(usuarioId)).thenAnswer(invocation -> {
            if (invocation.getArgument(0).equals(usuarioId)) {
                return Optional.empty();
            }
            return Optional.empty();
        });
// Act
        ResponseEntity<?> resposta = controlador.retornarPerfilDoUsuario(request, usuarioId, codigoDeVerificacao);
// Assert
        assertEquals(HttpStatus.FORBIDDEN, resposta.getStatusCode());
        assertEquals("Usuário não verificado.", resposta.getBody().toString());
        verify(servico, times(1)).buscarUsuarioPorId(usuarioId);
    }
    @Test
    void retornarPerfilDoUsuario_AcsExcecao_RetornaBadRequest() throws AcsExcecao {
// Arrange
        Long usuarioId = 1L;
        String codigoDeVerificacao = "123456";
        String token = "valid_token";
        String mensagemErro = "Erro ao buscar usuário.";
        AcsExcecao excecao = new AcsExcecao(mensagemErro);
        when(request.getHeader("Authorization")).thenReturn("Bearer " + token);
        when(servico.buscarUsuarioPorId(usuarioId)).thenAnswer(invocation -> {
            if (invocation.getArgument(0).equals(usuarioId)) {
                throw excecao;
            }
            return Optional.empty();
        });
// Act
        ResponseEntity<?> resposta = controlador.retornarPerfilDoUsuario(request, usuarioId, codigoDeVerificacao);
// Assert
        assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        assertEquals(mensagemErro, resposta.getBody().toString());
        verify(servico, times(1)).buscarUsuarioPorId(usuarioId);
    }
    @Test
    void verificarUsuario_Sucesso_RetornaUsuarioVerificado() throws AcsExcecao {
// Arrange
        Long usuarioId = 1L;
        String codigoDeVerificacao = "123456";
        when(servico.verificarUsuario(usuarioId, codigoDeVerificacao)).thenReturn("Usuário verificado com sucesso.");
// Act
        ResponseEntity<?> resposta = controlador.verificarUsuario(usuarioId, codigoDeVerificacao);
// Assert
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals("Usuário verificado com sucesso.", resposta.getBody().toString());
        verify(servico, times(1)).verificarUsuario(usuarioId, codigoDeVerificacao);
    }
    @Test
    void verificarUsuario_AcsExcecao_RetornaBadRequest() throws AcsExcecao {
// Arrange
        Long usuarioId = 1L;
        String codigoDeVerificacao = "123456";
        String mensagemErro = "Erro ao verificar usuário.";
        AcsExcecao excecao = new AcsExcecao(mensagemErro);
        when(servico.verificarUsuario(usuarioId, codigoDeVerificacao)).thenThrow(excecao);
// Act
        ResponseEntity<?> resposta = controlador.verificarUsuario(usuarioId, codigoDeVerificacao);
// Assert
        assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        assertEquals(mensagemErro, resposta.getBody().toString());
        verify(servico, times(1)).verificarUsuario(usuarioId, codigoDeVerificacao);
    }

    //Antigo UsuárioControlladorTest
    @Test
    public void testAlterarSenhaComSucesso() {
        String token = "Token";
        AlterarSenhaDTO alterarSenhaDTO = new AlterarSenhaDTO();
        alterarSenhaDTO.setSenha("Senha123@");
        alterarSenhaDTO.setNovaSenha("NovaSenha123@");

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

        try {
            Mockito.doNothing().when(controleAcessoServico).alterarSenha(token, alterarSenhaDTO.getSenha(), alterarSenhaDTO.getNovaSenha());
        } catch (AcsExcecao e) {
            e.printStackTrace();
        }

        ResponseEntity<?> resposta = controlador.alterarSenha(request, alterarSenhaDTO);

        assertEquals(HttpStatus.NO_CONTENT, resposta.getStatusCode());
    }

    @Test
    public void testAlterarSenha_Falha() throws AcsExcecao {
        String token = "Token";
        AlterarSenhaDTO alterarSenhaDTO = new AlterarSenhaDTO();
        alterarSenhaDTO.setSenha("SenhaAtual123@");
        alterarSenhaDTO.setNovaSenha("NovaSenha123@");

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

        String mensagemErro = "Erro ao alterar a senha";
        Mockito.doThrow(new AcsExcecao(mensagemErro)).when(controleAcessoServico).alterarSenha(token, alterarSenhaDTO.getSenha(),
                alterarSenhaDTO.getNovaSenha());

        ResponseEntity<?> resposta = controlador.alterarSenha(request, alterarSenhaDTO);

        assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        assertEquals(mensagemErro, resposta.getBody());

    }
}

