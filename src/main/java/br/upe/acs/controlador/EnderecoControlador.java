package br.upe.acs.controlador;

import br.upe.acs.controlador.respostas.ViaCepResposta;
import br.upe.acs.servico.EnderecoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/endereco")
@RequiredArgsConstructor
@CrossOrigin
public class EnderecoControlador {

    private final EnderecoServico servico;

    @GetMapping("/{cep}")
    public ResponseEntity<?> buscarEnderecoPorCep(@PathVariable String cep) {
        try {
            ViaCepResposta viaCepResposta = new ViaCepResposta(servico.buscarEnderecoPorCep(cep));
            return ResponseEntity.ok(viaCepResposta);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
