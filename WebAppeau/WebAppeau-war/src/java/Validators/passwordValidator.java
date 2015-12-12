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


@FacesValidator("passwordValidator")
public class passwordValidator implements Validator {
    
    public void getAttribut(){
    }
    
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
    {
        String lang = (String) component.getValueExpression("passwordValAtt").getValue(context.getELContext());
        
        
        String entry = (String) value;
        UIInput uiInputConfirmPassword = (UIInput) component.getAttributes().get("confirmPassword");
        String confirmPassword = uiInputConfirmPassword.getSubmittedValue().toString();
        FacesMessage mess;
        if(entry == null || entry.isEmpty() || confirmPassword == null || confirmPassword.isEmpty()){
            return;}
        if(!entry.equals(confirmPassword)){
            uiInputConfirmPassword.setValid(false);
            if(lang.equals("fr")){
            mess = new FacesMessage(" Les mots de passe doivent être identiques");
            }
            else
            {
            mess = new FacesMessage(" Password must be the same");
            }
            throw new ValidatorException(mess);
        }
    }
}
