package com.annuaire.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.annuaire.model.Group;
import com.annuaire.model.Person;
import com.annuaire.service.IGroupService;
import com.annuaire.service.IPersonService;
import com.annuaire.service.ISecurityService;
import com.annuaire.validator.IPersonValidator;




@Controller
public class LoginController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	IPersonService personService;
	
	@Autowired
	IGroupService groupService;
	
	@Autowired
	ISecurityService securityService;
	
	@Autowired
	IPersonValidator personValidator;
	
	
	/**
	 * Inject all available group inside every request
	 * @return Collection<Group>
	 */
	@ModelAttribute("groups")
	public Collection<Group> listGroups() {
		return groupService.findAll();
	}

	/**
	 * display registration page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("personForm", new Person());
		
		return "registration";
	}

	/**
	 * validate and save new person when registration submitted
	 * @param personForm
	 * @param bindingResult
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("personForm") Person personForm, BindingResult bindingResult, HttpServletRequest request) {
		personValidator.validate(personForm, bindingResult);
		
		if(bindingResult.hasErrors()) {
			logger.info("bindingResult has errors, refreshing to registration...");
			return new ModelAndView("/registration");
		}

		logger.info("Registering new person : " + personForm);
		
		personService.save(personForm);
		securityService.autologin(personForm.getMail(), personForm.getPwd(), request);
	    
		ModelAndView mv = new ModelAndView("/welcome");
	    mv.addObject("success", true);
		
		return mv;
	}
	
	/**
	 * Display login page
	 * @param model
	 * @param error
	 * @param logout
	 * @return String
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if(error != null)
			model.addAttribute("error", "Votre email et/ou votre mot de passe est invalide.");
		
		if(logout != null)
			model.addAttribute("message", "Vous avez bien été déconnecté.");
		
		return "login";
	}
}
