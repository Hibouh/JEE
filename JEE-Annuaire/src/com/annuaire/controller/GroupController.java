package com.annuaire.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.annuaire.model.Group;
import com.annuaire.service.IGroupService;


@Controller
@RequestMapping("/group")

public class GroupController {
	@Autowired
	IGroupService groupService;
	
	@RequestMapping(value = "/list")
	public ModelAndView displayListAll() {
		Collection<Group> groups = groupService.findAll();
	    ModelAndView mv = new ModelAndView("/grouplist"); 
	    mv.addObject("groups", groups);
	    
	    return mv;
	}
}
