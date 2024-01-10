package com.juliomesquita.core.infra.repository;

import com.juliomesquita.core.domain.model.entities.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}
