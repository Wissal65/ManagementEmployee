package com.example.ManagementEmployee.model;

import jakarta.persistence.*;

@Entity
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private int age;
    private String adresse;
    private String adresseMail;
    private double initialSalaire;
    private double prime;
    private double salaireFinal;
    private String typePersonne;


    public Personne() {
        // Default constructor required by JPA
    }

    public Personne(String nom, String prenom, int age, String adresse, String adresseMail, double initialSalaire, double prime,String typePersonne) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.adresseMail = adresseMail;
        this.initialSalaire = initialSalaire;
        this.prime = prime;
        this.salaireFinal = initialSalaire + prime; // Initial calculation
        this.typePersonne=typePersonne;
    }

    // Getters and setters

    // Méthode pour calculer automatiquement le salaire final avant l'insertion dans la base de données
    @PrePersist
    public void calculateFinalSalaire() {
        this.salaireFinal = this.initialSalaire + this.prime;
    }

    // Méthode pour recalculer automatiquement le salaire final avant chaque mise à jour dans la base de données
    @PreUpdate
    public void recalculateFinalSalaire() {
        this.salaireFinal = this.initialSalaire + this.prime;
    }

    // Override de la méthode toString() pour faciliter l'affichage
    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", adresse='" + adresse + '\'' +
                ", adresseMail='" + adresseMail + '\'' +
                ", initialSalaire=" + initialSalaire +
                ", prime=" + prime +
                ", salaireFinal=" + salaireFinal +
                '}';
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public double getInitialSalaire() {
        return initialSalaire;
    }

    public void setInitialSalaire(double initialSalaire) {
        this.initialSalaire = initialSalaire;
    }

    public double getPrime() {
        return prime;
    }

    public void setPrime(double prime) {
        this.prime = prime;
    }

    public double getSalaireFinal() {
        return salaireFinal;
    }

    public void setSalaireFinal(double salaireFinal) {
        this.salaireFinal = salaireFinal;
    }

    public String getTypePersonne() {
        return typePersonne;
    }

    public void setTypePersonne(String typePersonne) {
        this.typePersonne = typePersonne;
    }
}
