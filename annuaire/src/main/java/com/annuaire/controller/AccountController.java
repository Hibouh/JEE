package com.annuaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.annuaire.model.User;
import com.annuaire.repository.RoleRepository;
import com.annuaire.repository.UserRepository;
import com.annuaire.service.SecurityService;
import com.annuaire.service.UserService;
import com.annuaire.validator.UserValidator;
/**
 * 
 * @author LE Dan
 *
 */
@Controller
public class AccountController {
	
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private UserValidator userValidator;
    /**
     * Request method GET with requestmapping value = account/{name}
     * @param model entity use in jsp page
     * @param name entity use for search account
     * @return name of jsp page
     */
    @RequestMapping(value = {"/account/{name}"}, method = RequestMethod.GET)
	public String account(Model model,@PathVariable String name) {
    	model.addAttribute("userForm",userRepository.findByUsername(name));
    	model.addAttribute("listGroup",roleRepository.findAll());
		return "update";
	}
	/**
	 * Request method POST with requestmapping value = account/{name}
	 * @param userForm construct user with value in jsp page
	 * @param bindingResult binding result
	 * @param model entity use in jsp page
	 * @param name name
	 * @return name of jsp page
	 */
    @RequestMapping(value = {"/account/{name}"}, method = RequestMethod.POST)
	public String account(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model,@PathVariable String name) {
        userValidator.validate(userForm, bindingResult);
    	model.addAttribute("userForm",userRepository.findByUsername(name));
    	model.addAttribute("listGroup",roleRepository.findAll());
        if (bindingResult.hasErrors()) {
            return "/welcome";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
	}
}
