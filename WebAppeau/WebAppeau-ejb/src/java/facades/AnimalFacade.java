/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entityPackage.Animal;
import entityPackage.Langue;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Categorie;

/**
 *
 * @author Quentin
 */
@Stateless
public class AnimalFacade extends AbstractFacade<Animal> implements AnimalFacadeLocal {
    @PersistenceContext(unitName = "WebAppeau-ejbPU")
    private EntityManager em;
    List<entityPackage.Animal> test = new ArrayList<entityPackage.Animal>();
    entityPackage.Animal a1 = new entityPackage.Animal();
    entityPackage.Animal a2 = new entityPackage.Animal();
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnimalFacade() {
        super(Animal.class);
    }
    
    @Override
    public List<model.Animal> allAnimal(){
        int i = 0;
        List<entityPackage.Animal> anList = findAll();
        List<model.Animal> resList = new ArrayList<model.Animal>();
        if(!anList.isEmpty()){
        model.Animal an = new model.Animal();
        an.setDatedébutchasse(anList.get(i).getDatedébutchasse());
        an.setDatefinchasse(anList.get(i).getDatefinchasse());
        an.setId(anList.get(i).getId());
        an.setNom(anList.get(i).getNom());
        an.setUrlimage(anList.get(i).getUrlimage());
        an.setIdCatToNull(null);
        resList.add(an);
        i++;
        }
    return resList;
    }
    
    
    
            @Override
    public List<model.Animal> animalFromCat(Categorie id, int idlang){
        Query query, query2;
        query = em.createNamedQuery("Animal.findByCategorie");
        query2 = em.createNamedQuery("Tradanimal.getAnimalTrad");
        entityPackage.Categorie cat = new entityPackage.Categorie();
        cat.setId(id.getId());
        cat.setNom(id.getNom());
        cat.setAnimalCollection(null);
        query.setParameter("idcat", cat);
        Langue lang = new Langue();
        lang.setId(idlang);
        query2.setParameter("idlang", lang);
        int i = 0;
        List<entityPackage.Animal> anList = query.getResultList();
        List<model.Animal> resList = new ArrayList<model.Animal>();
        entityPackage.Tradanimal trad = new entityPackage.Tradanimal();
        
        while(i<anList.size()){
        model.Animal an = new model.Animal();
        an.setDatedébutchasse(anList.get(i).getDatedébutchasse());
        an.setDatefinchasse(anList.get(i).getDatefinchasse());
        an.setId(anList.get(i).getId());
        query2.setParameter("idan", anList.get(i));
        trad = (entityPackage.Tradanimal) query2.getSingleResult();
        an.setNom(trad.getNom());
        an.setUrlimage(anList.get(i).getUrlimage());
        an.setIdCatToNull(null);
        resList.add(an);
        i++;
        }
        
    return resList;
    }
    
    @Override
    public model.Animal animalFromId(int id){
        Query query = em.createNamedQuery("Animal.findById");
        query.setParameter("id", id);
        entityPackage.Animal res = (entityPackage.Animal) query.getSingleResult();
        model.Animal ani = new model.Animal();
        ani.setDatedébutchasse(res.getDatedébutchasse());
        ani.setDatefinchasse(res.getDatefinchasse());
        ani.setId(res.getId());
        ani.setIdCatToNull(null);
        ani.setNom(res.getNom());
        ani.setUrlimage(res.getUrlimage());
        
    return ani;
    }
    
}
