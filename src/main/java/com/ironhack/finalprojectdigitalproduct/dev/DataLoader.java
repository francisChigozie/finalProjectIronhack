package com.ironhack.finalprojectdigitalproduct.dev;

import com.ironhack.finalprojectdigitalproduct.model.user.Role;
import com.ironhack.finalprojectdigitalproduct.model.user.User;
import com.ironhack.finalprojectdigitalproduct.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
@RequiredArgsConstructor
@Profile("dev")
public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {
    private final UserServiceImpl userService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        userService.saveRole(new Role("ROLE_USER"));
        userService.saveRole(new Role("ROLE_ADMIN"));
        userService.saveRole(new Role("ROLE_MANAGER"));


        userService.saveUser(new User("Mr. Kingsley", "user", "kingsley@gmail.com",
                "12345","10-09-2005","Male","1000", new ArrayList<>()));
        userService.saveUser(new User("Adam Smith", "user2", "adam@yahoo.com",
                "12345","2-03-2003","Male","2000", new ArrayList<>()));
        userService.saveUser(new User("Jane", "admin", "admin@gmail.com",
                "654321","3-11-2014","Female","500", new ArrayList<>()));
        userService.saveUser(new User("John Doe", "manager", "manager@gmail.com",
                "654321","01-10-2005","Male","1000", new ArrayList<>()));

        userService.addRoleToUser("user", "ROLE_USER");
        userService.addRoleToUser("user2", "ROLE_USER");
        userService.addRoleToUser("admin", "ROLE_ADMIN");
        userService.addRoleToUser("manager", "ROLE_MANAGER");
    }
}