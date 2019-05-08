package com.annuaire.controller;


import com.annuaire.model.User;

import com.annuaire.repo.RoleRepository;
import com.annuaire.repo.UserRepository;
import com.annuaire.service.SecurityService;
import com.annuaire.service.UserService;
import com.annuaire.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 * @author LE Dan
 *
 */
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
    
    @RequestMapping(value = {"/example"}, method = RequestMethod.GET)
	public String example(Model model) {

		return "example";
	}

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
    	model.addAttribute("listGroup",roleRepository.findAll());

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
    
    @RequestMapping(value = {"/listGroupPerson/{role}"}, method = RequestMethod.GET) 
	public String listGroupId(Model model, @PathVariable String role) {
    	model.addAttribute("listPerson",userRepository.findByRole(role));
		return "listGroupPerson";
	}
    
    @RequestMapping(value = {"/account/{name}"}, method = RequestMethod.GET)
	public String account(Model model,@PathVariable String name) {
    	model.addAttribute("userForm",userRepository.findByUsername(name));
    	model.addAttribute("listGroup",roleRepository.findAll());
		return "account";
	}
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
    @RequestMapping(value = {"/person/search"}, method = RequestMethod.POST)
	public String search(Model model,@RequestParam("search-value") String search) {
    	model.addAttribute("listPerson",userRepository.findBySearch(search));
		return "listPerson";
		
	}
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
}
