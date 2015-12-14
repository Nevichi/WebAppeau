/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author Quentin
 */
public class Appeau {
    private int id;
    private double prix;
    private String nom;
    private Animal refAnimal;
    private String urlImage;
    
    
    public Appeau(int i, double p, String n, String url){
    id = i;
    prix=p;
    nom = n;
    urlImage = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public Appeau(){}

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdAnimal() {
        return refAnimal.getId();
    }

    public void setIdAnimal(int idAnimal) {
        this.refAnimal.setId(idAnimal);
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
    
    public void setAnimal(Animal an){
        refAnimal = an;
    }
    
    public Animal getAnimal(){
        return refAnimal;
    }
    
}
