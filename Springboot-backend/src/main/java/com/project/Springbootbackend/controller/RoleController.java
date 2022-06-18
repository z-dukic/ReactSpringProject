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
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    //all roles
    @GetMapping()
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    //get all people with that role
    public List<Role> getPeoplePerRole() {
        return roleRepository.findAll();
    }


    // get employee by id
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nobody in company with that role exist with id :" + id));
        return ResponseEntity.ok(role);
    }

    /*
        http://localhost:8080/api/v1/roles/new

        {
        "id": 4,
        "roleName": "Scrum master",
        "employee": {
            "id": 2
        }
    }

    Problemi:
    Ako staviš id 2, on ga pregazi (ako ga ima u bazi)
    Ako makneš id, on ga ignorira i stavi sve null
    Možeš dodati bilo kojeg usera
     */
    @PostMapping("/new")
    public Role addToRole(@RequestBody Role role){
        return roleRepository.save(role);
    }

}



