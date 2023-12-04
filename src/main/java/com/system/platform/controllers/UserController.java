package com.system.platform.controllers;

import com.system.platform.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserController {
    @GetMapping
    public List<User> findAll(){
        User maria = new User("1","g","g.com","test");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria));
        return list;
    }
}
