package myapp.dao;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import myapp.model.Person;

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

   @Ignore
   @Test
   public void testAddPerson2() {
	   Calendar date = Calendar.getInstance();
	   Person p1 = new Person("Dan",date.getTime());
	   Person p2 = new Person("Dan",date.getTime());
	   Person res1 = dao.addPerson(p1);
	   Person res2 = dao.addPerson(p2);
	   //assertEquals("Dan",p1.getFirstName());
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
   @Ignore
   @Test
   public void testUpdatePerson() {
	   String string = "Nicolas";
	   Calendar date = Calendar.getInstance();
	   Person pers = new Person("Nicola", date.getTime());
	   dao.addPerson(pers);
	   pers.setFirstName(string);
	   Person p = dao.updatePerson(pers);
	   assertEquals(string,p.getFirstName());
   }
   @Test
   public void testUpdatePerson2() {
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
   
   @Ignore
   @Test
   public void testConstraintUnique() {
	   Calendar date = Calendar.getInstance();
	   Person p = new Person("Chantal",date.getTime());
	   Person p2 = new Person("Chantal",date.getTime());
	   dao.addPerson(p);
	   dao.addPerson(p2);
	   p2 = dao.findPerson(p2.getId());
	   assertEquals(p2, null);
	   dao.removePerson(p.getId());
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
   public void TestchangeFirstName() {
	   int nbThread = 2;
	   String name = "Pierre";
	   Calendar date = Calendar.getInstance();
	   Person pers = new Person ("Sasha",date.getTime());
	   pers = dao.addPerson(pers);
	   long id = pers.getId();
	   
	   Thread [] t = new Thread[nbThread];
	   for(int i = 0; i < 2 ; i++) {
		   	t[i] = new Thread(()->dao.changerFirstName(id,name));
	   		t[i].start();
	   }
	   
	   for(int i=0; i<nbThread; i++){
           try{ t[i].join(); } catch(InterruptedException e){e.printStackTrace();}
       }

   }
}