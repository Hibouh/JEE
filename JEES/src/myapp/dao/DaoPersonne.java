package myapp.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import myapp.model.Group;
import myapp.model.Person;

public class DaoPersonne implements IPersonDao{

   private EntityManagerFactory factory = null;

   public void init() {
      factory = Persistence.createEntityManagerFactory("myBase");
   }

   public void close() {
      if (factory != null) {
         factory.close();
      }
   }
   
   @PersistenceContext(type = PersistenceContextType.TRANSACTION)
   EntityManager em;
	/**************************** Group ****************************************/
  
	public Group addGroup(Group g) {
       em.persist(g);
       System.err.println("addGroup witdh id=" + g.getId());
       return (g);
   }
   
	public Group findGroup(long id) {
		Group g;
		g = em.find(Group.class, id);
		return g;
	}
	
	public Group updateGroup(Group g) {
		g = em.merge(g);
		System.err.println("updateGroup witdh id=" + g.getId());
		return g;
	}
	
	public Group removeGroup(long id) {
		Group g;
		g = em.find(Group.class, id);
		em.remove(g);
		System.err.println("removeGroup witdh id=" + g.getId());
		return g;
	}
	
	@Override
	public Collection<Group> findAllGroups(){
   	String query = "SELECT g FROM Group g";
       TypedQuery<Group> q = em.createQuery(query, Group.class);
       return q.getResultList();
	}
	
	@Override
	public void saveGroup(Group g) {
		if(findGroup(g.getId()) == null)
			updateGroup(g);
		else
			addGroup(g);
		
	}

   /**************************** Person ***************************************/
   public Person addPerson(Person p) {
       em.persist(p);
       System.err.println("addPerson witdh id=" + p.getId());
       return (p);
   }
   
   public Person updatePerson(Person p) {
   	p = em.merge(p);
   	System.err.println("updatePerson witdh id=" + p.getId());
   	return p;
   }

   public Person removePerson(long id) {
   	Person p;
   	p = em.find(Person.class,  id);
   	em.remove(p);
   	System.err.println("removePerson witdh id=" + p.getId());
   	return p;
   }

   public synchronized void changerFirstName(long id, String name) {
	   String string = "Marie";
	   Person pers = new Person ("Nicola","Test");
	   pers = findPerson(id);
	   pers.setFirstName(name);
	   pers = updatePerson(pers);
 	   
    	//System.err.println("changerFirstNamePerson witdh id=" + p.getId());
    }
   public List<Person> namePerson(String firstName){
   	TypedQuery<Person> query = em.createQuery(
               "SELECT p FROM Person p WHERE p.firstName LIKE :firstName", Person.class);
           return query.setParameter("firstName", firstName).getResultList();
   }
   
   @Override
   public  Collection<Person> findAllPersons(long groupId){
   	String query = "SELECT p FROM Person p where group = groupId";
       TypedQuery<Person> q = em.createQuery(query, Person.class);
       return q.getResultList();
   }
   
	@Override
	public void savePerson(Person p) {
		if(findPerson(p.getId()) == null )
			updatePerson(p);
		else
			addPerson(p);
	}
	
   @Override
   public Person findPerson(long id) {
   	Person p;
   	p = em.find(Person.class,id);
   	return p;
   }

}