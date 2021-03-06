/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientManagedBean;

import business.ClientSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Client;


@Named(value="clientManager")
@SessionScoped
public class clientManager implements Serializable {
    @EJB
    private ClientSessionBeanLocal clientSessionBean;

    private Client client;
    private String logged;
    private boolean wrongLogin;
    private boolean isLogged;

    public boolean isIsLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }
    
    public clientManager() {
        client = new Client();
        wrongLogin = false;
    }

    public ClientSessionBeanLocal getClientSessionBean() {
        return clientSessionBean;
    }

    public void setClientSessionBean(ClientSessionBeanLocal clientSessionBean) {
        this.clientSessionBean = clientSessionBean;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getLogged() {
        return logged;
    }

    public void setLogged(String logged) {
        this.logged = logged;
    }
    
    
    
    public String validateUsernamePassword() throws Exception {
        boolean valid = clientSessionBean.validate(client.getUsername(), client.getPassword());
        FacesContext ctx = FacesContext.getCurrentInstance();
        
        if (valid) {
            logged = client.getUsername();
            client.setUsername(null);
            client.setPassword(null);
            isLogged = true;
            wrongLogin = false;
            return ctx.getViewRoot().getViewId();
        } else {
            isLogged = false;
            client.setUsername(null);
            client.setPassword(null);
            wrongLogin=true;
            return ctx.getViewRoot().getViewId();
        }
    }
 
    public String logout() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        logged = null;
        isLogged = false;
        return ctx.getViewRoot().getViewId();
    } 

    public boolean isWrongLogin() {
        return wrongLogin;
    }

    public void setWrongLogin(boolean wrongLogin) {
        this.wrongLogin = wrongLogin;
    }
    
    
    
    
}
