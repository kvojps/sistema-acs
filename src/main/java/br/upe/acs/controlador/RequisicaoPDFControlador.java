package br.upe.acs.controlador;

import br.upe.acs.servico.RequisicaoPDFCasoDeUso;
import br.upe.acs.utils.AcsExcecao;
import br.upe.acs.utils.MensagemUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/requisicao")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RequisicaoPDFControlador {

    private final RequisicaoPDFCasoDeUso casoDeUso;

    @Operation(
            summary = "Baixar pdf de uma requisição",
            description = "Descrição: Através deste endpoint, o usuário pode fazer o download da requisição em formato PDF.\n" +
                    "Pré-condições: O usuário deve estar logado e selecionar a opção de fazer download do arquivo em PDF.\n" +
                    "Pós-condições: O usuário vê o arquivo baixado na pasta selecionada."
    )
    @PostMapping("{id}/pdf")
    public ResponseEntity<?> gerarRequisicaoPDF(@PathVariable("id") Long requisicaoId) {
        ResponseEntity<?> resposta;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.attachment()
                    .filename("requisição" + requisicaoId + ".pdf").build());
            resposta = ResponseEntity.ok().headers(headers).body(casoDeUso.gerarRequisicaoPDF(requisicaoId));
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

}
