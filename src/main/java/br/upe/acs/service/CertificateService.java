package br.upe.acs.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import br.upe.acs.model.Activity;
import br.upe.acs.model.dto.CertificateDTO;
import br.upe.acs.model.enums.CertificateStatusEnum;
import br.upe.acs.model.enums.RequestStatusEnum;
import br.upe.acs.utils.exceptions.ConvertFileException;
import br.upe.acs.utils.exceptions.InvalidFileFormatException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.upe.acs.model.Certificate;
import br.upe.acs.model.Request;
import br.upe.acs.repository.CertificateRepository;
import br.upe.acs.utils.exceptions.AcsException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CertificateService {

    private final CertificateRepository repository;
    private final RequestService requestService;
    private final ActivityService activityService;

    public Certificate createCertificate(MultipartFile file, Long requestId, String email) {
        Request request = requestService.findRequestById(requestId);

        if (!Objects.equals(file.getContentType(), "application/pdf")) {
            throw new InvalidFileFormatException("Only pdf is accepted");
        }
        if (!request.getUser().getEmail().equals(email)) {
            throw new AcsException("Certificate not found");
        }
        if (request.getStatus() != RequestStatusEnum.RASCUNHO) {
            throw new AcsException("This request is already submitted and not pin new certificates");
        }
        if (request.getCertificates().size() >= 10) {
            throw new InvalidFileFormatException("This request has more certificates than allowed");
        }

        byte[] fileBytes;
        try {
            fileBytes = file.getBytes();
        } catch (IOException e) {
            throw new ConvertFileException(e.getMessage());
        }

        if (isCertificateUnique(request, fileBytes)) {
            throw new AcsException("This certificate has already been registered");
        }

        Certificate certificate = new Certificate();
        certificate.setCertificate(fileBytes);
        certificate.setRequest(request);
        certificate.setStatus(CertificateStatusEnum.RASCUNHO);

        return repository.save(certificate);
    }

    public Certificate findCertificateById(Long id) {
        return repository.findById(id).orElseThrow(() -> new AcsException("Certificate not found"));
    }

    public byte[] findCertificatePdfById(Long certificateId) {
        Certificate certificate = findCertificateById(certificateId);
        return certificate.getCertificate();
    }

    public void updateCertificate(Long certificateId, CertificateDTO certificateDto, String email) {
        Certificate certificate = findCertificateById(certificateId);
        if (!certificate.getRequest().getUser().getEmail().equals(email)) {
            throw new AcsException("Certificate not found");
        }
        Activity activity = null;
        if (certificateDto.activityId() != 0) {
            activity = activityService.findActivityById(certificateDto.activityId());
        }

        certificate.setTitle(certificateDto.title());
        certificate.setActivity(activity);

        if (certificateDto.startDate() != null) {
            certificate.setStartDate(convertDate(certificateDto.startDate()));
        }

        if (certificateDto.endDate() != null) {
            certificate.setEndDate(convertDate(certificateDto.endDate()));
        }

        certificate.setWorkload((certificateDto.workload()));

        repository.save(certificate);
    }

    public void deleteCertificate(Long certificateId, String email) {
        Certificate certificate = findCertificateById(certificateId);
        if (!certificate.getRequest().getUser().getEmail().equals(email)) {
            throw new AcsException("Certificate not found");
        }

        if (!certificate.getStatus().equals(CertificateStatusEnum.RASCUNHO)) {
            throw new AcsException("A certificate already submitted cannot be deleted");
        }

        repository.deleteById(certificateId);
    }

    private Date convertDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(dateString);
        } catch (ParseException e) {
            throw new AcsException(e.getMessage());
        }
    }

    private boolean isCertificateUnique(Request request, byte[] bytes) {
        return request.getCertificates().stream()
                .anyMatch(certificate -> Arrays.equals(certificate.getCertificate(), bytes));
    }
}
