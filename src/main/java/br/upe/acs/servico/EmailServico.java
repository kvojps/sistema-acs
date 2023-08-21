package br.upe.acs.servico;

import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.dto.RegistroDTO;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.upe.acs.dominio.dto.EmailDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServico {
	
	private final JavaMailSender emailRemetente;
	
	public void enviarEmail(EmailDTO emailInfo) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("lapesupe@gmail.com");
		email.setTo(emailInfo.getDestinatario());
		email.setText(emailInfo.getMensagem());
		email.setSubject(emailInfo.getAssunto());
		
		emailRemetente.send(email);
	}

	public void enviarEmailCodigoVerificacao(RegistroDTO registro, String codigoVerificacao) {
		EmailDTO email = new EmailDTO();

		email.setAssunto("Código de verificação - Sistema ACs UPE");
		email.setDestinatario(registro.getEmail());
		email.setMensagem(
				"Confirme seu email, envie esse código na página de verificação do sistema: " + codigoVerificacao);
		enviarEmail(email);
	}

	public void enviarEmailAlteracaoStatusRequisicao(Requisicao requisicao) {
		EmailDTO email = new EmailDTO();
		email.setDestinatario(requisicao.getUsuario().getEmail());
		email.setAssunto("Modificação na Sua requisição " + requisicao.getId() + " - Sistema ACs UPE");
		email.setMensagem("Gostaríamos de informar que sua requisição " + requisicao.getId()
				+ " teve seu status alterando para "  + requisicao.getStatusRequisicao().name() + ".\n" +
				"Para mais informações acesse o Sistema de ACs. " +
				"Em casos de error entre em cantato com o turmaestest@gmail.com.\n" +
				"atenciosamente,\nCoordenação de " + requisicao.getCurso().getNome() + ".");
		enviarEmail(email);
	}
}
