package com.project.Springbootbackend.controller;


import com.project.Springbootbackend.model.Employee;
import com.project.Springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // You get an error bcs of CORS, you have to add localhost here
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //(C)RUD
    @PostMapping("/employees")
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

}


