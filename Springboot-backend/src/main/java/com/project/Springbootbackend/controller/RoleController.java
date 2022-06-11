package com.project.Springbootbackend.controller;


import com.project.Springbootbackend.model.Employee;
import com.project.Springbootbackend.model.Role;
import com.project.Springbootbackend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // You get an error bcs of CORS, you have to add localhost here
@RestController
@RequestMapping("/api/v2/")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    //all roles
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }



}
