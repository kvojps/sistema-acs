package br.upe.acs.controlador;

import br.upe.acs.config.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.upe.acs.controlador.respostas.CertificadoResposta;
import br.upe.acs.servico.CertificadoServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
            CertificadoResposta certificadoResposta = new CertificadoResposta(servico.buscarCertificadoPorId(id).orElseThrow());
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
            @RequestPart(value = "certificadosMetadados") MultipartFile certificado) {
        ResponseEntity<?> resposta;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            resposta = ResponseEntity.status(201).body(servico.adicionarCertificado(certificado, requisicaoId, email));
        } catch (Exception e) {
            resposta = ResponseEntity.status(404).body(e.getMessage());
        }

        return resposta;
    }
}
