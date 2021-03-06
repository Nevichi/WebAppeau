/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entityPackage.Animal;
import java.util.List;
import javax.ejb.Local;
import model.Categorie;


@Local
public interface AnimalFacadeLocal {

    void create(Animal animal);

    void edit(Animal animal);

    void remove(Animal animal);

    Animal find(Object id);

    List<Animal> findAll();

    List<Animal> findRange(int[] range);
    
    public List<model.Animal> allAnimal();
    
    public List<model.Animal> animalFromCat(Categorie id, int idlang);
    
    public model.Animal animalFromId(int id);
    
    public List<model.Animal> search(String item, int idlang);

    int count();
    
}
