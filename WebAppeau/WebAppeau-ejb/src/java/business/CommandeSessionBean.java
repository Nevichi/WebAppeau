/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import facades.CommandeFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Commande;

/**
 *
 * @author Quentin
 */
@Stateless
public class CommandeSessionBean implements CommandeSessionBeanLocal {
    @EJB
    private CommandeFacadeLocal commandeFacade;
    
    public void createCommande(Commande cmd){
        commandeFacade.createCommande(cmd);
    }
    
}
