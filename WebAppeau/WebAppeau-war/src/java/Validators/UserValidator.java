/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validators;

import business.ClientSessionBeanLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Quentin
 */
@FacesValidator("userValidator")
public class UserValidator implements Validator {
    ClientSessionBeanLocal clientSessionBean = lookupClientSessionBeanLocal();
        
    public void getAttribut(){
    }
    
    
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
    {
        String lang = (String) component.getValueExpression("userValAtt").getValue(context.getELContext());
        
        String entry = (String) value;
        FacesMessage mess;
        if(clientSessionBean.userExist(entry)){
            if(lang.equals("fr")){
            mess = new FacesMessage(" Cet utilisateur existe déjà !");
            }
            else
            {
            mess = new FacesMessage(" User already exists !");
            }
            throw new ValidatorException(mess);
        }
    }

    private ClientSessionBeanLocal lookupClientSessionBeanLocal() {
        try {
            Context c = new InitialContext();
            return (ClientSessionBeanLocal) c.lookup("java:global/WebAppeau/WebAppeau-ejb/ClientSessionBean!business.ClientSessionBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
