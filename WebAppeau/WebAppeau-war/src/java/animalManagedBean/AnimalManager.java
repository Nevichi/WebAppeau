/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalManagedBean;

import business.AnimalSessionBeanLocal;
import business.AppeauSessionBeanLocal;
import business.CategorieSessionBeanLocal;
import business.ClientSessionBeanLocal;
import business.CommandeSessionBeanLocal;
import clientManagedBean.clientManager;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.inject.Inject;
import model.Animal;
import model.Appeau;
import model.Categorie;
import model.Commande;
import model.Contenant;

/**
 *
 * @author Quentin
 */
@Named(value="animalManager")
@SessionScoped
public class AnimalManager implements Serializable {
    @EJB
    private CommandeSessionBeanLocal commandeSessionBean;
    @EJB
    private ClientSessionBeanLocal clientSessionBean;
    @EJB
    private AppeauSessionBeanLocal appeauSessionBean;
    @EJB
    private CategorieSessionBeanLocal categorieSessionBean;
    @EJB
    private AnimalSessionBeanLocal animalSessionBean;
    

    
    
    private Animal animalToManage;
    private int saveAnimal;
    private int saveCat;
    private Locale locale = new Locale("fr");
    private String itemSearch;
    private HashMap<Integer, Contenant> hmapApp;
    private int quantité;
    private Commande cmd;
    

    public Animal getAnimalToManage() {
        return animalToManage;
    }

    public void setAnimalToManage(Animal animalToManage) {
        this.animalToManage = animalToManage;
    }
    
    
    public AnimalManager() {
        animalToManage = new Animal();
        hmapApp = new HashMap<Integer, Contenant>();
    }

    public String getItemSearch() {
        return itemSearch;
    }

    public void setItemSearch(String itemSearch) {
        this.itemSearch = itemSearch;
    }

    
    
    
    public int getSaveCat() {
        return saveCat;
    }

    public void setSaveCat(int saveCat) {
        this.saveCat = saveCat;
    }
    
    
    
    public List<Animal> findAnimalFromCategory(int cat, String id){
        saveCat = cat;
        Categorie category = categorieSessionBean.getCategorieFromId(saveCat);
        int intid;
    if(id.equals("fr")){
        intid = 1;
    }
    else
    {
        intid = 2;
    }
    return animalSessionBean.findAnimalByCategory(category, intid);
    }
    
    public List<Animal> allAnimal(){
        return animalSessionBean.allAnimal();
    }
    
    public String outcome(Animal an){
        animalToManage=an;
        return "showAppeau2?faces-redirect=true";
    }
    
    public List<Appeau> getAppeauList(){
    return appeauSessionBean.getAppeauList();
    }

      public List<Appeau> appeauFromAnimal(int an){
            saveAnimal=an;
            return appeauSessionBean.appeauFromAnimal(animalSessionBean.animalFromId(saveAnimal));
      }

    public int getSaveAnimal() {
        return saveAnimal;
    }

    public void setSaveAnimal(int saveAnimal) {
        this.saveAnimal = saveAnimal;
    }
      
    
    
    public Locale getLocale(){return locale;}
    public void setToEnglish()
    {
        locale = new Locale("en");
    }
    
    public void setToFrench()
    {
        locale = new Locale("fr");
    }
      
    public String catOutcome(int catId){
        saveCat = catId;
        return "showAnimals.xhtml";
    }
    
    
    public List<Animal> search(String id){
    int intid;
    if(id.equals("fr")){
        intid = 1;
    }
    else
    {
        intid = 2;
    }
    String item = itemSearch.substring(0,1).toUpperCase() + itemSearch.substring(1);
    
    return animalSessionBean.search(item, intid);
    }

    public HashMap<Integer, Contenant> getHmapApp() {
        return hmapApp;
    }

    public void setHmapApp(HashMap<Integer, Contenant> hmapApp) {
        this.hmapApp = hmapApp;
    }
    
    
    public String order(Appeau app){
        
        if(hmapApp.containsKey(app.getId())){
            //l'appeau est dans la hmap
            Contenant cont = new Contenant();
            cont.setApp(app);
            int oldQte = hmapApp.get(app.getId()).getQtité();
            cont.setQtité(quantité + oldQte);
            cont.setPrix(app.getPrix() * quantité);
            hmapApp.replace(app.getId(), cont);
        }
        else
        {
            //cet appeau n'est pas encore dans la hmap
            Contenant cont = new Contenant();
            cont.setApp(app);
            cont.setPrix(app.getPrix() * quantité);
            cont.setQtité(quantité);
            hmapApp.put(app.getId(), cont);
        }
        quantité = 0;
        return "faces/panier.xhtml";
    }

    
    
    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }
    
    public double total(){
        double tot = 0;
        
        for(Contenant cont : hmapApp.values())
        {
            tot = tot + cont.getPrix();
        }
        return tot;
    }
    
    public String deleteOrder(Integer i)
    {
        hmapApp.remove(i);
        return "panier";
    }
    
    public String confirmOrder(String user, boolean isLogged){
        cmd = new Commande();
        if(isLogged){
            Date date = new Date();
            cmd.setDateCommande(date);
            cmd.setClient(clientSessionBean.findClient(user));
            commandeSessionBean.createCommande(cmd);
            commandeSessionBean.createContenant(hmapApp);
            hmapApp = new HashMap<Integer, Contenant>();
            return "confirm";
        }
        else
        {
            return "loginError";
        }
        
    }
    
}
