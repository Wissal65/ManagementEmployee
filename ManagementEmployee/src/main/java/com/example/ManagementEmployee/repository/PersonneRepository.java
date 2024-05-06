package com.example.ManagementEmployee.repository;

import com.example.ManagementEmployee.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    @Query("SELECT AVG(p.age) FROM Personne p")
    double getAverageAge();

    @Query("SELECT AVG(p.initialSalaire + p.prime) FROM Personne p")
    double getAverageSalary();
    @Query("SELECT COUNT(p) FROM Personne p WHERE p.typePersonne = 'Employee'")
    int countEmployees();

    @Query("SELECT COUNT(p) FROM Personne p WHERE p.typePersonne = 'Manager'")
    int countManagers();
}