package com.api.parkingcontrol.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.Role;
import com.api.parkingcontrol.models.User;
import com.api.parkingcontrol.repository.IRoleRepository;
import com.api.parkingcontrol.repository.IUserRepository;

@Service
@Transactional
public class UserServiceImp implements IUserService{

    
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;

public UserServiceImp(IUserRepository userRepository,
                         IRoleRepository roleRepositor){
        this.userRepository = userRepository;
        this.roleRepository = roleRepositor;
    }

    @Override
    public User saveUser(User user) {        
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
       User user = userRepository.findByUsername(username);
       Role role = roleRepository.findByname(roleName);
       
       user.getRoles().add(role);  
        
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    
}