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
public class Contenant {
    private int id;
    private double prix;
    private int qtité;
    private Appeau app;
    private int IDCommande;
    
    
    public Contenant(){}
    
    public Contenant(int i, double p, int q, Appeau ida, int idc){
        id= i;
        prix=p;
        qtité=q;
        app=ida;
        IDCommande=idc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQtité() {
        return qtité;
    }

    public void setQtité(int qtité) {
        this.qtité = qtité;
    }

    public Appeau getApp() {
        return app;
    }

    public void setApp(Appeau app) {
        this.app = app;
    }


    public int getIDCommande() {
        return IDCommande;
    }

    public void setIDCommande(int IDCommande) {
        this.IDCommande = IDCommande;
    }
    
    
    
    
}
