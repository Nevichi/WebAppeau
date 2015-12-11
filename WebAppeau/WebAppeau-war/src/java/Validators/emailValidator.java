/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("emailValidator")
public class emailValidator implements Validator {
    
    public void getAttribut(){
    }
    
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
    {
        String entry = (String) value;
        UIInput uiInputConfirmPassword = (UIInput) component.getAttributes().get("confirmEmail");
        String confirmEmail = uiInputConfirmPassword.getSubmittedValue().toString();
        if(entry == null || entry.isEmpty() || confirmEmail == null || confirmEmail.isEmpty()){
            return;}
        if(!entry.equals(confirmEmail)){
            uiInputConfirmPassword.setValid(false);
            throw new ValidatorException(new FacesMessage(" Le mail doit être le même"));
        }
        if (!(entry.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"))){
            uiInputConfirmPassword.setValid(false);
            throw new ValidatorException(new FacesMessage(" Le mail doit être valide"));
        }
    }
}
