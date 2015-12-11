/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Quentin
 */
public class Animal {
    private int id;
    private String nom;
    private Date datedébutchasse;
    private Date datefinchasse;
    private String urlimage;
    private Categorie idcategorie;

    
    
    public Animal(int i, String n, Date debut, Date fin, String url, Categorie idc)
    {
        id = i;
        nom = n;
        datedébutchasse = debut;
        datefinchasse = fin;
        urlimage = url;
        idcategorie = idc;
    }
    
    public Animal(){}
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDatedébutchasse() {
        return datedébutchasse;
    }

    public void setDatedébutchasse(Date datedébutchasse) {
        this.datedébutchasse = datedébutchasse;
    }

    public Date getDatefinchasse() {
        return datefinchasse;
    }

    public void setDatefinchasse(Date datefinchasse) {
        this.datefinchasse = datefinchasse;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    public Categorie getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Categorie idcategorie) {
        this.idcategorie.setId(idcategorie.getId());
    }
    
    public void setIdCatToNull(Categorie cat){
    this.idcategorie = cat;}
    
}
