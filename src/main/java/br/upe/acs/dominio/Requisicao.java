package br.upe.acs.dominio;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Requisicao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date data;

	private int semestre;

	private int qtdCertificados;

	private String token;

	private byte[] requisicaoArquivo;

	@ManyToOne
	private Usuario usuario;

	@ManyToOne
	private Curso curso;

	@OneToMany(mappedBy = "requisicao")
	private List<Certificado> certificados;

	public Long getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getQtdCertificados() {
		return qtdCertificados;
	}

	public void setQtdCertificados(int qtdCertificados) {
		this.qtdCertificados = qtdCertificados;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<Certificado> getCertificados() {
		return certificados;
	}

	public void setCertificados(List<Certificado> certificados) {
		this.certificados = certificados;
	}

	public byte[] getRequisicaoArquivo() {
		return requisicaoArquivo;
	}

	public void setRequisicaoArquivo(byte[] requisicaoArquivo) {
		this.requisicaoArquivo = requisicaoArquivo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}