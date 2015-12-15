/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entityPackage.Commande;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Quentin
 */
@Stateless
public class CommandeFacade extends AbstractFacade<Commande> implements CommandeFacadeLocal {
    @PersistenceContext(unitName = "WebAppeau-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFacade() {
        super(Commande.class);
    }
    
    @Override
    public void createCommande (model.Commande cmd){
    entityPackage.Commande cmdET = new entityPackage.Commande();
    cmdET.setDatecommande(cmd.getDateCommande());
    
    entityPackage.Client cliET = new entityPackage.Client();
    model.Client c = cmd.getClient();
    
    cliET.setAdressedomicile(c.getAdresse());
    cliET.setCommandeCollection(null);
    cliET.setEmail(c.getEmail());
    cliET.setLogin(c.getUsername());
    cliET.setNumtel(c.getNumTel());
    cliET.setVille(c.getVille());
    cliET.setCpostal(c.getCpostal());
    cliET.setId(c.getId());
    
    
    cmdET.setIdclient(cliET);
    
    create(cmdET);
    
    
    
    }
    
}
