package br.upe.acs.servico;

import br.upe.acs.dominio.Curso;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.repositorio.UsuarioRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static br.upe.acs.utils.AuthUtils.generateVerificationCode;
import static br.upe.acs.utils.AuthUtils.validatePassword;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsuarioRepositorio repository;
    private final CursoServico courseService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final EmailServico emailService;

    public Usuario findUserById(Long id) throws AcsExcecao {
        Optional<Usuario> user = repository.findById(id);
        return user.orElseThrow(() -> new AcsExcecao("There is no user associated with this id"));
    }

    public Usuario findUserByEmail(String email) throws AcsExcecao {
        Optional<Usuario> user = repository.findByEmail(email);
        return user.orElseThrow(() -> new AcsExcecao("There is no user associated with this email"));

    }

    //TODO: Mover para AccessControlService
    public void verifyUser(String email, String verificationCode) throws AcsExcecao {
        Usuario user = findUserByEmail(email);

        if (user.isVerificado()) {
            throw new AcsExcecao("This user is already verified");
        } else if (!verificationCode.equals(user.getCodigoVerificacao())) {
            throw new AcsExcecao("The verification code is incorrect");
        }

        user.setVerificado(true);
        repository.save(user);
    }

    //TODO: Mover para AccessControlService
    public void resendVerificationCode(String email) throws AcsExcecao {
        Usuario user = findUserByEmail(email);

        if (user.isVerificado()) {
            throw new AcsExcecao("This user is already verified");
        }

        String newVerificationCode = generateVerificationCode();
        user.setCodigoVerificacao(newVerificationCode);
        repository.save(user);

        CompletableFuture.runAsync(() -> emailService.enviarEmailCodigoVerificacao(email, newVerificationCode));
    }

    //TODO: Mover para AccessControlService
    public void changePassword(String email, String password, String newPassword) throws AcsExcecao {
        validatePassword(newPassword);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        if (repository.findByEmail(email).isPresent()) {
            Usuario user = repository.findByEmail(email).orElseThrow(() -> new AcsExcecao("There is no user associated with this email"));
            user.setSenha(passwordEncoder.encode(newPassword));
            repository.save(user);
        }
    }

    public void updateUser(String email, String fullName, String phone, Long courseId) throws AcsExcecao {
        Usuario user = repository.findByEmail(email).orElseThrow(() -> new AcsExcecao("There is no user associated with this email"));

        user.setNomeCompleto(fullName);
        user.setTelefone(phone);
        Curso curso = courseService.buscarCursoPorId(courseId);
        user.setCurso(curso);
        repository.save(user);
    }

    public void deactivateUser(String email) throws AcsExcecao {
        Usuario user = findUserByEmail(email);

        if (user.getRequisicoes().isEmpty()) {
            repository.deleteById(user.getId());
        } else {
            user.setEnabled(false);
        }
    }
}
