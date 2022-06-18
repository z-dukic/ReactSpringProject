package com.project.Springbootbackend.controller;


import com.project.Springbootbackend.exception.ResourceNotFoundException;
import com.project.Springbootbackend.model.Employee;
import com.project.Springbootbackend.repository.EmployeeRepository;
import com.project.Springbootbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000") // You get an error bcs of CORS, you have to add localhost here
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    //Dep. injection
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    //Redirect to new url
    @RequestMapping("/to-be-redirected")
    public RedirectView localRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://www.google.com");
        return redirectView;
    }

    //Security
    @GetMapping("/security")
    public String home(Model model, HttpServletRequest request) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("isManager", request.isUserInRole("ROLE_MANAGER"));
        model.addAttribute("newEmployee", new Employee());
        return "Hello world";
    }


    //Pronađi sve preko querya
    @GetMapping("/employees/test")
    public ResponseEntity<List<Employee>> findAllTesting() {
        return ResponseEntity.ok().body(employeeRepository.findAllTesting());
    }


    //To do da možeš dobiti više ljudi s jednim imenom
    //Problem je što vraća samo unique. Ako postoje dva marka onda će biti status 500
    //http://localhost:8080/api/v1/employees/email?email=marko
    // get employee by mail

    //vrati više usera odjednom
    @GetMapping("/employees/email1")
    public ResponseEntity<List<Employee>> findAllByEmail(@RequestParam String email) {
        return ResponseEntity.ok().body(employeeRepository.findAllByEmail(email));
    }


    //vrati jednog usera, ako ima više, error
    @GetMapping("/employees/email")
    public ResponseEntity<Employee>findByEmail(@RequestParam String email) {
        return new ResponseEntity<Employee>(employeeRepository.findByEmail(email), HttpStatus.OK);
    }


    //RequestMapping je za metode, a GetMapping je za metode
    //RequestMapping nema provjeravanja SQL-a, samo metode
    //http://localhost:8080/api/v1/employeez
    //Vrati JSON s tim podacima getAllEmp metoda (van SQLa)
    @RequestMapping("/employeez")
    public List<Employee> getAllEmp() {
        return employeeService.getAllEmp();
    }

    //all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    //json za post request
    /*         {
        "id": 5,
        "firstName": "pero",
        "lastName": "pero",
        "email": "pero"
        }

     */

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


