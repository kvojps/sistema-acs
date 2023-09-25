package br.upe.acs.utils;

import br.upe.acs.model.Requisicao;
import br.upe.acs.model.enums.RequisicaoStatusEnum;
import br.upe.acs.utils.exceptions.AcsException;
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
