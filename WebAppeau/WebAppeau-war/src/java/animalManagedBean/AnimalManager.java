/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalManagedBean;

import business.AnimalSessionBeanLocal;
import business.AppeauSessionBeanLocal;
import business.CategorieSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import model.Animal;
import model.Appeau;
import model.Categorie;

/**
 *
 * @author Quentin
 */
@Named(value="animalManager")
@SessionScoped
public class AnimalManager implements Serializable {
    @EJB
    private AppeauSessionBeanLocal appeauSessionBean;
    @EJB
    private CategorieSessionBeanLocal categorieSessionBean;
    @EJB
    private AnimalSessionBeanLocal animalSessionBean;
    

    private Animal animalToManage;
    private int saveAnimal;
    private int saveCat;

    public Animal getAnimalToManage() {
        return animalToManage;
    }

    public void setAnimalToManage(Animal animalToManage) {
        this.animalToManage = animalToManage;
    }
    
    
    public AnimalManager() {
        animalToManage = new Animal();
    }

    public int getSaveCat() {
        return saveCat;
    }

    public void setSaveCat(int saveCat) {
        this.saveCat = saveCat;
    }
    
    
    
    public List<Animal> findAnimalFromCategory(int cat){
        saveCat = cat;
        Categorie category = categorieSessionBean.getCategorieFromId(saveCat);
    return animalSessionBean.findAnimalByCategory(category);
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
      
    
    private Locale locale = new Locale("fr");
    
    public Locale getLocale(){return locale;}
    public void setToEnglish()
    {
        locale = new Locale("en");
    }
    
    public void setToFrench()
    {
        locale = new Locale("fr");
    }
      
    
}