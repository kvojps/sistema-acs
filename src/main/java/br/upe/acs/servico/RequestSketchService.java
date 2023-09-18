package br.upe.acs.servico;

import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.enums.CertificadoStatusEnum;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import br.upe.acs.repositorio.CertificadoRepositorio;
import br.upe.acs.repositorio.RequisicaoRepositorio;
import br.upe.acs.utils.AcsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class RequestSketchService {

    private final RequisicaoRepositorio repository;
    private final CertificadoRepositorio certificateRepository;
    private final RequestService requestService;
    private final UserService userService;
    private final EmailService emailService;

    //TODO: This method really add a request?
    public Long addRequest(String email) throws AcsException {
        Usuario student = userService.findUserByEmail(email);
        List<Requisicao> requestsSketch = student.getRequisicoes().stream()
                .filter(requisicao -> requisicao.getStatusRequisicao().equals(RequisicaoStatusEnum.RASCUNHO)).toList();

        if (student.getHorasEnsino() + student.getHorasExtensao() + student.getHorasGestao() +
                student.getHorasPesquisa() >= student.getCurso().getHorasComplementares()) {
            throw new AcsException("The student has already completed his additional hours");
        }

        if (requestsSketch.size() >= 2) {
            throw new AcsException("Student can only have 2 draft requests");
        }

        Requisicao request = new Requisicao();
        request.setStatusRequisicao(RequisicaoStatusEnum.RASCUNHO);
        request.setCriacao(new Date());
        request.setUsuario(student);
        request.setCurso(student.getCurso());

        Requisicao requestSaved = repository.save(request);
        requestSaved.setIdRequisicao(String.format("%s-%05d",student.getCurso().getSigla(), requestSaved.getId()));
        repository.save(requestSaved);

        return requestSaved.getId();
    }

    public String submitRequest(Long requestId) throws AcsException {
        Requisicao request = requestService.findRequestById(requestId);

        if (request.getStatusRequisicao() != RequisicaoStatusEnum.RASCUNHO) {
            throw new AcsException("This request has already been submitted");
        }

        if (request.getCertificados().isEmpty()) {
            throw new AcsException("A request needs at least one certificate");
        }
        List<Certificado> invalidCertificates = request.getCertificados().stream()
                .filter(certificado -> !isValidCertificate(certificado)).toList();
        if (!invalidCertificates.isEmpty()) {
            throw new AcsException(
                    "Certificates: " + String.join( "; ", invalidCertificates.stream()
                            .map(certificado -> certificado.getId().toString()).toList())
                            + " have invalid data."
            );
        }
        String token = generateRequestToken();
        request.setToken(token);
        request.setDataDeSubmissao(new Date());
        request.setStatusRequisicao(RequisicaoStatusEnum.TRANSITO);
        modifyCertificates(request.getCertificados());
        repository.save(request);

        CompletableFuture.runAsync(() -> emailService.sendRequestStatusChanged(request));

        return token;
    }

    public void deleteRequest(Long requestId, String email) throws AcsException {
        Requisicao requisicao = requestService.findRequestById(requestId);
        if (!requisicao.getUsuario().getEmail().equals(email)) {
            throw new AcsException("User without permission to delete this request");
        }

        if (!requisicao.getStatusRequisicao().equals(RequisicaoStatusEnum.RASCUNHO)) {
            throw new AcsException("A request already submitted cannot be deleted");
        }

        repository.deleteById(requestId);
    }

    private boolean isValidCertificate(Certificado certificate) {
        boolean isValid = true;

        if (certificate.getCertificado() == null){
            isValid = false;
        } else if (certificate.getTitulo() == null || certificate.getTitulo().isBlank()) {
            isValid = false;
        } else if (certificate.getDataInicial().after(new Date())) {
            isValid = false;
        } else if (certificate.getDataFinal().after(new Date())) {
            isValid = false;
        } else if (certificate.getCargaHoraria() < 1) {
            isValid = false;
        } else if (certificate.getAtividade() == null) {
            isValid = false;
        }

        return isValid;
    }

    private String generateRequestToken() {
        String characters = "0123456789!@#$%.*";
        Random random = new Random();
        StringBuilder partialToken = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            partialToken.append(characters.charAt(index));
        }

        Instant timeStamp = Instant.now();
        long epochSeconds = timeStamp.getEpochSecond();

        return partialToken + Long.toString(epochSeconds);
    }

    private void modifyCertificates(List<Certificado> certificates) {
        for (Certificado certificado: certificates) {
            certificado.setStatusCertificado(CertificadoStatusEnum.ENCAMINHADO_COORDENACAO);
            certificateRepository.save(certificado);
        }
    }
}
