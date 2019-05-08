package com.annuaire.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
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
public class LogoutController {
    /**
     * Request method POST with requestmapping value = logout
     * @param request entity request
     * @param response entity response
     * @return name of jsp page
     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
}
