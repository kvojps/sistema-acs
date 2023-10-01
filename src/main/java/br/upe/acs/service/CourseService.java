package br.upe.acs.service;

import java.util.List;
import java.util.Map;

import br.upe.acs.controller.responses.CourseResponse;
import org.springframework.stereotype.Service;

import br.upe.acs.model.Course;
import br.upe.acs.repository.CourseRepository;
import br.upe.acs.utils.exceptions.AcsException;
import lombok.RequiredArgsConstructor;

import static br.upe.acs.utils.PaginationUtils.generatePagination;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;

    public Map<String, Object> listCourses(int page, int amount) {
        List<CourseResponse> courses = repository.findAll().stream().map(CourseResponse::new).toList();
        return generatePagination(courses, page, amount);
    }

    public Course findCourseById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new AcsException("There is no course associated with this id"));
    }
}
