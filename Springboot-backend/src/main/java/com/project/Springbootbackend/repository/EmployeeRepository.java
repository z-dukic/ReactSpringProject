package com.project.Springbootbackend.repository;

import com.project.Springbootbackend.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email); //ako ima dva marka, error 500

    List<Employee> findAllByEmail(String email); //pronađe sve emailove

    //native query
    @Query(value = "SELECT * FROM employees ", nativeQuery = true)
    List<Employee> findAllTesting();

}
