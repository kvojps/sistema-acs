package br.upe.acs.servico;

import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import br.upe.acs.exceptions.AcsException;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class RequestPdfService {

    private final ReadRequestsUseCase service;
    private final ITemplateEngine templateEngine;

    public RequestPdfService(ReadRequestsUseCase readRequestsUseCase, TemplateEngine templateEngine) {
        this.service = readRequestsUseCase;
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateEngine.setTemplateResolver(templateResolver);
        this.templateEngine = templateEngine;
    }

    //TODO: Especializar exceção
    public byte[] generateRequestPdf(Long id) {
        Requisicao requisicao = service.findRequestById(id);

        if (requisicao.getStatusRequisicao() != RequisicaoStatusEnum.TRANSITO) {
            throw new AcsException("It is not possible to generate a PDF of a request that is not in transit");
        }

        Context context = defineTemplateValuesHtml(requisicao);

        String documentHtml = templateEngine.process("requisicao.html", context);
        Path pathDoPdf = Paths.get("src/main/resources/requisicao" + id + ".pdf");

        try (FileOutputStream outputStream = new FileOutputStream("src/main/resources/requisicao" + id + ".pdf")) {
            ITextRenderer renderer = new ITextRenderer();
            SharedContext sharedContext = renderer.getSharedContext();
            sharedContext.setPrint(true);
            sharedContext.setInteractive(false);
            renderer.setDocumentFromString(documentHtml);
            renderer.layout();
            renderer.createPDF(outputStream);
            outputStream.close();

            byte[] filePdf = Files.readAllBytes(pathDoPdf);
            Files.delete(pathDoPdf);
            return filePdf;

        } catch (Exception e) {
            throw new AcsException("Error generating pdf file");
        }

    }

    private Context defineTemplateValuesHtml(Requisicao requisicao) {
        Context context = new Context();

        context.setVariable("protocolo", requisicao.getToken());
        context.setVariable("cpf", requisicao.getUsuario().getCpf());
        context.setVariable("data", requisicao.getDataDeSubmissao().toString());
        context.setVariable("nome", requisicao.getUsuario().getNomeCompleto());
        context.setVariable("curso", requisicao.getUsuario().getCurso().getNome());
        context.setVariable("periodo", requisicao.getUsuario().getPeriodo());
        context.setVariable("rua", requisicao.getUsuario().getEndereco().getRua());
        context.setVariable("bairro", requisicao.getUsuario().getEndereco().getBairro());
        context.setVariable("numero", requisicao.getUsuario().getEndereco().getNumero());
        context.setVariable("cidade", requisicao.getUsuario().getEndereco().getCidade());
        context.setVariable("uf", requisicao.getUsuario().getEndereco().getUF());
        context.setVariable("cep", requisicao.getUsuario().getEndereco().getCep());
        context.setVariable("email", requisicao.getUsuario().getEmail());
        context.setVariable("telefone", requisicao.getUsuario().getTelefone());

        return context;
    }
}
