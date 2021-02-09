package com.example.td02.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adresse")
public class Adresse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "numCivic")
    private int numCivic;


    @Column(name = "rue")
    private String rue;

    @Column(name = "ville")
    private String ville;

    @Column(name = "codePostal")
    private String codePostal;



    public Adresse(int numCivic, String rue, String ville, String codePostal)
    {
        this.codePostal = codePostal;
        this.numCivic = numCivic;
        this.rue = rue;
        this.ville = ville;
    }

    public Adresse() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumCivic() {
        return numCivic;
    }

    public void setNumCivic(int numCivic) {
        this.numCivic = numCivic;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }


}
