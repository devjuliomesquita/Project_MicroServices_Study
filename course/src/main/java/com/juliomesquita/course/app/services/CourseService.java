package com.juliomesquita.course.app.services;


import com.juliomesquita.core.domain.model.entities.Course;
import com.juliomesquita.core.infra.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@Slf4j
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public Iterable<Course> list (Pageable pageable){
        log.info("Listar todos os cursos.");
        return this.courseRepository.findAll(pageable);
    }

}
