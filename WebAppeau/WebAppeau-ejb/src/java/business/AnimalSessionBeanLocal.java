/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import model.Categorie;
import java.util.List;
import javax.ejb.Local;
import model.Animal;

/**
 *
 * @author Quentin
 */
@Local
public interface AnimalSessionBeanLocal {

    List<Animal> findAnimalByCategory(Categorie id, int idlang);

    List<Animal> allAnimal();
    
    public Animal animalFromId(int id);
    
}
