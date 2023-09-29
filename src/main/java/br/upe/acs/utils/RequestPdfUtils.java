package br.upe.acs.utils;

import br.upe.acs.model.Requisicao;
import br.upe.acs.model.enums.RequisicaoStatusEnum;
import br.upe.acs.utils.exceptions.AcsException;
import org.springframework.stereotype.Component;
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

@Component
public class RequestPdfUtils {

    private final ITemplateEngine templateEngine;

    public RequestPdfUtils(TemplateEngine templateEngine) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateEngine.setTemplateResolver(templateResolver);
        this.templateEngine = templateEngine;
    }

    public byte[] generateRequestPdf(Requisicao request) {
        if (request.getStatusRequisicao() != RequisicaoStatusEnum.TRANSITO) {
            throw new AcsException("It is not possible to generate a PDF of a request that is not in transit");
        }

        Context context = defineTemplateValuesHtml(request);

        String documentHtml = templateEngine.process("requisicao.html", context);
        Path pathDoPdf = Paths.get("src/main/resources/requisicao" + request.getId() + ".pdf");

        try (FileOutputStream outputStream = new FileOutputStream("src/main/resources/requisicao" + request.getId() + ".pdf")) {
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

    private Context defineTemplateValuesHtml(Requisicao request) {
        Context context = new Context();

        context.setVariable("protocolo", request.getToken());
        context.setVariable("cpf", request.getUser().getCpf());
        context.setVariable("data", request.getDataDeSubmissao().toString());
        context.setVariable("nome", request.getUser().getFullName());
        context.setVariable("curso", request.getUser().getCourse().getName());
        context.setVariable("periodo", request.getUser().getPeriod());
        context.setVariable("rua", request.getUser().getAddress().getStreet());
        context.setVariable("bairro", request.getUser().getAddress().getDistrict());
        context.setVariable("numero", request.getUser().getAddress().getNumber());
        context.setVariable("cidade", request.getUser().getAddress().getCity());
        context.setVariable("uf", request.getUser().getAddress().getUf());
        context.setVariable("cep", request.getUser().getAddress().getCep());
        context.setVariable("email", request.getUser().getEmail());
        context.setVariable("telefone", request.getUser().getTelephone());

        return context;
    }
}
