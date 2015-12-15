/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.ejb.Local;
import model.Client;

/**
 *
 * @author Quentin
 */
@Local
public interface ClientSessionBeanLocal {

    void createClient(Client c);
    
    public boolean validate(String user, String password) throws Exception;
    
    public boolean userExist(String user);
    
    public Client findClient(String user);
    
}
