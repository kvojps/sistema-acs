package br.upe.acs.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.upe.acs.controlador.respostas.CertificadoResposta;
import br.upe.acs.servico.CertificadoServico;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/certificado")
@RequiredArgsConstructor
@CrossOrigin
public class CertificadoControlador {
	
	private final CertificadoServico servico;

	@GetMapping("/{id}")
	public ResponseEntity<CertificadoResposta> buscarCertificadoPorId(@PathVariable("id") Long id) throws AcsExcecao {
		CertificadoResposta certificadoResposta = new CertificadoResposta(servico.buscarCertificadoPorId(id).get());

		return ResponseEntity.ok(certificadoResposta);
	}
}
