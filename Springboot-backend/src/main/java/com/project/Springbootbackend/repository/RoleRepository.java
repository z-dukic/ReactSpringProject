package com.project.Springbootbackend.repository;

import com.project.Springbootbackend.model.Employee;
import com.project.Springbootbackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
