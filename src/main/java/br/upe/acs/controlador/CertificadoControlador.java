package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.respostas.ArquivoResposta;
import br.upe.acs.dominio.dto.CertificadoDTO;
import br.upe.acs.utils.MensagemUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.upe.acs.controlador.respostas.CertificadoResposta;
import br.upe.acs.servico.CertificateService;
import br.upe.acs.exceptions.AcsException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/certificado")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CertificadoControlador {

    private final CertificateService servico;

    private final JwtService jwtService;

    @Operation(
            summary = "Buscar certificado por id",
             description = "Esta rota permite busca informações mais detalhadas sobre um certificado de forma, " +
                     "retornando informações de id, titulo, eixo, atividade, status, data de inicio, data de fim e carga" +
                     " horária. Essa rota será util para aluno, coordenação e comissão tenha acesso aos certificados."

    )
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCertificadoPorId(@PathVariable("id") Long id) {
        ResponseEntity<?> resposta;
        try {
            CertificadoResposta certificadoResposta = new CertificadoResposta(servico.findCertificateById(id));
            resposta = ResponseEntity.ok(certificadoResposta);
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }
        
        return resposta;
    }

    @Operation(
            summary = "Buscar o arquivo do certificado por id",
            description = "Esta rota permite busca e acessar o base64 do arquivo de um certificado no sistema. " +
                    "Essa rota será util para aluno, coordenação e comissão tenha acesso ao arquivo dos certificados."
    )
    @GetMapping("/{id}/pdf")
    public ResponseEntity<?> buscarPdfDoCertificadoPorId(@PathVariable("id") Long certificadoId) {
        ResponseEntity<?> resposta;
        try {
            ArquivoResposta arquivo = new ArquivoResposta(servico.findCertificatePdfById(certificadoId));
            resposta = ResponseEntity.ok(arquivo);
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }


    @Operation(
            summary = "adicionar certificado",
            description = "Esta rota cria um novo certificado no sistema com o envio de id de uma requisição rascunho e" +
                    " o arquivo do certificado e retorna o id do certificado. Essa rota permitirá o aluno " +
                    "adicionar certificados a requisição, antes da submissão, para análise da coordenação."
    )
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> adicionarCertificado(
            HttpServletRequest request,
            Long requisicaoId,
            @RequestPart(value = "certificado") MultipartFile certificado) {
        ResponseEntity<?> resposta;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            resposta = ResponseEntity.status(201).body(servico.addCertificate(certificado, requisicaoId, email));
        } catch (Exception e) {
            resposta = ResponseEntity.status(404).body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

    @Operation(
            summary = "alterar certificado",
            description = "Esta rota permite o aluno alterar o certificado enquanto ainda é um rascunho é preenche os " +
                    "os campos para poder submeter para análise. Util para o aluno modificar e salvar suas alterações " +
                    "incompletas em certificado."
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> alterarCertificado(
            HttpServletRequest request,
            @PathVariable("id") Long id,
            @RequestBody CertificadoDTO certificadoDTO
            ) {
        ResponseEntity<?> resposta;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            servico.updateCertificate(id, certificadoDTO, email);
            resposta = ResponseEntity.noContent().build();
        } catch (Exception e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }

    @Operation(
            summary = "excluir certificados",
            description = "Esta rota permite o aluno excluir certificados com status rascunho em casos de nescessidades."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirCertificado(HttpServletRequest request, @PathVariable("id") Long certificadoId) {
        ResponseEntity<?> resposta;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            servico.deleteCertificate(certificadoId, email);
            resposta = ResponseEntity.noContent().build();
        } catch (AcsException e) {
            resposta = ResponseEntity.badRequest().body(new MensagemUtil(e.getMessage()));
        }

        return resposta;
    }
}
