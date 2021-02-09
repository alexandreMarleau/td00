package com.example.td02.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Banque")
public class Banque implements Serializable {
    private static Banque banque_instance = new Banque();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="Nom")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<User> users;

    private Banque(){
        users = new ArrayList<User>();
    }
    public static Banque getInstance()
    {
        return banque_instance;
    }
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Gestionnaire getGestionnaireByUsername(String username){
        for(User u: users){
            if (u instanceof Gestionnaire && ((Gestionnaire) u).getUsername().equals(username) ){
                return (Gestionnaire) u;
            }
        }
        return null;
    }
}
