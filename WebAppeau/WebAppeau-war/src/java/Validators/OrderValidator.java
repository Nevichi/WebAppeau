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

/**
 *
 * @author Quentin
 */
@FacesValidator("orderValidator")
public class OrderValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String ent = (String) value;
        int entry = Integer.parseInt(ent);
        UIOutput uiInputConfirmOrder = (UIOutput) component.getAttributes().get("confirmOrder");
        String confirmOrder = uiInputConfirmOrder.getValue().toString();
        int confInt = Integer.parseInt(confirmOrder);
        if(entry <= 0){
            throw new ValidatorException(new FacesMessage(" Vous devez entrer un nombre positif !"));
        }
        if(entry > confInt){
            throw new ValidatorException(new FacesMessage(" Il n'y a pas assez d'appeau en stock !"));
        }
    }
    
    
}
