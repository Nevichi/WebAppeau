/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entityPackage.Langue;
import entityPackage.Tradcategorie;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Quentin
 */
@Stateless
public class TradcategorieFacade extends AbstractFacade<Tradcategorie> implements TradcategorieFacadeLocal {
    @PersistenceContext(unitName = "WebAppeau-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TradcategorieFacade() {
        super(Tradcategorie.class);
    }
    
    @Override
    public List<model.Categorie> getAllTradCategorie(int idlang){
        Query query = em.createNamedQuery("Tradcategorie.getAllTraduction");
        Langue lang = new Langue();
        lang.setId(idlang);
        query.setParameter("idlang", lang);
        int i = 0;
        List<entityPackage.Tradcategorie> catListTraduites = query.getResultList();
        List<model.Categorie> resList = new ArrayList<model.Categorie>();
        while(i<catListTraduites.size()){
        model.Categorie cat = new model.Categorie();
        cat.setNom(catListTraduites.get(i).getTradnom());
        resList.add(cat);
        i++;
        }
    return resList;
        
    }
    
}
