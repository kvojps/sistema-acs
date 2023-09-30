package br.upe.acs.controller;

import br.upe.acs.config.JwtService;
import br.upe.acs.controller.responses.ArquivoResposta;
import br.upe.acs.model.dto.CertificateDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.upe.acs.controller.responses.CertificateReponse;
import br.upe.acs.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/certificates")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CertificateController {

    private final CertificateService service;
    private final JwtService jwtService;

    @Operation(summary = "Criar certificado")
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createCertificate(HttpServletRequest request, Long requestId,
                                               @RequestPart(value = "certificate") MultipartFile certificate) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        return ResponseEntity.status(201).body(new CertificateReponse(service.createCertificate(certificate, requestId, email)));
    }

    @Operation(summary = "Buscar certificado por id")
    @GetMapping("/{id}")
    public ResponseEntity<CertificateReponse> findCertificateById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new CertificateReponse(service.findCertificateById(id)));
    }

    @Operation(summary = "Buscar pdf do certificado por id")
    @GetMapping("/{id}/pdf")
    public ResponseEntity<?> findCertificatePdfById(@PathVariable("id") Long certificateId) {
        return ResponseEntity.ok(new ArquivoResposta(service.findCertificatePdfById(certificateId)));
    }

    @Operation(summary = "Atualizar certificado por id")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCertificate(HttpServletRequest request, @PathVariable("id") Long id, @RequestBody CertificateDTO certificateDto) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.updateCertificate(id, certificateDto, email);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Apagar certificado por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCertificate(HttpServletRequest request, @PathVariable("id") Long certificateId) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.deleteCertificate(certificateId, email);
        return ResponseEntity.noContent().build();
    }
}
