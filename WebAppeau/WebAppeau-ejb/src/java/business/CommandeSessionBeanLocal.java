/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.HashMap;
import javax.ejb.Local;
import model.Commande;
import model.Contenant;


@Local
public interface CommandeSessionBeanLocal {
    public void createCommande(Commande cmd);
    
    public void createContenant(HashMap<Integer, Contenant> hmapApp);
    
}
