package br.upe.acs.service;

import br.upe.acs.config.JwtService;
import br.upe.acs.controller.responses.AutenticacaoResposta;
import br.upe.acs.model.Usuario;
import br.upe.acs.model.dto.LoginDTO;
import br.upe.acs.utils.exceptions.AcsException;
import br.upe.acs.repository.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static br.upe.acs.utils.AuthUtils.generateVerificationCode;
import static br.upe.acs.utils.AuthUtils.validatePassword;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepositorio repository;
    private final EmailService emailService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AutenticacaoResposta login(LoginDTO login) {
        Usuario user = repository.findByEmail(login.getEmail()).orElseThrow(() -> new AcsException("There is no user associated with this email"));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getSenha()));

        return generateAuthResponse(user);
    }

    public void verifyEmail(String email, String verificationCode) {
        Usuario user = repository.findByEmail(email).orElseThrow(() -> new AcsException("There is no user associated with this email"));

        if (user.isVerificado()) {
            throw new AcsException("This user is already verified");
        } else if (!verificationCode.equals(user.getCodigoVerificacao())) {
            throw new AcsException("The verification code is incorrect");
        }

        user.setVerificado(true);
        repository.save(user);
    }

    public void getNewVerificationCode(String email) {
        Optional<Usuario> userOpt = repository.findByEmail(email);
        Usuario user = userOpt.orElseThrow(() -> new AcsException("There is no user associated with this email"));

        if (user.isVerificado()) {
            throw new AcsException("This user is already verified");
        }

        String newVerificationCode = generateVerificationCode();
        user.setCodigoVerificacao(newVerificationCode);
        repository.save(user);

        CompletableFuture.runAsync(() -> emailService.sendVerificationCode(email, newVerificationCode));
    }

    public void updatePassword(String email, String password, String newPassword) {
        validatePassword(newPassword);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        Usuario user = repository.findByEmail(email).orElseThrow(() -> new AcsException("There is no user associated with this email"));
        user.setSenha(passwordEncoder.encode(newPassword));

        repository.save(user);
    }

    public void forgotPassword(String email) {
        Usuario user = repository.findByEmail(email).orElseThrow(() -> new AcsException("There is no user associated with this email"));

        Map<String, Object> claims = new HashMap<>();
        claims.put("recovery", true);
        String token = jwtService.generateToken(claims, user, 1000 * 60 * 15);
        CompletableFuture.runAsync(() -> emailService.sendRequestRecoveryPassword(user, token));
    }

    public void recoveryPassword(String token, String newPassword) {
        boolean isTokenRecovery;

        try {
            isTokenRecovery = jwtService.extractClaim(token, (claims -> claims.get("recovery", Boolean.class)));
        } catch (Exception e) {
            throw new AcsException("Invalid token!");
        }

        if (!isTokenRecovery) {
            throw new AcsException("Invalid token!");
        }

        String email = jwtService.extractUsername(token);
        Optional<Usuario> userOpt = repository.findByEmail(email);
        Usuario user = userOpt.orElseThrow(() -> new AcsException("Invalid token"));
        validatePassword(newPassword);
        user.setSenha(passwordEncoder.encode(newPassword));

        repository.save(user);
    }

    private AutenticacaoResposta generateAuthResponse(Usuario user) {
        String jwtToken = jwtService.generateToken(user);
        AutenticacaoResposta authenticationResponse = new AutenticacaoResposta();
        authenticationResponse.setToken(jwtToken);

        return authenticationResponse;
    }
}
