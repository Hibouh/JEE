package com.annuaire.account.controller;

import com.annuaire.account.model.User;
import com.annuaire.account.repository.RoleRepository;
import com.annuaire.account.repository.UserRepository;
import com.annuaire.account.service.SecurityService;
import com.annuaire.account.service.UserService;
import com.annuaire.account.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
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

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
    
    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public String test(Model model) {
        return "test";
    }   
    
    @RequestMapping(value = {"/listPerson","/listp"}, method = RequestMethod.GET)
	public String listPerson(Model model) {
    	model.addAttribute("listPerson",userRepository.findAll());
		return "listPerson";
	}
    
    @RequestMapping(value = {"/listGroup","/listg"}, method = RequestMethod.GET)
	public String listGroup(Model model) {
    	model.addAttribute("listGroup",roleRepository.findAll());
		return "listGroup";
	}
}
