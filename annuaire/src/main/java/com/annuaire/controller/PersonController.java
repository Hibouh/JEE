package com.annuaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
public class PersonController {
    @Autowired
    private UserRepository userRepository;
    
    /**
     * Request method GET with requestmapping value = listPerson and listp
     * @param model entity use in jsp page
     * @return name of jsp page
     */
    @RequestMapping(value = {"/listPerson","/listp"}, method = RequestMethod.GET)
	public String listPerson(Model model) {
    	model.addAttribute("listPerson",userRepository.findAll());
		return "listPerson";
	}
}
