package br.upe.acs.service;

import br.upe.acs.model.Course;
import br.upe.acs.model.Endereco;
import br.upe.acs.model.Usuario;
import br.upe.acs.model.dto.EnderecoDTO;
import br.upe.acs.model.dto.RegistroDTO;
import br.upe.acs.model.dto.UserUpdateDTO;
import br.upe.acs.model.enums.PerfilEnum;
import br.upe.acs.repository.UsuarioRepositorio;
import br.upe.acs.utils.AuthUtils;
import br.upe.acs.utils.EmailUtils;
import br.upe.acs.utils.exceptions.AcsException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import static br.upe.acs.utils.AuthUtils.generateVerificationCode;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsuarioRepositorio repository;
    private final AddressService addressService;
    private final CourseService courseService;
    private final EmailUtils emailUtils;
    private final PasswordEncoder passwordEncoder;

    public Usuario createUser(RegistroDTO userDto) {
        validateUser(userDto);

        ModelMapper modelMapper = new ModelMapper();
        Usuario userToSave = modelMapper.map(userDto, Usuario.class);
        userToSave.setSenha(passwordEncoder.encode(userDto.getSenha()));
        userToSave.setCodigoVerificacao(generateVerificationCode());
        userToSave.setVerificado(false);
        userToSave.setEnabled(true);
        userToSave.setEndereco(addUserAddress(userDto));
        userToSave.setCurso(courseService.findCourseById(userDto.getCursoId()));
        userToSave.setPerfil(PerfilEnum.ALUNO);

        Usuario userSaved = repository.save(userToSave);

        CompletableFuture.runAsync(() -> emailUtils.sendVerificationCode(userDto.getEmail(), userToSave.getCodigoVerificacao()));

        return userSaved;
    }

    public Usuario findUserById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new AcsException("There is no user associated with this id"));
    }

    public Usuario findUserByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this email"));
    }

    public void updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        Usuario user = findUserById(id);

        user.setNomeCompleto(userUpdateDTO.getFullName());
        user.setTelefone(userUpdateDTO.getPhone());
        Course course = courseService.findCourseById(userUpdateDTO.getCourseId());
        user.setCurso(course);
        repository.save(user);
    }

    public void deactivateUser(String email) {
        Usuario user = findUserByEmail(email);

        if (user.getRequisicoes().isEmpty()) {
            repository.deleteById(user.getId());
        } else {
            user.setEnabled(false);
        }
    }

    private void validateUser(RegistroDTO authDto) {
        String formattedCpf = authDto.getCpf().replaceAll("[^0-9]", "");
        boolean cpfExists = repository.findByCpf(formattedCpf).isPresent();
        boolean emailExists = repository.findByEmail(authDto.getEmail()).isPresent();
        AuthUtils authValidation = new AuthUtils();
        authValidation.validateAuthData(authDto, cpfExists, emailExists);
    }

    private Endereco addUserAddress(RegistroDTO authDto) {
        ModelMapper modelMapper = new ModelMapper();
        EnderecoDTO addressToSave = modelMapper.map(authDto, EnderecoDTO.class);
        return addressService.createAddress(addressToSave);
    }
}
