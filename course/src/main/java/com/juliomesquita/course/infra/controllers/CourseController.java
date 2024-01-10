package com.juliomesquita.course.infra.controllers;

import com.juliomesquita.core.domain.model.entities.Course;
import com.juliomesquita.course.app.services.CourseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/admin/couse")
@RequiredArgsConstructor
@Slf4j
public class CourseController {
    private final CourseService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Course>> listAll(Pageable pageable){
        return ResponseEntity.ok(this.service.list(pageable));
    }
}
