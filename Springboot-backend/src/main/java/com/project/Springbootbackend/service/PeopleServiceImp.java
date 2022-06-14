package com.project.Springbootbackend.service;

import com.project.Springbootbackend.model.People;
import com.project.Springbootbackend.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PeopleServiceImp implements PeopleService {

    private PeopleRepository peopleRepository;

    public PeopleServiceImp(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public List<People> findAllByName(String name) {
        List<People> people = peopleRepository.findAllByName(name);
        return people;
    }

    @Override
    public Optional<People> findById(Integer id) {
        return peopleRepository.findById(id);
    }


}


/*
    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = productRepository.searchProductsSQL(query);
        return products;
    }

 */
