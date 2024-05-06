package com.example.ManagementEmployee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import javax.servlet.http.HttpServletRequest;


@Controller
public class PageController {

    @GetMapping("/{page}")
    public String page(@PathVariable String page, Model model) {
        String pageTitle = getPageTitle(page);
        model.addAttribute("pageTitle", pageTitle);
        return page; // Le nom de la vue Thymeleaf correspondant à la page
    }

    private String getPageTitle(String page) {
        // Transformation du nom de la page en un titre approprié
        switch (page) {
            case "dashboard":
                return "Tableau de bord";
            case "crud":
                return "Gestion des employes";
            case "addForm":
                return "Formulaire d'ajout";
            case "modifyForm":
                return "Formulaire de modification";
            case "analyze":
                return "Analyse";
            case "setting":
                return "Paramètres";
            default:
                return "Page inconnue";
        }
    }
}
