package br.upe.acs.controlador;

import br.upe.acs.controlador.respostas.AtividadeResposta;
import br.upe.acs.dominio.dto.AtividadeDTO;
import br.upe.acs.dominio.dto.CertificadoDTO;
import br.upe.acs.servico.AtividadeServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/atividade")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AtividadeControlador {

    private final AtividadeServico servico;

    @Operation(summary = "Listar todas as atividades",
            description = "Esse endpoint deve retornar todas as atividades existentes no banco de dados do sistema de Acs\n"
                    + "\nPré-condições: É necessário que o usuário esteja logado e verificado no sistema.\n"
                    + "\nPós-condições: Nenhuma")
    @GetMapping
    public ResponseEntity<List<AtividadeResposta>> listarAtividades() {
        return ResponseEntity.ok(servico.listarAtividades().stream().map(AtividadeResposta::new)
                .collect(Collectors.toList()));
    }

    @Operation(summary = "Buscar atividade por id",
            description = "Esse endpoint deve retornar a atividade correspondente ao id informado.\n"
                    + "\nPré-condição: É necessário que o usuário esteja logado e verificado no sistema. \n"
                    + "\nPós-condição: Nenhuma")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAtividadePorId(@PathVariable("id") Long id) {
        ResponseEntity<?> resposta;
        try {
            AtividadeResposta atividadeResposta = new AtividadeResposta(servico.buscarAtividadePorId(id));
            resposta = ResponseEntity.ok(atividadeResposta);
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

    @Operation(summary = "Buscar atividades por eixo", description = "Esse endpoint deve retornar a atividade correspondente ao eixo informado.\n"
            + "\nPré-condição: É necessário que o usuário esteja logado e verificado no sistema. \n"
            + "\nPós-condição: Nenhuma")
    @GetMapping("/eixo")
    public ResponseEntity<?> buscarAtividadePorEixo(@RequestParam String eixo) {
        ResponseEntity<?> resposta;
        try {
            resposta = ResponseEntity.ok(servico.buscarAtividadePorEixo(eixo));
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }
        return resposta;
    }

    @Operation(
            summary = "Criar uma nova atividade",
            description = "Descrição massa"
    )
    @PostMapping
    public ResponseEntity<?> criarAtividade(@RequestBody AtividadeDTO atividade) {
        ResponseEntity<?> resposta;

        try {
            resposta = ResponseEntity.ok(servico.criarAtividade(atividade));
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }
        return resposta;
    }

    @Operation(summary = "Excluir atividade")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirAtividade(HttpServletRequest request, @PathVariable("id") Long id) {
        ResponseEntity<?> resposta;
        try {
            servico.excluirAtividade(id);
            resposta = ResponseEntity.noContent().build();
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

    @Operation(summary = "Alterar atividade")
    @PutMapping("/{id}")
    public ResponseEntity<?> alterarAtividade(
            HttpServletRequest request,
            @PathVariable("id") Long id,
            @RequestBody AtividadeDTO atividadeDTO
    ) {
        ResponseEntity<?> resposta;
        try {
            servico.alterarAtividade(id, atividadeDTO);
            resposta = ResponseEntity.noContent().build();
        } catch (Exception e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

}
