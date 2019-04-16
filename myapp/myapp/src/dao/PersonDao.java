package dao;

import java.util.Collection;

import myapp.Group;
import myapp.Person;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
@Transactional
public class PersonDao implements IPersonDao{

	@Override
	public Collection<Group> findAllGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Person> findAllPersons(long groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePerson(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGroup(Group g) {
		// TODO Auto-generated method stub
		
	}
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    EntityManager em;
	private EntityManagerFactory factory = null;

    public Person addPerson(Person p) {
        em.persist(p);
        System.err.println("addPerson witdh id=" + p.getId());
        return (p);
    }
    
    public Person findPerson(long id) {
    	Person p;
    	p = em.find(Person.class,id);
    	return p;
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
   
    public List<Person> findAllPersons(){
    	String query = "SELECT p FROM Person p";
        TypedQuery<Person> q = em.createQuery(query, Person.class);
        return q.getResultList();
    }
    
    public synchronized void changerFirstName(long id, String name) {
 	   String string = "Marie";
 	   Calendar date = Calendar.getInstance();
 	   Person pers = new Person ("Nicola",date.getTime());
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

}
