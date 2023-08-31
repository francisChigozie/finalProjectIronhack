package com.ironhack.finalprojectdigitalproduct.controller.interfaces;

import com.ironhack.finalprojectdigitalproduct.dto.onlyDto.RoleToUserDTO;
import com.ironhack.finalprojectdigitalproduct.model.user.Role;

public interface RoleControllerInterface {
    void saveRole(Role role);

    void addRoleToUser(RoleToUserDTO roleToUserDTO);
}
