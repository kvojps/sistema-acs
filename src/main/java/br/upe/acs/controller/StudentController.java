package br.upe.acs.controller;

import br.upe.acs.config.JwtService;
import br.upe.acs.model.vo.AtividadeComplementarVO;
import br.upe.acs.model.vo.MinhasHorasNaAtividadeVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.upe.acs.service.StudentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/student/utilization")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService service;
    private final JwtService jwtService;

    @GetMapping
    public ResponseEntity<AtividadeComplementarVO> getStudentAcs(HttpServletRequest request) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        return ResponseEntity.ok(service.getStudentAcs(email));
    }

    @GetMapping("/hours/{activityId}")
    public ResponseEntity<MinhasHorasNaAtividadeVO> getActivityHours(HttpServletRequest request, @PathVariable("activityId") Long activityId) {
        String email = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        return ResponseEntity.ok(service.getHoursAcsStatusByActivity(email, activityId));
    }
}
