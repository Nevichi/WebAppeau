/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entityPackage.Client;
import java.security.Key;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Quentin
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {
    @PersistenceContext(unitName = "WebAppeau-ejbPU")
    private EntityManager em;
    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = 
    new byte[] { 'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
    
    @Override
    public void createClient(model.Client c) throws Exception{
    String mdp;
    entityPackage.Client cliET = new entityPackage.Client();
    cliET.setAdressedomicile(c.getAdresse());
    cliET.setCommandeCollection(null);
    cliET.setEmail(c.getEmail());
    cliET.setLogin(c.getUsername());
    cliET.setNumtel(c.getNumTel());
    cliET.setVille(c.getVille());
    cliET.setCpostal(c.getCpostal());
    mdp = encrypt(c.getPassword());
    cliET.setPassword(mdp);
    create(cliET);
    }
    
    
    
    private static Key generateKey() throws Exception {
    Key key = new SecretKeySpec(keyValue, ALGORITHM);
    return key;
    }
    
    //Encrypt en AES
     public String encrypt(String valueToEnc) throws Exception {
    Key key = generateKey();
    Cipher c = Cipher.getInstance(ALGORITHM);
    c.init(Cipher.ENCRYPT_MODE, key);
    byte[] encValue = c.doFinal(valueToEnc.getBytes());
    String encryptedValue = new BASE64Encoder().encode(encValue);
    return encryptedValue;
    }
     
     public String decrypt(String encryptedValue) throws Exception {
    Key key = generateKey();
    Cipher c = Cipher.getInstance(ALGORITHM);
    c.init(Cipher.DECRYPT_MODE, key);
    byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
    byte[] decValue = c.doFinal(decordedValue);
    String decryptedValue = new String(decValue);
    return decryptedValue;
    }
     
    @Override
     public boolean validate (String user, String password) throws Exception{
         if(user==null && password ==null)
         {
             return false;
         }
         
         Query query;
         query= em.createNamedQuery("Client.validate");
         query.setParameter("log", user);
         query.setParameter("mdp", encrypt(password));
         List<entityPackage.Client> cliList = query.getResultList();
         
         if(cliList.isEmpty())
         {
             return false;
         }
         
         return true;
     }
     
     
    @Override
     public boolean userExist(String user){
         Query query = em.createNamedQuery("Client.findByLogin");
         query.setParameter("login", user);
         List<entityPackage.Client> cliList = query.getResultList();
         
         if(cliList.isEmpty()){
             return false;
         }
         return true; 
     }
          
    @Override
     public model.Client findClient(String user){
         Query query = em.createNamedQuery("Client.findByLogin");
         query.setParameter("login", user);
         entityPackage.Client cliET = (entityPackage.Client) query.getSingleResult();
         model.Client client = new model.Client();
         
         client.setAdresse(cliET.getAdressedomicile());
         client.setCpostal(cliET.getCpostal());
         client.setEmail(cliET.getEmail());
         client.setNumTel(cliET.getNumtel());
         client.setUsername(cliET.getLogin());
         client.setVille(cliET.getVille());
         client.setId(cliET.getId());
         
         return client; 
     }
}
