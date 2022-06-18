package com.project.Springbootbackend.util;

import com.project.Springbootbackend.model.Employee;
import com.project.Springbootbackend.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    //Loads data every single time.
    //data loader for spring security
    /*


    @Bean
    CommandLineRunner loadData(EmployeeRepository repository) {
        return args -> {
            repository.save(new Employee(90, "Frodo Baggins", "ring bearer", "pero"));
            repository.save(new Employee(91, "Bilbo Baggins", "burglar", "pero"));
            repository.save(new Employee(92, "Samwise Gamgee", "gardener", "pero"));
            repository.save(new Employee(93, "Merry Bandibuck", "firework lighter", "pero"));
            repository.save(new Employee(94, "Gandalf the Grey", "wizard", "pero"));

        };
    }
    */
}
