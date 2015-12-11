/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entityPackage.Categorie;
import entityPackage.Langue;
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
public class CategorieFacade extends AbstractFacade<Categorie> implements CategorieFacadeLocal {
    @PersistenceContext(unitName = "WebAppeau-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategorieFacade() {
        super(Categorie.class);
    }
    
    
        @Override
    public List<model.Categorie> allCategorie(int idlang){
        int i = 0;
        Query query = em.createNamedQuery("Tradcategorie.getTraduction");
        Langue lang = new Langue();
        lang.setId(idlang);
        query.setParameter("idlang", lang);
        List<entityPackage.Categorie> catList = findAll();
        List<model.Categorie> resList = new ArrayList<model.Categorie>();
        entityPackage.Tradcategorie trad = new entityPackage.Tradcategorie();
        while(i<catList.size()){
        model.Categorie cat = new model.Categorie();
        query.setParameter("idcat", catList.get(i));
        trad = (entityPackage.Tradcategorie) query.getSingleResult();
        cat.setId(catList.get(i).getId());
        cat.setNom(trad.getTradnom());
        resList.add(cat);
        i++;
        }
    return resList;
    }
    
    
    @Override
    public model.Categorie findCat(int id){
        Query query = em.createNamedQuery("Categorie.findById");
        query.setParameter("id", id);
        entityPackage.Categorie res = (entityPackage.Categorie) query.getSingleResult();
        model.Categorie cat = new model.Categorie();
        cat.setId(res.getId());
        cat.setNom(res.getNom());
        
    return cat;
    }
    
}
