package com.annuaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * @author LE Dan
 *
 */
@Controller
public class LoginController {
    /**
	 * Request method GET with requestmapping value = registration
	 * @param model entity use in jsp page
	 * @param error entity use for error
	 * @param logout entity use for error
	 * @return name of jsp page
	 */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
}
