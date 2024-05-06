package com.example.ManagementEmployee.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public class PersonneDto {
    @NotEmpty(message="The last name is required")
    private String nom;

    @NotEmpty(message="The first name is required")
    private String prenom;

    @Min(value = 0, message = "Age must be greater than or equal to 0")
    private Integer age; // Utilisation de Integer au lieu de int pour permettre la valeur null

    @NotEmpty(message="The address is required")
    private String adresse;

    @NotEmpty(message="The email address is required")
    private String adresseMail;

    @Min(value = 0, message = "Initial salary must be greater than or equal to 0")
    private Double initialSalaire; // Utilisation de Double au lieu de double pour permettre la valeur null

    @Min(value = 0, message = "Prime must be greater than or equal to 0")
    private Double prime; // Utilisation de Double au lieu de double pour permettre la valeur null

    @NotEmpty(message="Type of person is required")
    private String typePersonne;

    // Getters and setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public Double getInitialSalaire() {
        return initialSalaire;
    }

    public void setInitialSalaire(Double initialSalaire) {
        this.initialSalaire = initialSalaire;
    }

    public Double getPrime() {
        return prime;
    }

    public void setPrime(Double prime) {
        this.prime = prime;
    }

    public String getTypePersonne() {
        return typePersonne;
    }

    public void setTypePersonne(String typePersonne) {
        this.typePersonne = typePersonne;
    }
}
