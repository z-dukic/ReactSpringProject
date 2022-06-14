package com.project.Springbootbackend.service;

import com.project.Springbootbackend.model.People;
import com.project.Springbootbackend.repository.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PeopleServiceImp implements PeopleService {

    PeopleRepository peopleRepository;

    @Override
    public List findAllByName(String name) {
        return (List) ResponseEntity.ok(peopleRepository.findAllByName(name));
    }

}
