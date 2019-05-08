package com.annuaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
public class GroupController {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    /**
     * Request method GET with requestmapping value = listGroup and listg
     * @param model entity use in jsp page
     * @return name of jsp page
     */
    @RequestMapping(value = {"/listGroup","/listg"}, method = RequestMethod.GET)
	public String listGroup(Model model) {
    	model.addAttribute("listGroup",roleRepository.findAll());
		return "listGroup";
	}
    /**
     * Request method GET with requestmapping value = listGroup and listg
     * @param model entity use in jsp page
     * @param role use for find role in user
     * @return name of jsp page
     */
    @RequestMapping(value = {"/listGroupPerson/{role}"}, method = RequestMethod.GET) 
	public String listGroupId(Model model, @PathVariable String role) {
    	model.addAttribute("listPerson",userRepository.findByRole(role));
		return "listPerson";
	}
}
