package com.example.ManagementEmployee.controller;

import com.example.ManagementEmployee.model.Personne;
import com.example.ManagementEmployee.model.PersonneDto;
import com.example.ManagementEmployee.repository.PersonneRepository;
import com.example.ManagementEmployee.service.PersonneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/personnes")
public class PersonneController {
    @Autowired
    private PersonneService personneService;
    private PersonneRepository personneRepository;

    @GetMapping({"","/"})
    public String getPersonnes(Model model) {
        List<Personne> personnes = personneService.getAllPersonnes();
        model.addAttribute("pageTitle", "Gestion Employees");
        model.addAttribute("personnes", personnes);
        return "crud"; // renvoie au fichier HTML à afficher
    }
    @GetMapping("/create")
    public String addPersonne(Model model) {
        PersonneDto personneDto=new PersonneDto();
        model.addAttribute("personneDto", personneDto);
        return "addForm"; // renvoie au fichier HTML à afficher
    }
    @PostMapping("/create")
    public String addPersonneForm(
        @Valid @ModelAttribute PersonneDto personneDto,
                BindingResult result,
        RedirectAttributes redirectAttributes
        ){
       if(result.hasErrors()) {
           return "addForm";
       }
       Personne personne=new Personne();
       personne.setNom(personneDto.getNom());
       personne.setPrenom(personneDto.getPrenom());
       personne.setAge(personneDto.getAge());
       personne.setAdresse(personneDto.getAdresse());
       personne.setAdresseMail(personneDto.getAdresseMail());
       personne.setTypePersonne(personneDto.getTypePersonne());
       personne.setInitialSalaire(personneDto.getInitialSalaire());
       personne.setPrime(personneDto.getPrime());
       personne.calculateFinalSalaire();

       personneService.addPersonne(personne);

//        return "redirect:/personnes"; // renvoie au fichier HTML à afficher
        return "redirect:/personnes?successMessage=New Personne created successfully";


    }
    @GetMapping("/edit")
    public String showEditPage(Model model, @RequestParam int id){

        try {
 Personne personne=personneService.getPersonneById(id);
 model.addAttribute("personne",personne);
 PersonneDto personneDto=new PersonneDto();
 personneDto.setNom(personne.getNom());
 personneDto.setPrenom(personne.getPrenom());
 personneDto.setAge(personne.getAge());
 personneDto.setAdresse(personne.getAdresse());
 personneDto.setAdresseMail(personne.getAdresseMail());
 personneDto.setTypePersonne(personne.getTypePersonne());
 personneDto.setInitialSalaire(personne.getInitialSalaire());
 personneDto.setPrime(personne.getPrime());
// personne.recalculateFinalSalaire();
 model.addAttribute("personneDto",personneDto);

        } catch (Exception e) {
            System.out.println("Exception: "+ e.getMessage());
           return "redirect:/personnes";
        }
        return  "modifyForm";
    }

    @PostMapping("/edit")
    public String updatePersonne(Model model, @RequestParam int id, @Valid @ModelAttribute PersonneDto personneDto, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return "modifyForm";
            }
            Personne personne = personneService.getPersonneById(id);
            personne.setNom(personneDto.getNom());
            personne.setPrenom(personneDto.getPrenom());
            personne.setAge(personneDto.getAge());
            personne.setAdresse(personneDto.getAdresse());
            personne.setAdresseMail(personneDto.getAdresseMail());
            personne.setTypePersonne(personneDto.getTypePersonne());
            personne.setInitialSalaire(personneDto.getInitialSalaire());
            personne.setPrime(personneDto.getPrime());
            personne.recalculateFinalSalaire();

//            personneRepository.save(personne);
            personneService.updatePersonne(id,personne);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
//        return "redirect:/personnes";
        return "redirect:/personnes?successMessage=Personne has been modified successfully";

    }




    @GetMapping("/delete")
    public String deletePersonne(@RequestParam long id) {
        try {
            Personne personne=personneService.getPersonneById(id);
           personneRepository.delete(personne);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return "redirect:/personnes?successMessage=Personne has been deleted successfully";
    }


}
