/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entityPackage.Appeau;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Animal;

@Stateless
public class AppeauFacade extends AbstractFacade<Appeau> implements AppeauFacadeLocal {
    @PersistenceContext(unitName = "WebAppeau-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppeauFacade() {
        super(Appeau.class);
    }
    
    @Override
    public List<model.Appeau> allAppeau(){
        int i = 0;
        List<entityPackage.Appeau> appList = findAll();
        List<model.Appeau> resList = new ArrayList<model.Appeau>();
        while(i<appList.size()){
        model.Appeau app = new model.Appeau();
        app.setId(appList.get(i).getId());
        app.setNom(appList.get(i).getNom());
        app.setPrix(appList.get(i).getPrix().doubleValue());
        app.setUrlImage(appList.get(i).getUrlimage());
        app.setAnimal(null);
        resList.add(app);
        i++;
        }
    return resList;
    }
    
    @Override
    public List<model.Appeau> appeauFromAnimal(model.Animal an){
        Query query;
        query = em.createNamedQuery("Appeau.findByAnimal");
        entityPackage.Animal ani = new entityPackage.Animal();
        ani.setId(an.getId());
        ani.setNom(an.getNom());
        ani.setAppeauCollection(null);
        ani.setDatedébutchasse(an.getDatedébutchasse());
        ani.setDatefinchasse(an.getDatefinchasse());
        ani.setUrlimage(an.getUrlimage());
        ani.setIdcategorie(null);
        double prix;
        Date date = new Date();
        
        query.setParameter("idan", ani);
        int i = 0;
        List<entityPackage.Appeau> anList = query.getResultList();
        List<model.Appeau> resList = new ArrayList<model.Appeau>();
        while(i<anList.size()){
        model.Appeau ap = new model.Appeau();
        ap.setAnimal(null);
        ap.setId(anList.get(i).getId());
        ap.setNom(anList.get(i).getNom());
        prix = anList.get(i).getPrix().doubleValue();
        
        if((date.compareTo(an.getDatedébutchasse())>0) && (date.compareTo(an.getDatefinchasse())<0)){
            prix = prix - prix*0.15;
        }
        ap.setPrix(prix);
        ap.setUrlImage(anList.get(i).getUrlimage());
        resList.add(ap);
        i++;
        }
        
    return resList;
    }
    
}
