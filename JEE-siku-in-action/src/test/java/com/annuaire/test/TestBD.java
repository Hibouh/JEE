package com.annuaire.test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Calendar;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = SpringConfiguration.class)
public class TestBD {

	  // @Autowired
	   //JdbcGroupPersonDao dao;

	   @Test
	   public void testVide() {
	   }
	  /* @Test
	   public void testAddPerson() {
		   Calendar date = Calendar.getInstance();
		   Person p = new Person();
		   dao.savePerson(p);
		   assertEquals("Dan",p.getFirstname());
	   }*/
	   
	   
	   
	   
	  /* @Test
	   public void testFindPerson() {
		   Calendar date = Calendar.getInstance();
		   Person p1 = new Person();
		   p1 = dao.savePerson(p1);
		   Person p = dao.findPerson(p1.getId());
		   assertEquals("Dan",p.getFirstname());
		   dao.removePerson(p1.getId());
	   }

	   @Test
	   public void testUpdatePerson() {
		   String string = "Marie";
		   Calendar date = Calendar.getInstance();
		   Person pers = new Person ();
		   pers = dao.savePerson(pers);
		   pers = dao.findPerson(pers.getId());
		   pers.setFirstname(string);
		  //pers.setBirthdate();
		   pers = dao.updatePerson(pers);
		   assertEquals(string,pers.getFirstname());
		   dao.removePerson(pers.getId());
	   }
	   
	   @Test
	   public void testRemovePerson() {
		   long id;
		   Calendar date = Calendar.getInstance();
		   Person p = new Person ();
		   p = dao.savePerson(p);
		   id =p.getId();
		   dao.removePerson(id);
		   assertEquals(dao.findPerson(id),null);
	   }
	   

	   
	   @Test
	   public void namePerson() {
		   Calendar date = Calendar.getInstance();
		   Person p0 = new Person();
		   Person p = new Person();
		   dao.savePerson(p);
		   dao.savePerson(p0);
		   String pattern = "%T";
		   List<Person> list = dao.namePerson(pattern);
		   assertEquals(list.size(), 1);
		   dao.removePerson(p.getId());
		   dao.removePerson(p0.getId());
	   }
	   
	   @Test
	   public void testAddGroup() {
		   Group g = new Group();
		   g.setName("Test");
		   assertEquals("Test",g.getName());
	   }
	   
	   @Test
	   public void testFindGroup() {
		   Group g = new Group();
		   g.setName("Test");
		   g = dao.addGroup(g);
		   Group res = dao.findGroup(g.getId());
		   assertEquals(g.getId(),res.getId());
	   }
	   
	   @Test
	   public void testUpdateGroup() {
		   String test = "test1";
		   Group g = new Group();
		   g.setName("Test");
		   g = dao.addGroup(g);
		   g = dao.findGroup(g.getId());
		   g.setName(test);
		   g = dao.updateGroup(g);
		   assertEquals(test,g.getName());
	   }
	   
	   @Test 
	   public void testRemoveGroup() {
		   long id;
		   Group g = new Group();
		   g.setName("Test");
		   g = dao.addGroup(g);
		   id = g.getId();
		   dao.removeGroup(id);
		   assertEquals(dao.findGroup(id),null);
	   }*/
	   
}
