package br.upe.acs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
