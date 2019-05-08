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
public class HomeController {
    /**
     * Request method GET with requestmapping value = welcome and root
     * @param model entity use in jsp page
     * @return name of jsp page
     */
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}
