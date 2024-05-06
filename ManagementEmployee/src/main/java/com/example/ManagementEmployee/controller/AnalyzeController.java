package com.example.ManagementEmployee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class AnalyzeController{

    @GetMapping("/analyze")
    public String dashboard(Model model) {
        model.addAttribute("pageTitle", "Analyze");
        return "analyze"; // Renvoie le nom du fichier HTML (sans extension)
    }
}
