package br.upe.acs.config;

import br.upe.acs.dominio.Usuario;
import br.upe.acs.interceptador.InterceptadorVerficacao;
import br.upe.acs.repositorio.UsuarioRepositorio;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig implements WebMvcConfigurer {

	private final UsuarioRepositorio usuarioRepositorio;
	private final JwtService jwtService;

	@Bean
	public UserDetailsService userDetailsService() {
		return this::findByEmail;
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new InterceptadorVerficacao(usuarioRepositorio, jwtService))
				.addPathPatterns("/api/requisicao/**", "/api/atividade/**", "/api/certificado/**");
	}
	private Usuario findByEmail(String email) {
		Usuario usuario = null;
		if(usuarioRepositorio.findByEmail(email).isPresent()) {
			usuario = usuarioRepositorio.findByEmail(email).orElseThrow();
		}

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}

		return usuario;
	}
}
