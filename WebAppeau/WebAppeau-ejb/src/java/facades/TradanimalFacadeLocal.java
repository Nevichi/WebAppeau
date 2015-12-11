/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entityPackage.Tradanimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Quentin
 */
@Local
public interface TradanimalFacadeLocal {

    void create(Tradanimal tradanimal);

    void edit(Tradanimal tradanimal);

    void remove(Tradanimal tradanimal);

    Tradanimal find(Object id);

    List<Tradanimal> findAll();

    List<Tradanimal> findRange(int[] range);

    int count();
    
}
