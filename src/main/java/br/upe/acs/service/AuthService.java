package br.upe.acs.service;

import br.upe.acs.config.JwtService;
import br.upe.acs.controller.responses.AuthenticationResponse;
import br.upe.acs.model.User;
import br.upe.acs.model.dto.LoginDTO;
import br.upe.acs.repository.UserRepository;
import br.upe.acs.utils.EmailUtils;
import br.upe.acs.utils.exceptions.AcsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static br.upe.acs.utils.AuthUtils.generateVerificationCode;
import static br.upe.acs.utils.AuthUtils.validatePassword;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final EmailUtils emailUtils;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse login(LoginDTO login) {
        User user = repository.findByEmail(login.getEmail()).orElseThrow(() -> new AcsException("There is no user associated with this email"));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));

        return generateAuthResponse(user);
    }

    public void verifyEmail(String email, String verificationCode) {
        User user = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this email"));

        if (user.isVerified()) {
            throw new AcsException("This user is already verified");
        } else if (!verificationCode.equals(user.getVerificationCode())) {
            throw new AcsException("The verification code is incorrect");
        }

        user.setVerified(true);
        repository.save(user);
    }

    public void getNewVerificationCode(String email) {
        User user = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this email"));

        if (user.isVerified()) {
            throw new AcsException("This user is already verified");
        }

        String newVerificationCode = generateVerificationCode();
        user.setVerificationCode(newVerificationCode);
        repository.save(user);

        CompletableFuture.runAsync(() -> emailUtils.sendVerificationCode(email, newVerificationCode));
    }

    public void updatePassword(String email, String password, String newPassword) {
        validatePassword(newPassword);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        User user = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this email"));
        user.setPassword(passwordEncoder.encode(newPassword));

        repository.save(user);
    }

    public void forgotPassword(String email) {
        User user = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this email"));

        Map<String, Object> claims = new HashMap<>();
        claims.put("recovery", true);
        String token = jwtService.generateToken(claims, user, 1000 * 60 * 15);

        CompletableFuture.runAsync(() -> emailUtils.sendRequestRecoveryPassword(user, token));
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
        User user = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this email"));
        validatePassword(newPassword);
        user.setPassword(passwordEncoder.encode(newPassword));

        repository.save(user);
    }

    private AuthenticationResponse generateAuthResponse(User user) {
        String jwtToken = jwtService.generateToken(user);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwtToken);

        return authenticationResponse;
    }
}
