package com.example.ManagementEmployee.service;

import com.example.ManagementEmployee.model.*;
import com.example.ManagementEmployee.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {
    @Autowired
    private PersonneRepository personneRepository;


    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }


    public Personne getPersonneById(long id) {
        return personneRepository.findById(id).orElse(null);
    }


    public Personne addPersonne(Personne personne) {
        return personneRepository.save(personne);
    }


    public Personne updatePersonne(long id, Personne personne) {
        if (personneRepository.existsById(id)) {
            personne.setId(id);
            return personneRepository.save(personne);
        }
        return null;
    }


    public void deletePersonne(long id) {
        personneRepository.deleteById(id);
    }
}