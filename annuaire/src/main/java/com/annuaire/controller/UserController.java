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
public class UserController {
    /**
     * Request method GET with requestmapping value = example
     * @param model entity use in jsp page
     * @return name of jsp page
     */
    @RequestMapping(value = {"/example"}, method = RequestMethod.GET)
	public String example(Model model) {

		return "example";
	}

    
    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public String test(Model model) {
        return "test";
    }   
    

}
