package com.project.Springbootbackend.controller;


import com.project.Springbootbackend.exception.ResourceNotFoundException;
import com.project.Springbootbackend.model.Employee;
import com.project.Springbootbackend.repository.EmployeeRepository;
import com.project.Springbootbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000") // You get an error bcs of CORS, you have to add localhost here
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    //http://localhost:8080/api/v1/employee
    //Vrati JSON s tim podacima
    @RequestMapping("/employee")
    public List<Employee> getAnEmployee(){
        return Arrays.asList(
            new Employee(10, "pero","pero", "pero"),
            new Employee(11, "marko","marko", "marko"),
            new Employee(12, "ivan","ivan", "ivan")
        );
    }

    //RequestMapping je za metode, a GetMapping je za metode

    //To do da možeš dobiti više ljudi s jednim imenom
    //Problem je što vraća samo unique. Ako postoje dva marka onda će biti status 500
    //http://localhost:8080/api/v1/employees/email?email=marko
    // get employee by name
    @GetMapping("/employees/email")
    public ResponseEntity<Employee>findByEmail(@RequestParam String email){
        return new ResponseEntity<Employee> (employeeRepository.findByEmail(email), HttpStatus.OK);

    }

    //all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }


    // get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        return ResponseEntity.ok(employee);
    }


    //put employee by id
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);

    }

    //delete
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}


