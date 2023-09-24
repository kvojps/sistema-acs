package br.upe.acs.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.model.enums.EixoEnum;
import br.upe.acs.utils.MessageUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.upe.acs.controller.responses.AtividadeResposta;
import br.upe.acs.model.dto.AtividadeDTO;
import br.upe.acs.service.ActivityService;
import br.upe.acs.utils.exceptions.AcsException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/atividade")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AtividadeControlador {

    private final ActivityService servico;

    @Operation(summary = "Listar todas as atividades",
            description = "Esse endpoint deve retornar todas as atividades existentes no banco de dados do sistema de Acs\n"
                    + "\nPré-condições: É necessário que o usuário esteja logado e verificado no sistema.\n"
                    + "\nPós-condições: Nenhuma")
    @GetMapping
    public ResponseEntity<List<AtividadeResposta>> listarAtividades() {
        return ResponseEntity.ok(servico.listActivities().stream().map(AtividadeResposta::new)
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
            AtividadeResposta atividadeResposta = new AtividadeResposta(servico.findActivityById(id));
            resposta = ResponseEntity.ok(atividadeResposta);
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MessageUtil(e.getMessage()));
        }

        return resposta;
    }

    @Operation(summary = "Buscar atividades por eixo", description = "Esse endpoint deve retornar a atividade correspondente ao eixo informado.\n"
            + "\nPré-condição: É necessário que o usuário esteja logado e verificado no sistema. \n"
            + "\nPós-condição: Nenhuma")
    @GetMapping("/eixo")
    public ResponseEntity<?> buscarAtividadePorEixo(@RequestParam EixoEnum axle){
    	ResponseEntity<?> resposta;
    	try {
    		resposta = ResponseEntity.ok(servico.findActivityByAxle(axle).stream().map(AtividadeResposta::new).toList());
    	} catch(AcsException e) {
    		resposta = ResponseEntity.badRequest().body(new MessageUtil(e.getMessage()));
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
            resposta = ResponseEntity.ok(new AtividadeResposta(servico.createActivity(atividade)));
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MessageUtil(e.getMessage()));
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
            resposta = ResponseEntity.ok(new AtividadeResposta(servico.updateActivity(id, atividadeDTO)));
        } catch (Exception e) {
            resposta = ResponseEntity.badRequest().body(new MessageUtil(e.getMessage()));
        }

        return resposta;
    }


    @Operation(summary = "Excluir atividade")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirAtividade(HttpServletRequest request, @PathVariable("id") Long id) {
        ResponseEntity<?> resposta;
        try {
            servico.deleteActivity(id);
            resposta = ResponseEntity.noContent().build();
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MessageUtil(e.getMessage()));
        }

        return resposta;
    }

}
