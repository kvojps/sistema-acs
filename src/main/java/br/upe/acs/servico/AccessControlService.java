package br.upe.acs.servico;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.respostas.AutenticacaoResposta;
import br.upe.acs.dominio.Endereco;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.dto.EnderecoDTO;
import br.upe.acs.dominio.dto.LoginDTO;
import br.upe.acs.dominio.dto.RegistroDTO;
import br.upe.acs.dominio.enums.PerfilEnum;
import br.upe.acs.repositorio.UsuarioRepositorio;
import br.upe.acs.exceptions.AcsException;
import br.upe.acs.utils.AuthUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
public class AccessControlService {

    private final UsuarioRepositorio repository;
    private final JwtService jwtService;
    private final AddressService addressService;
    private final CourseService courseService;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AutenticacaoResposta registerUser(RegistroDTO authDto) {
        validateUserRegister(authDto);

        ModelMapper modelMapper = new ModelMapper();
        Usuario userToSave = modelMapper.map(authDto, Usuario.class);
        userToSave.setSenha(passwordEncoder.encode(authDto.getSenha()));
        userToSave.setCodigoVerificacao(generateVerificationCode());
        userToSave.setVerificado(false);
        userToSave.setEnabled(true);
        userToSave.setEndereco(addUserAddress(authDto));
        userToSave.setCurso(courseService.findCourseById(authDto.getCursoId()));
        userToSave.setPerfil(PerfilEnum.ALUNO);

        repository.save(userToSave);

        CompletableFuture.runAsync(() -> emailService.sendVerificationCode(authDto.getEmail(), userToSave.getCodigoVerificacao()));

        return generateAuthResponse(userToSave);
    }

    public AutenticacaoResposta loginUser(LoginDTO login) {
        Usuario user = repository.findByEmail(login.getEmail()).orElseThrow(() ->
                new AcsException("There is no user associated with this email"));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getSenha()));

        return generateAuthResponse(user);
    }

    public void verifyUser(String email, String verificationCode) {
        Usuario user = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this email"));

        if (user.isVerificado()) {
            throw new AcsException("This user is already verified");
        } else if (!verificationCode.equals(user.getCodigoVerificacao())) {
            throw new AcsException("The verification code is incorrect");
        }

        user.setVerificado(true);
        repository.save(user);
    }

    public void resendVerificationCode(String email) {
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

    public void changePassword(String email, String password, String newPassword) {
        validatePassword(newPassword);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        Usuario user = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this email"));
        user.setSenha(passwordEncoder.encode(newPassword));

        repository.save(user);
    }

    public void recoveryAccount(String email) {
        Usuario user = repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this email"));

        Map<String, Object> claims = new HashMap<>();
        claims.put("recovery", true);
        String token = jwtService.generateToken(claims, user, 1000 * 60 * 15);
        CompletableFuture.runAsync(() -> emailService.sendRequestRecoveryPassword(user, token));
    }

    public void forgotPassword(String token, String newPassword) {
        boolean isTokenRecovery;

        try {
            isTokenRecovery = jwtService.extractClaim(token,
                    (claims -> claims.get("recovery", Boolean.class)));
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

    private void validateUserRegister(RegistroDTO authDto) {
        String formattedCpf = authDto.getCpf().replaceAll("[^0-9]", "");
        boolean cpfExists = repository.findByCpf(formattedCpf).isPresent();
        boolean emailExists = repository.findByEmail(authDto.getEmail()).isPresent();
        AuthUtils authValidation = new AuthUtils();
        authValidation.validateAuthData(authDto, cpfExists, emailExists);
    }

    private Endereco addUserAddress(RegistroDTO authDto) {
        ModelMapper modelMapper = new ModelMapper();
        EnderecoDTO addressToSave = modelMapper.map(authDto, EnderecoDTO.class);
        return addressService.addAddress(addressToSave);
    }

    private AutenticacaoResposta generateAuthResponse(Usuario user) {
        String jwtToken = jwtService.generateToken(user);
        AutenticacaoResposta authenticationResponse = new AutenticacaoResposta();
        authenticationResponse.setToken(jwtToken);

        return authenticationResponse;
    }
}
