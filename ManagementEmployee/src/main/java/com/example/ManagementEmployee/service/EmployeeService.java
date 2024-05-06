package com.example.ManagementEmployee.service;

// EmployeeService.java
import com.example.ManagementEmployee.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    PersonneRepository personneRepository;

    // Assuming you have a repository or some other data access mechanism to fetch employee data

    public int getTotalEmployeeCount() {
        return (int) personneRepository.count(); // Utiliser la méthode count() pour obtenir le nombre total d'employés
    }

    public double getAverageEmployeeAge() {
        return personneRepository.getAverageAge();
    }

    public double getAverageSalary() {
        return personneRepository.getAverageSalary();
    }

    public int getRegularEmployeeCount() {
        return personneRepository.countEmployees();
    }

    public int getManagerCount() {
        return personneRepository.countManagers();
    }
}

