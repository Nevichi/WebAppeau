/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import facades.AnimalFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Animal;
import model.Categorie;

/**
 *
 * @author Quentin
 */
@Stateless
public class AnimalSessionBean implements AnimalSessionBeanLocal {
    @EJB
    private AnimalFacadeLocal animalFacade;

    
    
    
    @Override
    public List<Animal> findAnimalByCategory(Categorie id) {
        return animalFacade.animalFromCat(id);
    }

    @Override
    public Animal animalFromId(int id){
        return animalFacade.animalFromId(id);
    }

    @Override
    public List<Animal> allAnimal() {
        return animalFacade.allAnimal();
    }
    
    
    
}
