package br.upe.acs.controller;

import br.upe.acs.config.JwtService;
import br.upe.acs.model.vo.AdditionalActivitiesVO;
import br.upe.acs.model.vo.MyHoursInActivityVO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.upe.acs.service.StudentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/student-dashboard")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudentDashboardController {

    private final StudentService service;
    private final JwtService jwtService;

    @Operation(summary = "Listar atividades complementares por token")
    @GetMapping
    public ResponseEntity<AdditionalActivitiesVO> getStudentAcs(HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        return ResponseEntity.ok(service.getStudentAcs(email));
    }

    @Operation(summary = "Buscar horas em atividade por token")
    @GetMapping("/{activityId}")
    public ResponseEntity<MyHoursInActivityVO> getActivityHours(HttpServletRequest request, @PathVariable("activityId") Long activityId) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        return ResponseEntity.ok(service.getHoursAcsStatusByActivity(email, activityId));
    }
}
