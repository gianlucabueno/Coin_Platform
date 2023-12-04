package com.system.platform.services;

import com.system.platform.dtos.CourseDTO;
import com.system.platform.entities.Course;
import com.system.platform.repository.CourseRepository;
import com.system.platform.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repo;

    public List<Course> findAll(){
        return repo.findAll();
    }

    public Course findById(String id) {
        Optional<Course> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Course insert(Course obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public Course update(Course obj) {
        Course newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(Course newObj, Course obj) {
        newObj.setName(obj.getName());
        newObj.setDescription(obj.getDescription());
    }

    public Course fromCourseDTO(CourseDTO objDto) {
        return new Course(objDto.getId(), objDto.getName(), objDto.getDescription());
    }
}
