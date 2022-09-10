package com.api.parkingcontrol.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.parkingcontrol.models.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {
   Role findByname(String name);
}