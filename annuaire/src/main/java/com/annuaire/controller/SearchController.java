package com.annuaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
public class SearchController {
	
    @Autowired
    private UserRepository userRepository;
    
    /**
     * Request method POST with requestmapping value = account/search
     * @param model entity use in jsp page
     * @param search value for research
     * @return name of jsp page
     */
    @RequestMapping(value = {"/person/search"}, method = RequestMethod.POST)
	public String search(Model model,@RequestParam("search-value") String search) {
    	model.addAttribute("listPerson",userRepository.findBySearch(search));
		return "listPerson";
		
	}
}
