/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import facades.CommandeFacadeLocal;
import facades.ContenantFacadeLocal;
import java.util.Date;
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
        Date date = new Date();
        if( !(cmd.getClient()==null) || (date.compareTo(cmd.getDateCommande())<0))
        {
            commandeFacade.createCommande(cmd);
        }
    }
    
    @Override
    public void createContenant(HashMap<Integer, Contenant> hmapApp){
        
        boolean isValid = true;
        
        for(Contenant cont : hmapApp.values())
        {
            if( (cont.getIDCommande()<=0) || (cont.getPrix() <= 0) || (cont.getQtité() <=0) ){
                isValid = false;
            }
        }
        
        if(isValid){
            contenantFacade.createContenant(hmapApp);
        }
        
    }
    
}
