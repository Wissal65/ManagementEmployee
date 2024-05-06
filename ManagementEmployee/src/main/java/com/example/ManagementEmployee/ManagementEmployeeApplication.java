package com.example.ManagementEmployee;

import com.example.ManagementEmployee.model.User;
import com.example.ManagementEmployee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ManagementEmployeeApplication /*implements CommandLineRunner */{
	/*private final UserService userService;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public ManagementEmployeeApplication(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(ManagementEmployeeApplication.class, args);
	}

	/*
	public void run(String... args) throws Exception {
		// Create a new user with username "admin" and password "adminPassword"
		String username = "wissal";
		String password = "wissalbara";

		// Encode the password before saving it to the database
		String encodedPassword = passwordEncoder.encode(password);

		// Create a new User instance
		User user = new User(username, encodedPassword);

		// Save the user to the database
		userService.saveUser(user);

		System.out.println("User added successfully!");
	}*/
}
