package br.upe.acs.controller;

import br.upe.acs.config.JwtService;
import br.upe.acs.controller.responses.ArquivoResposta;
import br.upe.acs.model.dto.CertificadoDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.upe.acs.controller.responses.CertificadoResposta;
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

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createCertificate(HttpServletRequest request, Long requestId,
                                               @RequestPart(value = "certificate") MultipartFile certificate) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        return ResponseEntity.status(201).body(new CertificadoResposta(service.createCertificate(certificate, requestId, email)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CertificadoResposta> findCertificateById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new CertificadoResposta(service.findCertificateById(id)));
    }

    @GetMapping("/{id}/pdf")
    public ResponseEntity<?> findCertificatePdfById(@PathVariable("id") Long certificateId) {
        return ResponseEntity.ok(new ArquivoResposta(service.findCertificatePdfById(certificateId)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCertificate(HttpServletRequest request, @PathVariable("id") Long id, @RequestBody CertificadoDTO certificateDto) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.updateCertificate(id, certificateDto, email);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCertificate(HttpServletRequest request, @PathVariable("id") Long certificateId) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.deleteCertificate(certificateId, email);
        return ResponseEntity.noContent().build();
    }
}
