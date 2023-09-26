package br.upe.acs.controller;

import br.upe.acs.config.JwtService;
import br.upe.acs.controller.responses.RequisicaoResposta;
import br.upe.acs.model.enums.EixoEnum;
import br.upe.acs.model.enums.RequisicaoStatusEnum;
import br.upe.acs.service.RequestService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/requests")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RequestController {

    private final RequestService service;
    private final JwtService jwtService;

    @PostMapping
    public ResponseEntity<?> createRequest(HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        return ResponseEntity.status(201).body(service.createRequest(email));
    }

    @GetMapping("/{id}/pdf")
    public ResponseEntity<?> createRequestPdf(@PathVariable("id") Long requestId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment()
                .filename("requisição" + requestId + ".pdf").build());

        return ResponseEntity.ok().headers(headers).body(service.createRequestPdf(requestId));
    }

    @GetMapping
    public ResponseEntity<Map<String, ?>> listRequests(@RequestParam(required = false) Boolean isArchived,
                                                       @RequestParam(required = false) RequisicaoStatusEnum status,
                                                       @RequestParam(required = false) Long userId,
                                                       @RequestParam(required = false) Long courseId,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int amount) {
        return ResponseEntity.ok(service.listRequests(isArchived, status, userId, courseId, page, amount));
    }

    @GetMapping("/user/{id}/{axle}")
    public ResponseEntity<Map<String, ?>> listStudentRequestsPaginatedByAxle(@PathVariable("id") Long studentId,
                                                                             @PathVariable("axle") EixoEnum axle,
                                                                             @RequestParam(defaultValue = "0") int page,
                                                                             @RequestParam(defaultValue = "10") int amount) {
        return ResponseEntity.ok(service.listStudentRequestsByAxle(studentId, axle, page, amount));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequisicaoResposta> findRequestById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new RequisicaoResposta(service.findRequestById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> submitRequest(@PathVariable("id") Long requestId) {
        return ResponseEntity.ok(service.submitRequest(requestId));
    }

    @PatchMapping("/archive/{id}")
    public ResponseEntity<?> archiveRequest(@PathVariable Long id, HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.archiveRequest(id, email);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/unarchive/{id}")
    public ResponseEntity<?> unarchiveRequest(@PathVariable Long id, HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.unarchiveRequest(id, email);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequest(HttpServletRequest request, @PathVariable("id") Long requestId) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.deleteRequest(requestId, email);
        return ResponseEntity.noContent().build();
    }
}
