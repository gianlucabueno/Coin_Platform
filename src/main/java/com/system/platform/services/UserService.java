package com.system.platform.services;

import com.system.platform.entities.Account;
import com.system.platform.entities.User;
import com.system.platform.dtos.UserDTO;
import com.system.platform.entities.UserStatus;
import com.system.platform.repository.UserRepository;
import com.system.platform.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        upData(newObj, obj);
        return repo.save(newObj);
    }

    private void upData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User updatePassword(User obj) {
        User newObj = findById(obj.getId());
        upPassword(newObj, obj);
        return repo.save(newObj);
    }

    private void upPassword(User newObj, User obj) {
        newObj.setPassword(obj.getPassword());
    }

    public User updateStatus(User obj) {
        User newObj = findById(obj.getId());
        upStatus(newObj, obj);
        return repo.save(newObj);
    }

    private void upStatus(User newObj, User obj) {
        if(obj.getStatus() == UserStatus.Premium) {
            newObj.setStatus(obj.getStatus());
            newObj.setCoins(3);
            newObj.setVouchers(1);
        }
    }

    public User fromUserDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail(), objDto.getPassword(),objDto.getStatus(),objDto.getAccount(),objDto.getCoins(),objDto.getVouchers(),objDto.getTotalCourses());
    }
}
