/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entityPackage.Appeau;
import java.util.List;
import javax.ejb.Local;
import model.Animal;

/**
 *
 * @author Quentin
 */
@Local
public interface AppeauFacadeLocal {

    void create(Appeau appeau);

    void edit(Appeau appeau);

    void remove(Appeau appeau);

    Appeau find(Object id);

    List<Appeau> findAll();

    List<Appeau> findRange(int[] range);
    
    List<model.Appeau> allAppeau();
    
    public List<model.Appeau> appeauFromAnimal(Animal an);

    int count();
    
}
