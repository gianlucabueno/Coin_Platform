package com.system.platform.controllers;

import com.system.platform.entities.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/courses")
public class CourseController {
    @GetMapping
    public List<Course> findAll(){
        Course ads = new Course("1","ADS","Programing");
        List<Course> list = new ArrayList<>();
        list.addAll(Arrays.asList(ads));
        return list;
    }
}
