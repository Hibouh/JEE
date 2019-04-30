package com.annuaire.account.validator;

import com.annuaire.account.model.User;
import com.annuaire.account.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;
    EmailValidator emailValidator = new EmailValidator();
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        if(user.getFirstName().length()< 2)
        	errors.rejectValue("firstName", "Size.userForm.firstName");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        if(user.getLastName().length()< 1)
        	errors.rejectValue("lastName", "Size.userForm.lastName");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "NotEmpty");
        if(!emailValidator.validateEmail(user.getMail()))
        	errors.rejectValue("mail", "Form.userForm.mail");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "site", "NotEmpty");
        if(emailValidator.validateEmail(user.getMail()))
        	errors.rejectValue("site", "Size.userForm.site");
    }
}
