package com.ironhack.finalprojectdigitalproduct.controller.interfaces;

import com.ironhack.finalprojectdigitalproduct.model.user.User;

import java.util.List;

/**
 * Interface for UserController. Contains methods for handling user related operations
 */
public interface CustomerControllerInterface {
    List<User> getUsers();

    User createNewCustomer(User user);
}
