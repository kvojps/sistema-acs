package br.upe.acs.service;

import br.upe.acs.model.Course;
import br.upe.acs.model.Address;
import br.upe.acs.model.User;
import br.upe.acs.model.dto.AddressDTO;
import br.upe.acs.model.dto.RegistrationDTO;
import br.upe.acs.model.dto.UserUpdateDTO;
import br.upe.acs.model.enums.RoleEnum;
import br.upe.acs.repository.UserRepository;
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

    private final UserRepository repository;
    private final AddressService addressService;
    private final CourseService courseService;
    private final EmailUtils emailUtils;
    private final PasswordEncoder passwordEncoder;

    public User createUser(RegistrationDTO userDto) {
        validateUser(userDto);

        ModelMapper modelMapper = new ModelMapper();
        User userToSave = modelMapper.map(userDto, User.class);
        userToSave.setPassword(passwordEncoder.encode(userDto.password()));
        userToSave.setVerificationCode(generateVerificationCode());
        userToSave.setVerified(false);
        userToSave.setEnabled(true);
        userToSave.setAddress(addUserAddress(userDto));
        userToSave.setCourse(courseService.findCourseById(userDto.courseId()));
        userToSave.setRole(RoleEnum.ALUNO);

        User userSaved = repository.save(userToSave);

        CompletableFuture.runAsync(() -> emailUtils.sendVerificationCode(userDto.email(), userToSave.getVerificationCode()));

        return userSaved;
    }

    public User findUserById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new AcsException("There is no user associated with this id"));
    }

    public User findUserByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() ->
                new AcsException("There is no user associated with this email"));
    }

    public void updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        User user = findUserById(id);

        user.setFullName(userUpdateDTO.fullName());
        user.setPhone(userUpdateDTO.phone());
        Course course = courseService.findCourseById(userUpdateDTO.courseId());
        user.setCourse(course);
        repository.save(user);
    }

    public void deactivateUser(String email) {
        User user = findUserByEmail(email);

        if (user.getRequests().isEmpty()) {
            repository.deleteById(user.getId());
        } else {
            user.setEnabled(false);
        }
    }

    private void validateUser(RegistrationDTO authDto) {
        String formattedCpf = authDto.cpf().replaceAll("[^0-9]", "");
        boolean cpfExists = repository.findByCpf(formattedCpf).isPresent();
        boolean emailExists = repository.findByEmail(authDto.email()).isPresent();
        AuthUtils authValidation = new AuthUtils();
        authValidation.validateAuthData(authDto, cpfExists, emailExists);
    }

    private Address addUserAddress(RegistrationDTO authDto) {
        ModelMapper modelMapper = new ModelMapper();
        AddressDTO addressToSave = modelMapper.map(authDto, AddressDTO.class);
        return addressService.createAddress(addressToSave);
    }
}
