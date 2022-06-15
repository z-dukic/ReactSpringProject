package com.project.Springbootbackend.controller;

import com.project.Springbootbackend.exception.ResourceNotFoundException;
import com.project.Springbootbackend.model.People;
import com.project.Springbootbackend.service.PeopleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {

    private PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/name")
    public ResponseEntity<List<People>> findAllByName(@RequestParam String name) {

        return ResponseEntity.ok().body(peopleService.findAllByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<People>> findById(@PathVariable Integer id) {

        People people = peopleService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not exist with id :" + id));

        return ResponseEntity.ok().body(peopleService.findById(id));
    }

}


