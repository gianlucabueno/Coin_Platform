package com.system.platform.dtos;

import com.system.platform.entities.Course;

import java.io.Serial;
import java.io.Serializable;

public class CourseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String description;

    public CourseDTO(){

    }

    public CourseDTO(Course obj) {
        id = obj.getId();
        name = obj.getName();
        description = obj.getDescription();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
