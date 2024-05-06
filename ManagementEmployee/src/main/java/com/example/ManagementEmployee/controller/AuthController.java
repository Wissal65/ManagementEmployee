package com.example.ManagementEmployee.controller;



import com.example.ManagementEmployee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("pageTitle", "Login");
        return "index"; // Assuming your login page is named "login.html" or "login.jsp"
    }

    @PostMapping("/login")
    public String processLoginForm(LoginRequest loginRequest, RedirectAttributes redirectAttributes) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Check if the username and password are valid
        if (userService.authenticate(username, password)) {
            // If authentication succeeds, redirect to the dashboard page
            return "redirect:/dashboard";
        } else {
            // If authentication fails, add an error attribute and redirect back to the login page
            redirectAttributes.addFlashAttribute("error", "Authentication failed!");
            return "redirect:/login";
        }
    }
    static class LoginRequest {
        private String username;
        private String password;

        // Getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
