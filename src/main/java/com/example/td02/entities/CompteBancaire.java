package com.example.td02.entities;


import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="CompteBancaire")
public class CompteBancaire  implements Serializable {

    int num = 0;
    Client client;
    String compteType;
    double soldeInit;
    double soldeActuel;

    public CompteBancaire( Client client, String compteType, double soldeInit) {

        this.num = this.num ++;
        this.client = client;
        this.compteType = compteType;
        this.soldeInit = soldeInit;
        this.soldeActuel = soldeInit;
    }
}
