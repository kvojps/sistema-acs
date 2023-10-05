package br.upe.acs.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.model.enums.AxleEnum;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.upe.acs.controller.responses.ActivityResponse;
import br.upe.acs.model.dto.ActivityDTO;
import br.upe.acs.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/activities")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ActivityController {

    private final ActivityService service;

    @Operation(summary = "Criar atividade")
    @PostMapping
    public ResponseEntity<ActivityResponse> createActivity(@RequestBody ActivityDTO activity) {
        return ResponseEntity.ok(new ActivityResponse(service.createActivity(activity)));
    }

    @Operation(summary = "Listar atividades")
    @GetMapping
    public ResponseEntity<List<ActivityResponse>> listActivities(@RequestParam(required = false) AxleEnum axle) {
        return ResponseEntity.ok(service.listActivities(axle).stream().map(ActivityResponse::new)
                .collect(Collectors.toList()));
    }

    @Operation(summary = "Buscar atividade por id")
    @GetMapping("/{id}")
    public ResponseEntity<ActivityResponse> findActivityById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new ActivityResponse(service.findActivityById(id)));
    }

    @Operation(summary = "Atualizar atividade por id")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateActivity(@PathVariable("id") Long id, @RequestBody ActivityDTO activityDto) {
        service.updateActivity(id, activityDto);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Apagar atividade por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable("id") Long id) {
        service.deleteActivity(id);
        return ResponseEntity.noContent().build();
    }
}
