package com.system.platform.config;

import com.system.platform.entities.Account;
import com.system.platform.entities.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.system.platform.entities.User;
import com.system.platform.entities.Course;
import com.system.platform.repository.UserRepository;
import com.system.platform.repository.CourseRepository;

import java.util.Arrays;


@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        courseRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com","teste12",UserStatus.Standard, Account.Active,0,0,5);
        User paula = new User(null, "Paula Black", "paula@gmail.com","p1545",UserStatus.Standard, Account.Active,0,0,12);
        User alex = new User(null, "Alex Green", "alex@gmail.com","79xela",UserStatus.Standard,Account.Active,0,0,15);
        User bob = new User(null, "Bob Grey", "bob@gmail.com","bob121bob", UserStatus.Premium,  Account.Active,3,1,20);


        Course programacao = new Course(null,"Programação","Programção Basica");
        Course data = new Course(null,"Ciencia de Dados","Ciencia de dados basica");

        courseRepository.saveAll(Arrays.asList(programacao , data));
        userRepository.saveAll(Arrays.asList(maria, alex, bob, paula));
    }

}
