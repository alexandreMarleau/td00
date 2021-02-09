package com.example.td02.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name="Client")
@DiscriminatorValue("U")
public class Client extends User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int clientId;

    @Column(name="Salaire")
    int salaire;

    @Column(name="StatusMatrimonial")
    String statutMatrimonial;

    @Column(name="Année Naissance")
    int anneeNaissance;

    @Column(name="nip")
    int nip;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<CompteBancaire> comptes = new ArrayList<CompteBancaire>();

    public Client(String nom, String prenom, String telephone, String email, String sexe, Adresse adresse, int clientId, int salaire, String statutMatrimonial, int anneeNaissance, int nip) {
        super(nom, prenom, telephone, email, sexe, adresse);
        this.clientId = clientId;
        this.salaire = salaire;
        this.statutMatrimonial = statutMatrimonial;
        this.anneeNaissance = anneeNaissance;
        this.nip = nip;
    }

    public void nouveauCompte(String type, double initialDeposit){
       // CompteBancaire cb = new CompteBancaire(this.,this, type,initialDeposit);
    }

    public void ajouterSolde(int montant, CompteBancaire compte){
    }

    public void retirerSolde(int montant, CompteBancaire compte){

    }

    public void afficherHistoriqueParCompte(CompteBancaire compte){
    }

    public void informationCredit(double montantPret, double taux, double montantMensuel){
        System.out.print("Montant à payer avec intérêts: ");
        double total = montantPret * (taux/100 + 1);
        System.out.println(total);

        System.out.print("Nombre de mois à payer: ");
        int month = 0;
        int year = 0;
        int totalMonth = (int)(total/montantMensuel);
        if ((totalMonth) > 12){
            year = totalMonth / 12;
            month = totalMonth % 12;
        }
        System.out.println(year + " Année et " + month + " Mois");



    }

    public String toString(){
        return (this.clientId + ". " + this.nom + " "+ this. prenom);
    }


}
