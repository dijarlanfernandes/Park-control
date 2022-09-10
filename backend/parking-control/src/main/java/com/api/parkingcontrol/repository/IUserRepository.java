package com.api.parkingcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.parkingcontrol.models.User;

public interface IUserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username); 
}