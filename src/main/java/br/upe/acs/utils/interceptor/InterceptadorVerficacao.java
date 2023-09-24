package br.upe.acs.utils.interceptor;

import br.upe.acs.config.JwtService;
import br.upe.acs.model.Usuario;
import br.upe.acs.repository.UsuarioRepositorio;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class InterceptadorVerficacao implements HandlerInterceptor {

    private final UsuarioRepositorio usuarioRepositorio;

    private final JwtService jwtService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String token = request.getHeader("Authorization").substring(7);
        final String email = jwtService.extractUsername(token);
        Optional<Usuario> usuario = usuarioRepositorio.findByEmail(email);
        if (usuario.isPresent() && !usuario.get().isVerificado()) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(403);
            response.getWriter().write("""
                    {
                        "mensagem": "Usuário não verificado"
                    }
                    """);
            return false;
        }
        return true;
    }


}
