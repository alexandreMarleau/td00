package com.example.td02.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.io.Serializable;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public abstract class User implements Serializable {

    String nom;
    String prenom;
    String telephone;
    String email;
    String sexe;
    Adresse adresse;

    public User(String nom, String prenom, String telephone, String email, String sexe, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.sexe = sexe;
        this.adresse = adresse;
    }
}
