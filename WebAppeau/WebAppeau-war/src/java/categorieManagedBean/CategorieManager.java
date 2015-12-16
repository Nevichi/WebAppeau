/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categorieManagedBean;

import business.CategorieSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Categorie;


@Named(value="categorieManager")
@SessionScoped
public class CategorieManager implements Serializable {
    @EJB
    private CategorieSessionBeanLocal categorieSessionBean;

    
    private Categorie categorieToManage;

    public Categorie getCategorieToManage() {
        return categorieToManage;
    }

    public void setCategorieToManage(Categorie categorieToManage) {
        this.categorieToManage = categorieToManage;
    }
    
    
    public CategorieManager() {
        categorieToManage = new Categorie();
    }
    
    public List<Categorie> allCategorieTrad(String id){
        int intid;
        if(id.equals("fr"))
        {
            intid = 1;
        }
        else
        {
            intid = 2;
        }
        return categorieSessionBean.allCategorie(intid);
    }
    
 
    
}
