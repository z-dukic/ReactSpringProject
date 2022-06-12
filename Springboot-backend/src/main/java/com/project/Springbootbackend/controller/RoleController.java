package com.project.Springbootbackend.controller;


import com.project.Springbootbackend.exception.ResourceNotFoundException;
import com.project.Springbootbackend.model.Employee;
import com.project.Springbootbackend.model.Role;
import com.project.Springbootbackend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //get all people with that role
    public List<Role> getPeoplePerRole(){
        return roleRepository.findAll();
    }


    // get employee by id
    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Role role = roleRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Nobody in company with that role exist with id :" + id));
        return ResponseEntity.ok(role);
    }

}
