package com.project.Springbootbackend.controller;

import com.project.Springbootbackend.exception.ResourceNotFoundException;
import com.project.Springbootbackend.model.Employee;
import com.project.Springbootbackend.model.People;
import com.project.Springbootbackend.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@RequiredArgsConstructor
public class PeopleController {

    private PeopleService peopleService;

    @GetMapping("/name")
    public ResponseEntity<List<People>> findAllByName(@RequestParam String name) {

        return ResponseEntity.ok().body(peopleService.findAllByName(name));
    }




}
