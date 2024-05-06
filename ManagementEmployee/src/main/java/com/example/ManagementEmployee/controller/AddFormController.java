package com.example.ManagementEmployee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddFormController {
    @GetMapping("/addForm")
    public String dashboard(Model model) {
        model.addAttribute("pageTitle", "Add Form");
        return "addForm"; // Renvoie le nom du fichier HTML (sans extension)
    }
}
