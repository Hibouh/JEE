package myapp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity(name = "Group")
@Table(name = "TGroup",
uniqueConstraints = {
		   @UniqueConstraint(columnNames = {
		      "id"
		   })
		})
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Basic(optional = false)
	@Column(name = "name", length = 200,
	nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy="group",cascade=CascadeType.ALL)
	private Set<Person> persons = new HashSet<Person>();
	  
	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getUpdateCounter() {
		return updateCounter;
	}

	public static void setUpdateCounter(long updateCounter) {
		Group.updateCounter = updateCounter;
	}

	@Version()
	private long version = 0;

	@Transient
	public static long updateCounter = 0;	
	
	public Group() {
		super();
	}

	@PreUpdate
	public void beforeUpdate() {
		System.err.println("PreUpdate of " + this);
	}

	@PostUpdate
	public void afterUpdate() {
		System.err.println("PostUpdate of " + this);
		updateCounter++;
	}
	@Override
	public String toString() {
		return "Person(id=" + getId()+ ")";
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}