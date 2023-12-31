package com.ironhack.finalprojectdigitalproduct.service.interfaces;

import com.ironhack.finalprojectdigitalproduct.model.user.Role;
import com.ironhack.finalprojectdigitalproduct.model.user.User;

import java.util.List;

public interface UserServiceInterface {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}