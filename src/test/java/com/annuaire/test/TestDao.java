package com.annuaire.test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.annuaire.dao.DaoPerson;
import com.annuaire.dao.SpringConfiguration;
import com.annuaire.model.Group;
import com.annuaire.model.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TestDao {

	@Autowired
	   DaoPerson dao;

	   @Test
	   public void testVide() {
	   }
	   @Test
	   public void testAddPerson() {
		   Calendar date = Calendar.getInstance();
		   Person p = new Person("Dan",date.getTime());
		   Person res = dao.addPerson(p);
		   assertEquals("Dan",p.getFirstName());
		   dao.removePerson(p.getId());
		   
	   }
	   
	   
	   
	   
	   @Test
	   public void testFindPerson() {
		   Calendar date = Calendar.getInstance();
		   Person p1 = new Person("Dan",date.getTime());
		   p1 = dao.addPerson(p1);
		   Person p = dao.findPerson(p1.getId());
		   assertEquals("Dan",p.getFirstName());
		   dao.removePerson(p1.getId());
	   }

	   @Test
	   public void testUpdatePerson() {
		   String string = "Marie";
		   Calendar date = Calendar.getInstance();
		   Person pers = new Person ("Nicola",date.getTime());
		   pers = dao.addPerson(pers);
		   pers = dao.findPerson(pers.getId());
		   pers.setFirstName(string);
		   pers.setBirthDay(date.getTime());
		   pers = dao.updatePerson(pers);
		   assertEquals(string,pers.getFirstName());
		   dao.removePerson(pers.getId());
	   }
	   
	   @Test
	   public void testRemovePerson() {
		   long id;
		   Calendar date = Calendar.getInstance();
		   Person p = new Person ("Nicola",date.getTime());
		   p = dao.addPerson(p);
		   id =p.getId();
		   dao.removePerson(id);
		   assertEquals(dao.findPerson(id),null);
	   }
	   

	   
	   @Test
	   public void namePerson() {
		   Calendar date = Calendar.getInstance();
		   Person p0 = new Person("Test",date.getTime());
		   Person p = new Person("TestBIS",date.getTime());
		   dao.addPerson(p);
		   dao.addPerson(p0);
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
	   }
	   
}
