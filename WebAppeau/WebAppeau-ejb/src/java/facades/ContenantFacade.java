/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entityPackage.Contenant;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ContenantFacade extends AbstractFacade<Contenant> implements ContenantFacadeLocal {
    @EJB
    private CommandeFacadeLocal commandeFacade;
    @PersistenceContext(unitName = "WebAppeau-ejbPU")
    private EntityManager em;
    
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContenantFacade() {
        super(Contenant.class);
    }
    
    @Override
    public void createContenant(HashMap<Integer, model.Contenant> hmapapp){
        Query query = em.createNamedQuery("Commande.findById");
        entityPackage.Contenant contET;
        entityPackage.Appeau appET;
        BigDecimal b;
        entityPackage.Commande cmd;
        int c;
        
        for(model.Contenant cont : hmapapp.values())
        {
            appET = new entityPackage.Appeau();
            contET = new entityPackage.Contenant();
            appET.setId(cont.getApp().getId());
            appET.setIdanimal(null);
            b = new BigDecimal(cont.getApp().getPrix(), MathContext.DECIMAL64);
            appET.setPrix(b);
            appET.setUrlimage(cont.getApp().getUrlImage());
            appET.setNom(cont.getApp().getNom());
            b = new BigDecimal(cont.getPrix(), MathContext.DECIMAL64);
            contET.setIdappeau(appET);
            contET.setPrixappeaux(b);
            contET.setQuantité(cont.getQtité());
            c = commandeFacade.count();
            query.setParameter("id", c);
            cmd = (entityPackage.Commande) query.getSingleResult();
            contET.setIdcmd(cmd);
            create(contET);
            
        }
    }
    
}
