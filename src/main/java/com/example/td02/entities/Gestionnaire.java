package com.example.td02.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.*;

@Entity
@DiscriminatorValue("G")
public class Gestionnaire extends User{
    int numBureau;
    List<Client> clients;
    String motDePasse;
    String username;

    public List<Client> getClients() {
        return clients;
    }

    public Gestionnaire(String nom, String prenom, String telephone, String email, String sexe, Adresse adresse, int numBureau, List<Client> clients, String motDePasse, String username) {
        super(nom, prenom, telephone, email, sexe, adresse);
        this.numBureau = numBureau;
        this.clients = clients;
        this.motDePasse = passWordEncyprtion(motDePasse);
        this.username = username;
    }

    public void addClient(){
    }

    public void VoirSoldeClient(){
        Client client = menu();

    }

    public void afficherClients(){
        this.clients.forEach(n -> System.out.println(n.toString()));
    }

    public boolean accorderCredit(){
        Client client = menu();
        if (client.salaire < 31000 && client.statutMatrimonial.equals( "celibataire")|| client.statutMatrimonial.equals("divorce"))
            return false;
        else if(client.salaire < 21000 && client.statutMatrimonial.equals("marié"))
            return false;
        else
            if (client.sexe.toLowerCase().equals("homme"))
                if ((Calendar.getInstance().get(Calendar.YEAR) - client.anneeNaissance )< 21)

                    return false;
            else
                if  ((Calendar.getInstance().get(Calendar.YEAR) - client.anneeNaissance) < 18)
                    return false;
        System.out.println(Calendar.getInstance().get(Calendar.YEAR) - client.anneeNaissance);
        return true;
    }
    public void nouveauCompteClient(){
        Client client = menu();
        System.out.println("Quelle type de compte?");
        System.out.println("1. Épargne");
        System.out.println("2. Cheque");

        Scanner scanner = new Scanner(System.in);
        String type = "";
        int choix = scanner.nextInt();
        switch (choix){
            case 1:
                type = "Épargne";
                break;
            case 2:
                type = "Chèque";
                break;
        }
        System.out.println("Solde Initial à déposer?");
        double soldeInit = scanner.nextDouble();
        CompteBancaire cb = new CompteBancaire(client, type, soldeInit );
        client.comptes.add(cb);
        System.out.println("Compte créé avec succès ");
    }
    public void operation() {

    }
    public void statistic()
    {
        double totalSalaire = 0;
        Client salaireMax = null;
        Client salaireMin = null;

        for (int i = 0; i < this.clients.size(); i++){
            if (i == 0){
                salaireMax = this.clients.get(i);
                salaireMin = this.clients.get(i);
            }

            if (this.clients.get(i).salaire > salaireMax.salaire)
            {
                salaireMax = this.clients.get(i);
            }

            if (this.clients.get(i).salaire < salaireMin.salaire)
            {
                salaireMin = this.clients.get(i);
            }
            totalSalaire += this.clients.get(i).salaire;
        }
        System.out.println("La moyenne des salaire est : "+ totalSalaire / clients.size());
        System.out.println("Client avec le salaire le plus faible : " + salaireMin.toString());
        System.out.println("Client avec le salaire le plus Haut : " + salaireMax.toString());

    }
    public void swap()
    {
        Client salaireMax = null;
        afficherClients();
        for (int i = 0; i < this.clients.size(); i++){
            if (i == 0)
                salaireMax = this.clients.get(i);
            if (this.clients.get(i).salaire > salaireMax.salaire)
                salaireMax = this.clients.get(i);

        }

        for (int i = 0; i < this.clients.size(); i++)
        {
            if (clients.get(i) == salaireMax)
                Collections.swap(this.clients, 0,i);
        }
        afficherClients();

    }
    private Client menu(){
        afficherClients();
        System.out.println("Avec quelle Client voulez-vous faire les opérations");
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        Client client = null;
        for (User u : Banque.getInstance().getUsers()){
            if (u instanceof Client)
                if (( (Client) u).clientId == choix)
                    client = (Client) u;

        }
        if (client == null)
            System.out.println("Error");
        return client;
    }

    public String getMotDePasse() {
        return passwordDecryption();
    }

    public String getUsername() {
        return username;
    }


    public String passWordEncyprtion(String password) //Ceasar Cypher
    {
        String encrypted = "";
        for(char ch : password.toCharArray()){
            encrypted = encrypted + (Character.toString(ch + 3));
        }

        return encrypted;

    }

    public String passwordDecryption(){ // Ceasar Decryption

        String encrypted = this.motDePasse;
        String decrypted = "";

        for(char ch : encrypted.toCharArray()){
            decrypted = decrypted + (Character.toString(ch - 3));
        }
        System.out.println(decrypted);

        return decrypted;
    }

    public String passWordEncyprtion(String password, int key)
    {
        return "defs";
    }
}
