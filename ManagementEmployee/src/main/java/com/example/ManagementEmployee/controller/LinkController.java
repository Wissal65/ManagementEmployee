package com.example.ManagementEmployee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class LinkController {

    @GetMapping("/open-calculator")
    public String openCalculator() {
        try {
            Runtime.getRuntime().exec("calc.exe");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/dashboard"; // Redirige vers la page d'accueil ou une autre page
    }

    @GetMapping("/open-web-browser")
    public String openWebBrowser() {
        // URL de la page à ouvrir dans le navigateur par défaut
        String url = "https://www.google.com";

        // Redirige l'utilisateur vers l'URL
        return "redirect:" + url;
    }

}

