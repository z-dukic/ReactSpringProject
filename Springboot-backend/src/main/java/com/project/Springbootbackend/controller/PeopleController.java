package com.project.Springbootbackend.controller;

import com.project.Springbootbackend.model.People;
import com.project.Springbootbackend.service.PeopleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}
