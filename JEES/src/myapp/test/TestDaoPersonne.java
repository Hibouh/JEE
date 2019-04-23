package myapp.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import myapp.dao.DaoPersonne;
import myapp.dao.SpringConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TestDaoPersonne {
	
    @Autowired
	static
    DaoPersonne daoPersonne;

   @BeforeClass
   public static void beforeAll() {
      daoPersonne = new DaoPersonne();
      daoPersonne.init();
   }

   @AfterClass
   public static void afterAll() {
      daoPersonne.close();
   }

   @Before
   public void setUp() {
      // pour plus tard
   }

   @After
   public void tearDown() {
      // pour plus tard
   }

   @Test
   public void testVide() {
   }

}