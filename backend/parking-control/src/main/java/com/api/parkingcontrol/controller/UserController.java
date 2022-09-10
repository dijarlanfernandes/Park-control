package com.api.parkingcontrol.controller;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.api.parkingcontrol.models.Role;
import com.api.parkingcontrol.services.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class UserController {

    private final IUserService iService;

    public UserController(IUserService iService) {
        this.iService = iService;
    }
   @PostMapping(value="/role")
   public ResponseEntity<Role> SaveRole(@RequestBody Role role) {
       
        Optional<Role> role = iService.findAll();
       
       return entity;
   }
   
}
