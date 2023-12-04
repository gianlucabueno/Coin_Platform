package com.system.platform.controllers;

import com.system.platform.dtos.CourseDTO;
import com.system.platform.entities.Course;
import com.system.platform.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll(){
        List<Course> list = service.findAll();
        List<CourseDTO> listDto = list.stream().map(x -> new CourseDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable String id) {
        Course obj = service.findById(id);
        return ResponseEntity.ok().body(new CourseDTO(obj));

    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CourseDTO objDto) {
        Course obj = service.fromCourseDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody CourseDTO objDto, @PathVariable String id) {
        Course obj = service.fromCourseDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }


}
