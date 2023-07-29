package br.upe.acs.Requisicao;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.RequisicaoControlador;
import br.upe.acs.servico.RequisicaoServico;

@ExtendWith(MockitoExtension.class)
public class RequisicaoControladorTest {

    @Mock
    private RequisicaoServico requisicaoServico;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private RequisicaoControlador requisicaoControlador;

    private MockMvc mockMvc;
    @Test
    public void testAdicionarRequisicao() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(requisicaoControlador).build();

        when(jwtService.extractUsername(anyString())).thenReturn("user@example.com");

        Long idRequisicao = 1L;
        when(requisicaoServico.adicionarRequisicao(anyString())).thenReturn(idRequisicao);

        mockMvc.perform(post("/api/requisicao")
                .header("Authorization", "Bearer token")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(idRequisicao));
    }
}
