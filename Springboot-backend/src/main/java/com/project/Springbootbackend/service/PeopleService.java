package com.project.Springbootbackend.service;

import com.project.Springbootbackend.model.People;

import java.util.List;
import java.util.Optional;

public interface PeopleService {
    List<People> findAllByName(String name);

}

