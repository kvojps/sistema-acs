package br.upe.acs.servico;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import br.upe.acs.dominio.Atividade;
import br.upe.acs.dominio.dto.CertificadoDTO;
import br.upe.acs.dominio.enums.CertificadoStatusEnum;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.repositorio.CertificadoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CertificateService {

    private final CertificadoRepositorio repository;
    private final RequisicaoServico requestService;
    private final ActivityService activityService;

    public Certificado findCertificateById(Long id) throws AcsExcecao {
        return repository.findById(id).orElseThrow(() ->
                new AcsExcecao("Certificate not found"));
    }

    public byte[] findCertificatePdfById(Long certificateId) throws AcsExcecao {
        Certificado certificate = findCertificateById(certificateId);
        return certificate.getCertificado();
    }

    public Long addCertificate(MultipartFile file, Long requestId, String email) throws AcsExcecao, IOException {
        Requisicao requisicao = requestService.buscarRequisicaoPorId(requestId);

        if (!Objects.equals(file.getContentType(), "application/pdf")) {
            throw new AcsExcecao("Only pdf is accepted");
        }
        if (!requisicao.getUsuario().getEmail().equals(email)) {
            throw new AcsExcecao("Certificate not found");
        }
        if (requisicao.getStatusRequisicao() != RequisicaoStatusEnum.RASCUNHO) {
            throw new AcsExcecao("This request is already submitted and not pin new certificates");
        }
        if (requisicao.getCertificados().size() >= 10) {
            throw new AcsExcecao("This request has more certificates than allowed");
        }

        byte[] fileBytes = file.getBytes();

        if (isCertificateUnique(requisicao, fileBytes)) {
            throw new AcsExcecao("This certificate has already been registered");
        }

        Certificado certificate = new Certificado();
        certificate.setCertificado(fileBytes);
        certificate.setRequisicao(requisicao);
        certificate.setStatusCertificado(CertificadoStatusEnum.RASCUNHO);

        Certificado certificateSaved = repository.save(certificate);
        return certificateSaved.getId();
    }

    public void updateCertificate(Long certificateId, CertificadoDTO certificateDto, String email)
            throws AcsExcecao, ParseException {
        Certificado certificado = findCertificateById(certificateId);
        if (!certificado.getRequisicao().getUsuario().getEmail().equals(email)) {
            throw new AcsExcecao("Certificate not found");
        }
        Atividade atividade = null;
        if (certificateDto.getAtividadeId() != 0) {
            atividade = activityService.findActivityById(certificateDto.getAtividadeId());
        }

        certificado.setTitulo(certificateDto.getTitulo());
        certificado.setAtividade(atividade);

        if (certificateDto.getDataIncial() != null) {
            certificado.setDataInicial(convertDate(certificateDto.getDataIncial()));
        }

        if (certificateDto.getDataFinal() != null) {
            certificado.setDataFinal(convertDate(certificateDto.getDataFinal()));
        }

        certificado.setCargaHoraria((certificateDto.getQuantidadeDeHoras()));
        repository.save(certificado);
    }

    public void deleteCertificate(Long certificateId, String email) throws AcsExcecao {
        Certificado certificate = findCertificateById(certificateId);
        if (!certificate.getRequisicao().getUsuario().getEmail().equals(email)) {
            throw new AcsExcecao("User unauthorized to delete this certificate");
        }

        if (!certificate.getStatusCertificado().equals(CertificadoStatusEnum.RASCUNHO)) {
            throw new AcsExcecao("A certificate already submitted cannot be deleted");
        }

        repository.deleteById(certificateId);
    }

    private Date convertDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(dateString);
    }

    private boolean isCertificateUnique(Requisicao requisicao, byte[] bytes) {
        return requisicao.getCertificados().stream()
                .anyMatch(certificado -> Arrays.equals(certificado.getCertificado(), bytes));
    }
}
