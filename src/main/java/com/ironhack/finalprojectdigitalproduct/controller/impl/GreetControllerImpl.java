package com.ironhack.finalprojectdigitalproduct.controller.impl;

import com.ironhack.finalprojectdigitalproduct.controller.interfaces.GreetControllerInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/greet")
@Slf4j
public class GreetControllerImpl implements GreetControllerInterface {

    @GetMapping
    @Override
    public String greet() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("User {} has role {}", authentication.getName(), authentication.getAuthorities());
        return "Hello, " + authentication.getName() +".You have the role as " +
                authentication.getAuthorities();
    }

    @GetMapping("admin")
    @Override
    public String greetForAdmin() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("User {} has role {}", authentication.getName(), authentication.getAuthorities());
        return "Hello " + authentication.getName() +".Your role is : " +
                authentication.getAuthorities();
    }
}
