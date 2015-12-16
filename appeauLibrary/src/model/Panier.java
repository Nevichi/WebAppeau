
package model;

import java.util.ArrayList;

public class Panier {
    
    
    private ArrayList<Appeau> listeAppeau;
    private int idCommande;
    
    public Panier(){
        listeAppeau = new ArrayList<Appeau>();
    }
    
    public void addAppeau(Appeau app)
    {
        listeAppeau.add(app);
    }

    public ArrayList<Appeau> getListeAppeau() {
        return listeAppeau;
    }

    public void setListeAppeau(ArrayList<Appeau> listeAppeau) {
        this.listeAppeau = listeAppeau;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }
    
    
    
    
    
}
