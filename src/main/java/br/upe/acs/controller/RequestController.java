package br.upe.acs.controller;

import br.upe.acs.config.JwtService;
import br.upe.acs.controller.responses.RequisicaoResposta;
import br.upe.acs.model.enums.EixoEnum;
import br.upe.acs.model.enums.RequisicaoStatusEnum;
import br.upe.acs.service.RequestService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Criar requisição rascunho por token")
    @PostMapping
    public ResponseEntity<?> createRequest(HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        return ResponseEntity.status(201).body(service.createRequest(email));
    }

    @Operation(summary = "Buscar pdf da requisição por id")
    @GetMapping("/{id}/pdf")
    public ResponseEntity<?> createRequestPdf(@PathVariable("id") Long requestId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment()
                .filename("requisição" + requestId + ".pdf").build());

        return ResponseEntity.ok().headers(headers).body(service.createRequestPdf(requestId));
    }

    @Operation(summary = "Listar requisições")
    @GetMapping
    public ResponseEntity<Map<String, ?>> listRequests(@RequestParam(required = false) Boolean isArchived,
                                                       @RequestParam(required = false) RequisicaoStatusEnum status,
                                                       @RequestParam(required = false) Long userId,
                                                       @RequestParam(required = false) Long courseId,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int amount) {
        return ResponseEntity.ok(service.listRequests(isArchived, status, userId, courseId, page, amount));
    }

    @Operation(summary = "Listar requisições do estudante por eixo")
    @GetMapping("/user/{id}/{axle}")
    public ResponseEntity<Map<String, ?>> listStudentRequestsPaginatedByAxle(@PathVariable("id") Long studentId,
                                                                             @PathVariable("axle") EixoEnum axle,
                                                                             @RequestParam(defaultValue = "0") int page,
                                                                             @RequestParam(defaultValue = "10") int amount) {
        return ResponseEntity.ok(service.listStudentRequestsByAxle(studentId, axle, page, amount));
    }

    @Operation(summary = "Buscar requisição por id")
    @GetMapping("/{id}")
    public ResponseEntity<RequisicaoResposta> findRequestById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new RequisicaoResposta(service.findRequestById(id)));
    }

    @Operation(summary = "Submeter requisição por id")
    @PutMapping("/{id}")
    public ResponseEntity<?> submitRequest(@PathVariable("id") Long requestId) {
        return ResponseEntity.ok(service.submitRequest(requestId));
    }

    @Operation(summary = "Arquivar requisição por id")
    @PatchMapping("/archive/{id}")
    public ResponseEntity<?> archiveRequest(@PathVariable Long id, HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.archiveRequest(id, email);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Desarquivar requisição por id")
    @PatchMapping("/unarchive/{id}")
    public ResponseEntity<?> unarchiveRequest(@PathVariable Long id, HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.unarchiveRequest(id, email);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Apagar requisição por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequest(HttpServletRequest request, @PathVariable("id") Long requestId) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        service.deleteRequest(requestId, email);
        return ResponseEntity.noContent().build();
    }
}
