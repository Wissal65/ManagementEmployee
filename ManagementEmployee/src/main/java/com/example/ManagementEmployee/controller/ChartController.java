package com.example.ManagementEmployee.controller;

import com.example.ManagementEmployee.model.Personne;
import com.example.ManagementEmployee.repository.PersonneRepository;
import com.example.ManagementEmployee.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chart")
public class ChartController {

        @Autowired
        private PersonneService personneService;
        private PersonneRepository personneRepository;

        // This endpoint returns JSON data for consumption by your frontend JavaScript
        @GetMapping("/personnesdata")
        public List<Personne> getPersonnesData() {
            return personneService.getAllPersonnes();
}
}
