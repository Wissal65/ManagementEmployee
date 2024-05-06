package com.example.ManagementEmployee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModifyFormController {
    @GetMapping("/modifyForm")
    public String dashboard(Model model) {
        model.addAttribute("pageTitle", "Modify Form");
        return "modifyForm"; // Renvoie le nom du fichier HTML (sans extension)
    }
}
