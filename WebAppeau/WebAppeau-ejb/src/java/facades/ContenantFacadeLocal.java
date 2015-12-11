/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entityPackage.Contenant;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Quentin
 */
@Local
public interface ContenantFacadeLocal {

    void create(Contenant contenant);

    void edit(Contenant contenant);

    void remove(Contenant contenant);

    Contenant find(Object id);

    List<Contenant> findAll();

    List<Contenant> findRange(int[] range);

    int count();
    
}
