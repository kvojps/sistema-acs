package br.upe.acs.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import br.upe.acs.model.Atividade;
import br.upe.acs.model.dto.CertificadoDTO;
import br.upe.acs.model.enums.CertificadoStatusEnum;
import br.upe.acs.model.enums.RequisicaoStatusEnum;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.upe.acs.model.Certificado;
import br.upe.acs.model.Requisicao;
import br.upe.acs.repository.CertificadoRepositorio;
import br.upe.acs.utils.exceptions.AcsException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CertificateService {

    private final CertificadoRepositorio repository;
    private final ReadRequestsUseCase readRequestsUseCase;
    private final ActivityService activityService;

    public Certificado createCertificate(MultipartFile file, Long requestId, String email) {
        Requisicao request = readRequestsUseCase.findRequestById(requestId);

        if (!Objects.equals(file.getContentType(), "application/pdf")) {
            throw new AcsException("Only pdf is accepted");
        }
        if (!request.getUsuario().getEmail().equals(email)) {
            throw new AcsException("Certificate not found");
        }
        if (request.getStatusRequisicao() != RequisicaoStatusEnum.RASCUNHO) {
            throw new AcsException("This request is already submitted and not pin new certificates");
        }
        if (request.getCertificados().size() >= 10) {
            throw new AcsException("This request has more certificates than allowed");
        }

        byte[] fileBytes;
        try {
            fileBytes = file.getBytes();
        } catch (IOException e) {
            throw new AcsException(e.getMessage());
        }

        if (isCertificateUnique(request, fileBytes)) {
            throw new AcsException("This certificate has already been registered");
        }

        Certificado certificate = new Certificado();
        certificate.setCertificado(fileBytes);
        certificate.setRequisicao(request);
        certificate.setStatusCertificado(CertificadoStatusEnum.RASCUNHO);

        return repository.save(certificate);
    }

    public Certificado findCertificateById(Long id) {
        return repository.findById(id).orElseThrow(() -> new AcsException("Certificate not found"));
    }

    public byte[] findCertificatePdfById(Long certificateId) {
        Certificado certificate = findCertificateById(certificateId);
        return certificate.getCertificado();
    }

    public void updateCertificate(Long certificateId, CertificadoDTO certificateDto, String email) {
        Certificado certificate = findCertificateById(certificateId);
        if (!certificate.getRequisicao().getUsuario().getEmail().equals(email)) {
            throw new AcsException("Certificate not found");
        }
        Atividade activity = null;
        if (certificateDto.getAtividadeId() != 0) {
            activity = activityService.findActivityById(certificateDto.getAtividadeId());
        }

        certificate.setTitulo(certificateDto.getTitulo());
        certificate.setAtividade(activity);

        if (certificateDto.getDataIncial() != null) {
            certificate.setDataInicial(convertDate(certificateDto.getDataIncial()));
        }

        if (certificateDto.getDataFinal() != null) {
            certificate.setDataFinal(convertDate(certificateDto.getDataFinal()));
        }

        certificate.setCargaHoraria((certificateDto.getQuantidadeDeHoras()));

        repository.save(certificate);
    }

    public void deleteCertificate(Long certificateId, String email) {
        Certificado certificate = findCertificateById(certificateId);
        if (!certificate.getRequisicao().getUsuario().getEmail().equals(email)) {
            throw new AcsException("Certificate not found");
        }

        if (!certificate.getStatusCertificado().equals(CertificadoStatusEnum.RASCUNHO)) {
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

    private boolean isCertificateUnique(Requisicao requisicao, byte[] bytes) {
        return requisicao.getCertificados().stream()
                .anyMatch(certificado -> Arrays.equals(certificado.getCertificado(), bytes));
    }
}
