
package model;

public class Categorie {
    private int id;
    private String nom;
    
    public Categorie(int i, String n){
    id = i;
    nom = n;
    }
    
    public Categorie(){}

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
    
    
    
}
