/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.List;
import javax.ejb.Local;
import model.Categorie;


@Local
public interface CategorieSessionBeanLocal {

    Categorie getCategorieFromId(int id);

    List<Categorie> allCategorie(int idlang);
    
    List<Categorie> allCategorieTrad(int id);
    
}
