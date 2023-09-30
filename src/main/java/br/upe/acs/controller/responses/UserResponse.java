package br.upe.acs.controller.responses;

import br.upe.acs.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Getter
public class UserResponse {

	private final Long id;

	private final String fullName;

	private final String enrollment;

	private final String telephone;

	private final String email;

	private final List<String> role;

	private final CourseResponse course;

	private final int period;

	private final boolean verified;

	public UserResponse(User user) {
		this.id = user.getId();
		this.fullName = user.getFullName();
		this.enrollment = user.getEnrollment();
		this.telephone = user.getTelephone();
		this.email = user.getEmail();
		this.role = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
		this.course = new CourseResponse(user.getCourse());
		this.period = user.getPeriod();
		this.verified = user.isVerified();
	}
}
