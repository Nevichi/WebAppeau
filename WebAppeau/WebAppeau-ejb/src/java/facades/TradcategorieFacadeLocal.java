/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entityPackage.Tradcategorie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Quentin
 */
@Local
public interface TradcategorieFacadeLocal {

    void create(Tradcategorie tradcategorie);

    void edit(Tradcategorie tradcategorie);

    void remove(Tradcategorie tradcategorie);

    Tradcategorie find(Object id);

    List<Tradcategorie> findAll();

    List<Tradcategorie> findRange(int[] range);

    int count();
    
}
