package br.upe.acs.model;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.upe.acs.model.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fullName;
	
	private String cpf;
	
	private String enrollment;
	
	private int period;
	
	private String phone;
	
	private String email;
	
	private String password;
	
	private String verificationCode;
	
	private boolean verified;
	
    private float hoursEnsino;

    private float hoursExtensao;

    private float hoursGestao;

    private float hoursPesquisa;

	private boolean enabled;

	@Enumerated(EnumType.STRING)
    private RoleEnum role;
    
    @OneToMany(mappedBy = "user")
    private List<Request> requests;
    
    @ManyToOne
    private Address address;
    
	@ManyToOne
	private Course course;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
}
