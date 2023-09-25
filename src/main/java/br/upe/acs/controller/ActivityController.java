package br.upe.acs.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.model.enums.EixoEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.upe.acs.controller.responses.AtividadeResposta;
import br.upe.acs.model.dto.AtividadeDTO;
import br.upe.acs.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/activities")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ActivityController {

    private final ActivityService servico;

    @PostMapping
    public ResponseEntity<AtividadeResposta> createActivity(@RequestBody AtividadeDTO activity) {
        return ResponseEntity.ok(new AtividadeResposta(servico.createActivity(activity)));
    }

    @GetMapping
    public ResponseEntity<List<AtividadeResposta>> listActivities() {
        return ResponseEntity.ok(servico.listActivities().stream().map(AtividadeResposta::new)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadeResposta> findActivityById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new AtividadeResposta(servico.findActivityById(id)));
    }

    @GetMapping("/axle")
    public ResponseEntity<List<AtividadeResposta>> findActivityByAxle(@RequestParam EixoEnum axle) {
        return ResponseEntity.ok(servico.findActivityByAxle(axle).stream().map(AtividadeResposta::new).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateActivity(@PathVariable("id") Long id, @RequestBody AtividadeDTO activityDto) {
        servico.updateActivity(id, activityDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable("id") Long id) {
        servico.deleteActivity(id);
        return ResponseEntity.noContent().build();
    }
}
