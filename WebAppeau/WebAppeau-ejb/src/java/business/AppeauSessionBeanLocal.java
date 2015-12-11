/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.List;
import javax.ejb.Local;
import model.Animal;
import model.Appeau;

/**
 *
 * @author Quentin
 */
@Local
public interface AppeauSessionBeanLocal {

    List<Appeau> getAppeauList();
    public List<model.Appeau> appeauFromAnimal(Animal an);
    
}
