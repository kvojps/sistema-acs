package br.upe.acs.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.upe.acs.dominio.enums.PerfilEnum;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends Usuario {

    private int periodo;

    private String matricula;

    private String codigoVerificacao;

    private boolean verificado;

    @OneToMany(mappedBy = "aluno")
    private List<Requisicao> requisicoes;

    @ManyToOne
    private Endereco endereco; 
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(PerfilEnum.USUARIO.name()));
	}
}
