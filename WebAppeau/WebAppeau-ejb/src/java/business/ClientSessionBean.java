/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import facades.ClientFacadeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Client;

/**
 *
 * @author Quentin
 */
@Stateless
public class ClientSessionBean implements ClientSessionBeanLocal {
    @EJB
    private ClientFacadeLocal clientFacade;
    
    

    @Override
    public void createClient(Client c) {
        try {
            clientFacade.createClient(c);
        } catch (Exception ex) {
            Logger.getLogger(ClientSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public boolean validate(String user, String password) throws Exception {
        return clientFacade.validate(user, password);
    }
    
    @Override
    public boolean userExist(String user){
        return clientFacade.userExist(user);
    }
    
    @Override
    public Client findClient(String user){
        return clientFacade.findClient(user);
    }
    
    
}
