package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import br.upe.acs.dominio.dto.CertificadoDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.upe.acs.controlador.respostas.CertificadoResposta;
import br.upe.acs.servico.CertificadoServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/certificado")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CertificadoControlador {

    private final CertificadoServico servico;

    private final JwtService jwtService;

    @Operation(summary = "Buscar certificado por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCertificadoPorId(@PathVariable("id") Long id) {
        ResponseEntity<?> resposta;
        try {
            CertificadoResposta certificadoResposta = new CertificadoResposta(servico.buscarCertificadoPorId(id));
            resposta = ResponseEntity.ok(certificadoResposta);
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }
        
        return resposta;
    }

    @Operation(summary = "adicionar certificado")
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> adicionarCertificado(
            HttpServletRequest request,
            Long requisicaoId,
            @RequestPart(value = "certificado") MultipartFile certificado) {
        ResponseEntity<?> resposta;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            resposta = ResponseEntity.status(201).body(servico.adicionarCertificado(certificado, requisicaoId, email));
        } catch (Exception e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

    @Operation(summary = "alterar certificado")
    @PutMapping("/{id}")
    public ResponseEntity<?> alterarCertificado(
            HttpServletRequest request,
            @PathVariable("id") Long id,
            @RequestBody CertificadoDTO certificadoDTO
            ) {
        ResponseEntity<?> resposta;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            servico.alterarCertificado(id, certificadoDTO, email);
            resposta = ResponseEntity.noContent().build();
        } catch (Exception e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

    @Operation(summary = "excluir certificados")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirCertificado(HttpServletRequest request, @PathVariable("id") Long certificadoId) {
        ResponseEntity<?> resposta;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            servico.excluirCertificado(certificadoId, email);
            resposta = ResponseEntity.noContent().build();
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }
}
