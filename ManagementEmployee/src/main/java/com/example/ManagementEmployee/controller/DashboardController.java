package com.example.ManagementEmployee.controller;

import com.example.ManagementEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @Autowired
    private  EmployeeService employeeService;

//    @GetMapping("/dashboard")
//    public String dashboard(Model model) {
//        model.addAttribute("pageTitle", "Dashboard");
//        return "dashboard"; // Renvoie le nom du fichier HTML (sans extension)
//    }
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("pageTitle", "Dashboard");
        // Assuming you have a service that fetches the required data
        int totalEmployeeCount = employeeService.getTotalEmployeeCount();
        double averageEmployeeAge = employeeService.getAverageEmployeeAge();
        double averageSalary = employeeService.getAverageSalary();
        int regularEmployeeCount = employeeService.getRegularEmployeeCount();
        int managerCount = employeeService.getManagerCount();

        // Adding the data to the model for rendering in Thymeleaf
        model.addAttribute("totalEmployeeCount", totalEmployeeCount);
        model.addAttribute("averageEmployeeAge", averageEmployeeAge);
        model.addAttribute("averageSalary", averageSalary);
        model.addAttribute("regularEmployeeCount", regularEmployeeCount);
        model.addAttribute("managerCount", managerCount);

        return "dashboard";
    }

}
