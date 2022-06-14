package com.project.Springbootbackend.repository;

import com.project.Springbootbackend.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Integer> {
    List<People> findAllByName(String name);


}
