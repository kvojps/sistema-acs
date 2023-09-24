package br.upe.acs.controlador;

import br.upe.acs.controlador.respostas.RequisicaoResposta;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.enums.EixoEnum;
import br.upe.acs.servico.ReadRequestsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/requests")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RequestController {

    private final ReadRequestsUseCase servico;

    @GetMapping
    public ResponseEntity<Map<String, ?>> listRequests(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int amount) {
        return ResponseEntity.ok(servico.listRequests(page, amount));
    }

    @GetMapping("/non-sketch")
    public ResponseEntity<Map<String, Object>> listNonSketchRequests(@RequestParam(defaultValue = "0") int page,
                                                                     @RequestParam(defaultValue = "10") int amount) {
        return ResponseEntity.ok(servico.listNonSketchRequests(page, amount));
    }

    @GetMapping("/archived")
    public ResponseEntity<?> listArchivedRequests(@AuthenticationPrincipal Usuario user) {
        return ResponseEntity.ok(servico.listArchivedRequests(user.getId())
                .stream().map(RequisicaoResposta::new).toList());
    }

    @GetMapping("/unarchived")
    public ResponseEntity<?> listUnarchivedRequests(@AuthenticationPrincipal Usuario user, @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int amount) {
        return ResponseEntity.ok(servico.listStudentUnarchivedRequests(user.getId(), page, amount));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> listRequestsByStudent(@PathVariable("id") Long studentId, @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int amount) {
        return ResponseEntity.ok(servico.listRequestByStudent(studentId, page, amount));
    }

    @GetMapping("/user/{id}/{axle}")
    public ResponseEntity<Map<String, ?>> listStudentRequestsPaginatedByAxle(@PathVariable("id") Long studentId,
                                                                             @PathVariable("axle") EixoEnum axle,
                                                                             @RequestParam(defaultValue = "0") int page,
                                                                             @RequestParam(defaultValue = "10") int amount) {
        return ResponseEntity.ok(servico.listStudentRequestsByAxle(studentId, axle, page, amount));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequisicaoResposta> findRequestById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new RequisicaoResposta(servico.findRequestById(id)));
    }
}
