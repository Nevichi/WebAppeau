/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import facades.CommandeFacadeLocal;
import facades.ContenantFacadeLocal;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Commande;
import model.Contenant;


@Stateless
public class CommandeSessionBean implements CommandeSessionBeanLocal {
    @EJB
    private ContenantFacadeLocal contenantFacade;
    @EJB
    private CommandeFacadeLocal commandeFacade;
    
    
    @Override
    public void createCommande(Commande cmd){
        commandeFacade.createCommande(cmd);
    }
    
    public void createContenant(HashMap<Integer, Contenant> hmapApp){
        contenantFacade.createContenant(hmapApp);
    }
    
}
