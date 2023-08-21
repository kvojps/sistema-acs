package br.upe.acs.controlador;

import br.upe.acs.controlador.respostas.ViaCepResposta;
import br.upe.acs.servico.EnderecoServico;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/endereco")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EnderecoControlador {

    private final EnderecoServico servico;
    @Operation(summary = "Buscar endereço por CEP", 
    		description = "Esse endpoint deve ser capaz de buscar o endereço de acordo com CEP na API ViaCep.\n"
    				+ "\nPré-condição: Nenhuma\n"
    				+ "\nPós-condição: Nenhuma")
    @GetMapping("/{cep}")
    public ResponseEntity<?> buscarEnderecoPorCep(@PathVariable String cep) {
        ResponseEntity<?> resposta;
        try {
            ViaCepResposta viaCepResposta = new ViaCepResposta(servico.buscarEnderecoPorCep(cep));
            resposta = ResponseEntity.ok(viaCepResposta);
        } catch (Exception e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }
}
