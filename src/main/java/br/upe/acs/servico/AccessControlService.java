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
import br.upe.acs.utils.AcsExcecao;
import br.upe.acs.utils.AuthUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import static br.upe.acs.utils.AuthUtils.generateVerificationCode;

@Service
@RequiredArgsConstructor
public class AccessControlService {

    private final UsuarioRepositorio userRepository;
    private final JwtService jwtService;
    private final EnderecoServico addressService;
    private final CursoServico courseService;
    private final EmailServico emailService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AutenticacaoResposta registerUser(RegistroDTO authDto) throws AcsExcecao {
        validateUserRegister(authDto);

        ModelMapper modelMapper = new ModelMapper();

        Usuario userToSave = modelMapper.map(authDto, Usuario.class);
        userToSave.setSenha(passwordEncoder.encode(authDto.getSenha()));
        userToSave.setCodigoVerificacao(generateVerificationCode());
        userToSave.setVerificado(false);
        userToSave.setEnabled(true);
        userToSave.setEndereco(addUserAddress(authDto));
        userToSave.setCurso(courseService.buscarCursoPorId(authDto.getCursoId()));
        userToSave.setPerfil(PerfilEnum.ALUNO);

        userRepository.save(userToSave);

        CompletableFuture.runAsync(() -> emailService.enviarEmailCodigoVerificacao(authDto.getEmail(), userToSave.getCodigoVerificacao()));

        return generateAuthResponse(userToSave);
    }

    public AutenticacaoResposta loginUser(LoginDTO login) throws AcsExcecao {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getSenha()));

        Usuario usuario;
        if (userRepository.findByEmail(login.getEmail()).isPresent()) {
            usuario = userRepository.findByEmail(login.getEmail()).orElseThrow();
        } else {
            throw new AcsExcecao("User not found!");
        }

        return generateAuthResponse(usuario);
    }

    private void validateUserRegister(RegistroDTO authDto) throws AcsExcecao {
        String formattedCpf = authDto.getCpf().replaceAll("[^0-9]", "");
        boolean cpfExists = userRepository.findByCpf(formattedCpf).isPresent();
        boolean emailExists = userRepository.findByEmail(authDto.getEmail()).isPresent();
        AuthUtils authValidation = new AuthUtils();
        authValidation.validateAuthData(authDto, cpfExists, emailExists);
    }

    private Endereco addUserAddress(RegistroDTO authDto) {
        ModelMapper modelMapper = new ModelMapper();
        EnderecoDTO addressToSave = modelMapper.map(authDto, EnderecoDTO.class);
        return addressService.adicionarEndereco(addressToSave);
    }

    private AutenticacaoResposta generateAuthResponse(Usuario user) {
        String jwtToken = jwtService.generateToken(user);
        AutenticacaoResposta authenticationResponse = new AutenticacaoResposta();
        authenticationResponse.setToken(jwtToken);

        return authenticationResponse;
    }
}
