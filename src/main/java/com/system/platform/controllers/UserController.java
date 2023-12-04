package com.system.platform.controllers;

import com.system.platform.dtos.UserDTO;
import com.system.platform.entities.User;
import com.system.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));

    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        User obj = service.fromUserDTO(objDto);
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
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
        User obj = service.fromUserDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/password/{id}")
    public ResponseEntity<Void> updatePassword(@RequestBody UserDTO objDto, @PathVariable String id) {
        User obj = service.fromUserDTO(objDto);
        obj.setId(id);
        obj = service.updatePassword(obj);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Void> updateStatus(@RequestBody UserDTO objDto, @PathVariable String id) {
        User obj = service.fromUserDTO(objDto);
        obj.setId(id);
        obj = service.updateStatus(obj);
        return ResponseEntity.noContent().build();
    }
}

