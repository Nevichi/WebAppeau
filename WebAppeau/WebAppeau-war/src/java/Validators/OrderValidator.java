/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("orderValidator")
public class OrderValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String ent = String.valueOf(value);
        String lang = (String) component.getValueExpression("inputValAtt").getValue(context.getELContext());
        int entry = Integer.parseInt(ent);
        FacesMessage mess;
        if(!ent.matches("^[0-9]+$")){
            
            if(lang.equals("fr")){
                throw new ValidatorException(new FacesMessage (" Vous devez entre un nombre"));
            }
            else
            {
                throw new ValidatorException(new FacesMessage (" You must give a number"));
            }
        }
        
        
        if(entry <= 0){
            if(lang.equals("fr")){
            mess = new FacesMessage(" Vous devez entrer un nombre positif !");
            }
            else
            {
            mess = new FacesMessage(" The amount must be positive");
            }
            throw new ValidatorException(mess);
        }
        
    }
    
    
}
