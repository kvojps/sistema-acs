package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.respostas.UsuarioResposta;
import br.upe.acs.utils.AcsExcecao;
import br.upe.acs.utils.MensagemUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.upe.acs.servico.AlunoServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/aluno")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AlunoControlador {

    private final AlunoServico servico;

    private final JwtService jwtService;

    @Operation(
            summary = "Listar todas as requisições do aluno",
            description = "Esta rota permite o aluno lista todas suas requisições de forma paginada, " +
                    "possuindo com retorno um Map com um lista de requisições, a página atual, total de itens " +
                    "e total de páginas."
    )
    @GetMapping("/requisicao/paginacao")
    public  ResponseEntity<?> listarRequisicoesPaginadas(
            HttpServletRequest request,
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int quantidade
    ) {
        ResponseEntity<?> resposta;
        try {
            String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
            resposta = ResponseEntity.ok(servico.listarRequisicoesPaginadas(email, pagina, quantidade));

        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

    @Operation(
            summary = "Carga horaria dos alunos",
            description = "Esta rota permite o aluno acessar as informações sobre suas horas complementares, " +
                    "retornando os horas já contabilizadas de Ensino, Extensão, Gestão e Pesquisa."
    )
    @GetMapping("/horas")
    public ResponseEntity<?> atividadesComplementaresAluno(HttpServletRequest request) {
        ResponseEntity<?> resposta;
        try {
            String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
            resposta = ResponseEntity.ok(servico.atividadesComplementaresAluno(email));
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

    @Operation(
            summary = "Buscar aluno por id",
            description = "Esta rota permite buscar um aluno via seu id. As informações retornadas incluem " +
                    "informações como id, nome completo, número de matricula, telefone, email, perfis, curso, " +
                    "periodo e se é verificado. Essa rota séra util para gerenciamento de usuarios e para coordenação " +
                    "e comissão tenha acesso aos dados dos alunos."
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAlunoPorId(@PathVariable("id") Long id) {
        ResponseEntity<?> resposta;
        try {
			UsuarioResposta alunoResposta = new UsuarioResposta(servico.buscarAlunoPorId(id));
			resposta = ResponseEntity.ok(alunoResposta);
		} catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
		}

        return resposta;
    }

}
