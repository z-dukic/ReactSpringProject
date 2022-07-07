package com.project.Springbootbackend.controller;

import com.project.Springbootbackend.exception.ResourceNotFoundException;
import com.project.Springbootbackend.model.People;
import com.project.Springbootbackend.service.PeopleService;
import com.project.Springbootbackend.service.PeopleServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {

    private PeopleServiceImp people;

    public PeopleController(PeopleServiceImp people) {
        this.people = people;
    }

    @GetMapping("/name")
    public ResponseEntity<List<People>> findAllByName(@RequestParam String name) {

        return ResponseEntity.ok().body(people.findAllByName(name));
    }

    /* To-do next
        @GetMapping("/{id}")
    public ResponseEntity<Optional<People>> findById(@PathVariable Integer id) {

        People people = peopleService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not exist with id :" + id));

        return ResponseEntity.ok().body(peopleService.findById(id));
    }

     */



}


