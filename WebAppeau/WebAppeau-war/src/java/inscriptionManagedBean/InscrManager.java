/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscriptionManagedBean;

import business.ClientSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import model.Client;

/**
 *
 * @author Quentin
 */
@Named(value = "inscrManager")
@SessionScoped
public class InscrManager implements Serializable {
    @EJB
    private ClientSessionBeanLocal clientSessionBean;

    private Client clientToManage;
    
    
    
    public InscrManager() {
        clientToManage = new Client();
    }
    
    

    public Client getClientToManage() {
        return clientToManage;
    }

    public void setClientToManage(Client clientToManage) {
        this.clientToManage = clientToManage;
    }
    
    public String createClient(){
        clientSessionBean.createClient(clientToManage);
        String user = clientToManage.getUsername();
        clientToManage = new Client();
        return user;
    }
   

}
