package br.upe.acs.servico;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.dto.CertificadoDTO;
import br.upe.acs.repositorio.CertificadoRepositorio;

@Service
public class CertificadoServico {

	@Autowired
	private CertificadoRepositorio repositorio;

	public Certificado adicionarCertificado(CertificadoDTO certificado, MultipartFile file) throws IOException {

		byte[] certificadoArquivo = file.getBytes();
		
		Certificado certificadoSalvar = new Certificado();
		certificadoSalvar.setDescricao(certificado.getDescricao());
		certificadoSalvar.setData(null);
		certificadoSalvar.setSemestre(certificado.getSemestre());
		certificadoSalvar.setHoras(certificado.getHoras());
		certificadoSalvar.setChMaxima(certificado.getChMaxima());
		certificadoSalvar.setChTotal(certificado.getChTotal());
		certificadoSalvar.setCertificado(certificadoArquivo);
		certificadoSalvar.setProtocolo(null);
		certificadoSalvar.setAtividade(null);

		return repositorio.save(certificadoSalvar);
	}

}
