package br.upe.acs.controller.responses;

import br.upe.acs.model.Course;
import lombok.Getter;

@Getter
public class CourseResponse {

	private final Long id;

	private final String name;

	public CourseResponse(Course course) {
		super();
		this.id = course.getId();
		this.name = course.getName();
	}
}
