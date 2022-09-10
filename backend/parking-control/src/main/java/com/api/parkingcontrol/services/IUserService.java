package com.api.parkingcontrol.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.parkingcontrol.models.Role;
import com.api.parkingcontrol.models.User;

public interface IUserService {
    User saveUser(User user);
    ResponseEntity<Role> saveRole(Role role);
    void addRoleToUser(String username,String roleName );
    User getUser(String username);
    List<User>getUsers();
}