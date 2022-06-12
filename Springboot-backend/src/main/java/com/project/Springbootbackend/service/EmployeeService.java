package com.project.Springbootbackend.service;

import com.project.Springbootbackend.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    //Service se koristi za DI. Ako staviš direkt onda svaki put kad se pokrene radi novu listu, ovako dobije samo instancu.
    private List<Employee> emp = new ArrayList<>( Arrays.asList(
        new Employee(10, "pero", "pero", "pero"),
        new Employee(11, "marko", "marko", "marko"),
        new Employee(12, "ivan", "ivan", "ivan")
    ));

    public List<Employee> getAllEmp() {
        return emp;
    }

}
