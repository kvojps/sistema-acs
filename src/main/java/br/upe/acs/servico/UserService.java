package br.upe.acs.servico;

import br.upe.acs.dominio.Curso;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.repositorio.UsuarioRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsuarioRepositorio repository;
    private final CursoServico courseService;

    public Usuario findUserById(Long id) throws AcsExcecao {
        Optional<Usuario> user = repository.findById(id);
        return user.orElseThrow(() ->
                new AcsExcecao("There is no user associated with this id"));
    }

    public Usuario findUserByEmail(String email) throws AcsExcecao {
        Optional<Usuario> user = repository.findByEmail(email);
        return user.orElseThrow(() ->
                new AcsExcecao("There is no user associated with this email"));
    }

    public void updateUser(String email, String fullName, String phone, Long courseId) throws AcsExcecao {
        Usuario user = repository.findByEmail(email).orElseThrow(() ->
                new AcsExcecao("There is no user associated with this email"));

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
