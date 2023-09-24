package br.upe.acs.controller;

import br.upe.acs.config.JwtService;
import br.upe.acs.controller.responses.ArquivoResposta;
import br.upe.acs.model.dto.CertificadoDTO;
import br.upe.acs.utils.MessageUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.upe.acs.controller.responses.CertificadoResposta;
import br.upe.acs.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/certificate")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CertificateController {

    private final CertificateService service;
    private final JwtService jwtService;

    //TODO: Remover try catch após especialização da exceção
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createCertificate(HttpServletRequest request, Long requestId,
                                               @RequestPart(value = "certificate") MultipartFile certificate) {
        ResponseEntity<?> resposta;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            resposta = ResponseEntity.status(201).body(service.createCertificate(certificate, requestId, email));
        } catch (Exception e) {
            resposta = ResponseEntity.status(404).body(new MessageUtil(e.getMessage()));
        }

        return resposta;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CertificadoResposta> findCertificateById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new CertificadoResposta(service.findCertificateById(id)));
    }

    @GetMapping("/{id}/pdf")
    public ResponseEntity<?> findCertificatePdfById(@PathVariable("id") Long certificateId) {
        return ResponseEntity.ok(new ArquivoResposta(service.findCertificatePdfById(certificateId)));
    }

    //TODO: Remover try catch após especialização da exceção
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCertificate(HttpServletRequest request, @PathVariable("id") Long id, @RequestBody CertificadoDTO certificateDto) {
        ResponseEntity<?> response;
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        try {
            service.updateCertificate(id, certificateDto, email);
            response = ResponseEntity.noContent().build();
        } catch (Exception e) {
            response = ResponseEntity.badRequest().body(new MessageUtil(e.getMessage()));
        }

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCertificate(HttpServletRequest request, @PathVariable("id") Long certificateId) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.deleteCertificate(certificateId, email);
        return ResponseEntity.noContent().build();
    }
}
