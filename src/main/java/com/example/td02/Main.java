package com.example.td02;

import com.example.td02.entities.*;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        String motDePasse;
        String username;

        generateBanque();
        Scanner scanner = new Scanner(System.in);
        int tentative = 0;
        do{
            tentative ++;
            System.out.println("Entrez Identifiant");
            username = scanner.nextLine();
            System.out.println("Entrez Mot de Passe");
            motDePasse = scanner.nextLine();


            if (authentification(username, motDePasse) == false){
                System.out.println("Erreur veuillez Réessayer");
            }

        }while(authentification(username, motDePasse) == false);
        System.out.println("Nombre de Tentative: " + tentative);


        System.out.println("-----------  Menu  ----------- ");

        System.out.println("1. Ajouter un Client");
        System.out.println("2. Consulter le solde du compte d’un client");
        System.out.println("3. Lister tout les clients");
        System.out.println("4. Accorder du crédit à un client");
        System.out.println("5. Ouvrir un nouveau compte à un client");
        System.out.println("6. Statistique ");

        System.out.println();
        System.out.println("veuillez choisir une action");
        Gestionnaire gestionnaire = Banque.getInstance().getGestionnaireByUsername(username);

        gestionnaire.getClients().get(0).informationCredit(2680,4.6, 215);
        gestionnaire.swap();

        int choix = scanner.nextInt();
        switch (choix)
        {
            case 1:
                gestionnaire.addClient();
                break;
            case 3:
                gestionnaire.afficherClients();
                break;
            case 4:
                System.out.println(gestionnaire.accorderCredit());
                break;
            case 5:
                gestionnaire.nouveauCompteClient();
                break;
            case 6:
                gestionnaire.statistic();
                break;
        }

    }

    public static List<Client> generateBanque(){
        Adresse adresse1 = new Adresse(123, "Giroux", "Mercier", "J7X 5H9");
        Adresse adresse2 = new Adresse(67, "Lafleur", "Valleyfield", "J9J 5H9");
        Adresse adresse3 = new Adresse(89, "7e Avenue", "Montréal", "Y8B 1L0");




        List clients = Arrays.asList(new Client[]{
                new Client("Lasalle","Alexandre", "450-900-458","Alex.23@gmail.com", "Homme", adresse1
                , 1,95000,"celibataire", 1986,1809),
                new Client("Savoie","Jacob", "514-990-9867","jacob.savoie@hotmail.ca","Homme", adresse2
                ,2,750000,"celibataire", 2011,1756),
                new Client("Tremblay","Martine", "514-997-9967","Tremblay.Richard@hotmail.ca","Femme", adresse3
                        ,3,80000,"marie", 1978,9687)});

        Banque.getInstance().getUsers().addAll(clients);

        Gestionnaire gestionnaire = new Gestionnaire("Laroche", "Vladimir", "450-9078-0956", "vladimirLaroche@hotmail.com",
                "Homme", new Adresse(345, "Des Tournesoles", "Moscou","J8l O7X"), 3,clients,
                "1234", "Vlad");

        Banque.getInstance().getUsers().add(gestionnaire);

        return clients;
    }
    public static boolean authentification(String username, String motDePasse){
        AtomicBoolean isCorrect = new AtomicBoolean(false);
        Banque.getInstance().getUsers().forEach(n -> {if (n instanceof Gestionnaire){
            if (username.equals( ((Gestionnaire) n).getUsername()) && motDePasse.equals ( ((Gestionnaire) n).getMotDePasse())){
                isCorrect.set(true);
            }
        }});

        return isCorrect.get();
    }
}



