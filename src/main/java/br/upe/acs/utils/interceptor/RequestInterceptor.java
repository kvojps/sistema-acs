package br.upe.acs.utils.interceptor;

import br.upe.acs.config.JwtService;
import br.upe.acs.model.User;
import br.upe.acs.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class RequestInterceptor implements HandlerInterceptor {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String token = request.getHeader("Authorization").substring(7);
        final String email = jwtService.extractUsername(token);
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && !user.get().isVerified()) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(403);
            response.getWriter().write("""
                    {
                        "message": "Unverified user!"
                    }
                    """);
            return false;
        }
        return true;
    }
}
