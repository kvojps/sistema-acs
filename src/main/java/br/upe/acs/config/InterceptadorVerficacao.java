package br.upe.acs.config;

import br.upe.acs.dominio.Aluno;
import br.upe.acs.repositorio.AlunoRepositorio;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class InterceptadorVerficacao implements HandlerInterceptor {

    private final AlunoRepositorio alunoRepositorio;

    private final JwtService jwtService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String token = request.getHeader("Authorization").substring(7);
        final String email = jwtService.extractUsername(token);
        Optional<Aluno> aluno = alunoRepositorio.findByEmail(email);
        if (aluno.isPresent()) {
            response.setStatus(403);
            return aluno.orElseThrow().isVerificado();
        }
        return true;
    }


}
