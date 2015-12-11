/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appeauManagedBean;

import business.AnimalSessionBeanLocal;
import business.AppeauSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Animal;
import model.Appeau;

/**
 *
 * @author Quentin
 */
@Named(value = "appManager")
@SessionScoped
public class AppManager implements Serializable {
    @EJB
    private AppeauSessionBeanLocal appeauSessionBean;
    @EJB
    private AnimalSessionBeanLocal animalSessionBean;
    

    private Appeau appeauToManage;
    
    
    
    
    
    public AppManager() {
        this.appeauToManage = new Appeau();
    }
    


    public Appeau getAppeauToManage() {
        return appeauToManage;
    }

    public void setAppeauToManage(Appeau appeauToManage) {
        this.appeauToManage = appeauToManage;
    }
  
    public List<Appeau> getAppeauList(){
    return appeauSessionBean.getAppeauList();
    }

      public List<Appeau> appeauFromAnimal(int an){
    return appeauSessionBean.appeauFromAnimal(animalSessionBean.animalFromId(an));
    }
}
