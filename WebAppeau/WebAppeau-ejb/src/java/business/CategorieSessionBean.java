/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import facades.CategorieFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Categorie;

/**
 *
 * @author Quentin
 */
@Stateless
public class CategorieSessionBean implements CategorieSessionBeanLocal {
    @EJB
    private CategorieFacadeLocal categorieFacade;

    
    
    
    @Override
    public Categorie getCategorieFromId(int id) {
        return categorieFacade.findCat(id);
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Categorie> allCategorie() {
        return categorieFacade.allCategorie();
    }
    
    
    
}