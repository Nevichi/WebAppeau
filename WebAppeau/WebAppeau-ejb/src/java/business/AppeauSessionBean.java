/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import facades.AppeauFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Animal;
import model.Appeau;

/**
 *
 * @author Quentin
 */
@Stateless
public class AppeauSessionBean implements AppeauSessionBeanLocal {
    @EJB
    private AppeauFacadeLocal appeauFacade;
    
    
    @Override
    public List<Appeau> getAppeauList() {
        return appeauFacade.allAppeau();
    }

    @Override
    public List<model.Appeau> appeauFromAnimal(Animal an){
    return appeauFacade.appeauFromAnimal(an);
    }
    
}
