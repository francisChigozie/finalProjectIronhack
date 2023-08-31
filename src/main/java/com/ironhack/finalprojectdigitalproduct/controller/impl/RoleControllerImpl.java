package com.ironhack.finalprojectdigitalproduct.controller.impl;

import com.ironhack.finalprojectdigitalproduct.controller.interfaces.RoleControllerInterface;
import com.ironhack.finalprojectdigitalproduct.dto.onlyDto.RoleToUserDTO;
import com.ironhack.finalprojectdigitalproduct.model.user.Role;
import com.ironhack.finalprojectdigitalproduct.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * RESTful API for Role management
 */
@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleControllerImpl implements RoleControllerInterface {
    private final UserServiceImpl userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRole(@RequestBody Role role) {
        userService.saveRole(role);
    }

    @PostMapping("addtouser")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRoleToUser(@RequestBody RoleToUserDTO roleToUserDTO) {
        userService.addRoleToUser(roleToUserDTO.getUsername(), roleToUserDTO.getRoleName());
    }

}