/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entityPackage.Client;
import java.util.List;
import javax.ejb.Local;


@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);
    
    public boolean userExist(String user);

    List<Client> findAll();

    List<Client> findRange(int[] range);
    
    public void createClient(model.Client c) throws Exception;
    
    public boolean validate (String user, String password) throws Exception;
    
    public model.Client findClient(String user);

    int count();
    
}
