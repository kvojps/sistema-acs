package br.upe.acs.service;

import br.upe.acs.controller.responses.RequestResumeResponse;
import br.upe.acs.model.Certificate;
import br.upe.acs.model.Request;
import br.upe.acs.model.User;
import br.upe.acs.model.enums.CertificateStatusEnum;
import br.upe.acs.model.enums.AxleEnum;
import br.upe.acs.model.enums.RequestStatusEnum;
import br.upe.acs.repository.CertificateRepository;
import br.upe.acs.repository.RequestRepository;
import br.upe.acs.utils.EmailUtils;
import br.upe.acs.utils.RequestPdfUtils;
import br.upe.acs.utils.exceptions.AcsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import static br.upe.acs.utils.PaginationUtils.generatePagination;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository repository;
    private final CertificateRepository certificateRepository;
    private final UserService userService;
    private final RequestPdfUtils requestPdfUtils;
    private final EmailUtils emailUtils;

    public Long createRequest(String email) {
        User student = userService.findUserByEmail(email);
        List<Request> requestsSketch = student.getRequests().stream()
                .filter(request -> request.getStatus().equals(RequestStatusEnum.RASCUNHO)).toList();

        if (student.getHoursEnsino() + student.getHoursExtensao() + student.getHoursGestao() +
                student.getHoursPesquisa() >= student.getCourse().getAdditionalHours()) {
            throw new AcsException("The student has already completed his additional hours");
        }

        if (requestsSketch.size() >= 2) {
            throw new AcsException("Student can only have 2 draft requests");
        }

        Request request = new Request();
        request.setStatus(RequestStatusEnum.RASCUNHO);
        request.setCreateAt(new Date());
        request.setUser(student);

        Request requestSaved = repository.save(request);
        requestSaved.setSemanticId(String.format("%s-%05d", student.getCourse().getAcronym(), requestSaved.getId()));
        repository.save(requestSaved);

        return requestSaved.getId();
    }

    public byte[] createRequestPdf(Long requestId) {
        Request request = findRequestById(requestId);
        return requestPdfUtils.generateRequestPdf(request);
    }

    public String submitRequest(Long requestId) {
        Request request = findRequestById(requestId);

        if (request.getStatus() != RequestStatusEnum.RASCUNHO) {
            throw new AcsException("This request has already been submitted");
        }

        if (request.getCertificates().isEmpty()) {
            throw new AcsException("A request needs at least one certificate");
        }
        List<Certificate> invalidCertificates = request.getCertificates().stream()
                .filter(certificate -> !isValidCertificate(certificate)).toList();
        if (!invalidCertificates.isEmpty()) {
            throw new AcsException(
                    "Certificates: " + String.join("; ", invalidCertificates.stream()
                            .map(certificate -> certificate.getId().toString()).toList())
                            + " have invalid data."
            );
        }
        String token = generateRequestToken();
        request.setToken(token);
        request.setSentAt(new Date());
        request.setStatus(RequestStatusEnum.TRANSITO);
        modifyCertificatesStatus(request.getCertificates());
        repository.save(request);

        CompletableFuture.runAsync(() -> emailUtils.sendRequestStatusChanged(request));

        return token;
    }

    public Map<String, Object> listRequests(Boolean isArchived, RequestStatusEnum status, Long userId, Long courseId, int page, int amount) {
        List<RequestResumeResponse> requests = repository.findWithFilters(isArchived, status, userId, courseId)
                .stream().map(RequestResumeResponse::new).toList();

        return generatePagination(requests, page, amount);
    }

    public Map<String, Object> listStudentRequestsByAxle(Long studentId, AxleEnum axle, int page, int amount) {
        List<RequestResumeResponse> studentRequests = repository.findRequestsByUserIdAndAxle(studentId, axle)
                .stream().map(RequestResumeResponse::new).toList();

        return generatePagination(studentRequests, page, amount);
    }

    public Request findRequestById(Long id) {
        return repository.findById(id).orElseThrow(() -> new AcsException("Request not found"));
    }

    public void archiveRequest(Long id, String email) {
        boolean isFinished = false;
        Request request = repository.findById(id).orElseThrow(() -> new AcsException("Request not found"));
        User user = userService.findUserByEmail(email);
        RequestStatusEnum status = request.getStatus();

        if (!user.equals(request.getUser())) {
            throw new AcsException("User not authorized to archive this request");
        }
        if (status == RequestStatusEnum.ACEITO || status == RequestStatusEnum.NEGADO) {
            isFinished = true;
        }
        if (!isFinished) {
            throw new AcsException("Unable to archive an unfinished request");
        }

        if (!request.isArchived()) {
            request.setArchived(true);
            repository.save(request);
        } else {
            throw new AcsException("Request already archived");
        }
    }

    public void unarchiveRequest(Long id, String email) {
        Request request = repository.findById(id).orElseThrow();
        User user = userService.findUserByEmail(email);

        if (!user.equals(request.getUser())) {
            throw new AcsException("User not authorized to unarchive this request");
        }

        if (request.isArchived()) {
            request.setArchived(false);
            repository.save(request);
        } else {
            throw new AcsException("The request is not archived");
        }
    }

    public void deleteRequest(Long requestId, String email) {
        Request request = findRequestById(requestId);
        if (!request.getUser().getEmail().equals(email)) {
            throw new AcsException("User without permission to delete this request");
        }

        if (!request.getStatus().equals(RequestStatusEnum.RASCUNHO)) {
            throw new AcsException("A request already submitted cannot be deleted");
        }

        repository.deleteById(requestId);
    }

    private boolean isValidCertificate(Certificate certificate) {
        boolean isValid = true;

        if (certificate.getCertificate() == null) {
            isValid = false;
        } else if (certificate.getTitle() == null || certificate.getTitle().isBlank()) {
            isValid = false;
        } else if (certificate.getStartDate().after(new Date())) {
            isValid = false;
        } else if (certificate.getEndDate().after(new Date())) {
            isValid = false;
        } else if (certificate.getWorkload() < 1) {
            isValid = false;
        } else if (certificate.getActivity() == null) {
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

    private void modifyCertificatesStatus(List<Certificate> certificates) {
        for (Certificate certificate : certificates) {
            certificate.setStatus(CertificateStatusEnum.ENCAMINHADO_COORDENACAO);
            certificateRepository.save(certificate);
        }
    }
}
