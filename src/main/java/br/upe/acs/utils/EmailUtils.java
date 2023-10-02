package br.upe.acs.utils;

import br.upe.acs.model.Request;
import br.upe.acs.model.User;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EmailUtils {

    public static List<String> EMAILS_TEST = Arrays.asList("elizabeth.robichaud@upe.br", "david.dougherty@upe.br");


    private final JavaMailSender emailSender;

    public void sendVerificationCode(String email, String verificationCode) {
        String to, subject, message;

        subject = "Código de verificação - Sistema ACs UPE";
        to = email;
        message = "Para confirmar seu email no Sistema ACs UPE:\n" +
                        "1 - Realize o login no sistema\n" +
                        "2 - Insira e envie este código na página de verificação do sistema: " + verificationCode;
        sendEmail(to, subject, message);
    }

    public void sendRequestStatusChanged(Request request) {
        String to, subject, message;

        to = request.getUser().getEmail();
        subject = "Modificação na sua requisição " + request.getId() + " - Sistema ACs UPE";
        message = "Gostaríamos de informar que sua requisição " + request.getId()
                + " teve seu status alterado para " + request.getStatus().name() + ".\n" +
                "Para mais informações acesse o Sistema de ACs. " +
                "Em caso de erros entre em contato com o turmaestest@gmail.com.\n" +
                "Atenciosamente,\nCoordenação de " + request.getUser().getCourse() + ".";
        sendEmail(to, subject, message);
    }

    public void sendRequestRecoveryPassword(User user, String token) {
        String to, subject, message;

        to = user.getEmail();
        subject = "Solicitação de recuperação de conta - Sistema ACs UPE";
        message = "Olá, " + user.getFullName() + ", \n" +
                "Nós recebemos um pedido para redefinir a senha do e-mail " + user.getEmail() + ".\n" +
                "Clique no link abaixo para redefinir sua senha:\n" +
                System.getenv("FRONTEND_URL") + "/account/reset/" + token;
        sendEmail(to, subject, message);
    }

    private void sendEmail(String to, String subject, String message) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("lapesupe@gmail.com");
        email.setTo(to);
        email.setText(message);
        email.setSubject(subject);

        if (!EMAILS_TEST.contains(to)) {
            emailSender.send(email);
        }
    }
}
