package myapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name = "Person")
public class Person implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id()
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   @Basic(optional = false)
   @Column(name = "first_name", length = 200,
      nullable = false, unique = true)
   private String firstName;

   @Basic(optional = false)
   @Column(name = "last_name", length = 200,
      nullable = false, unique = true)
   private String lastName;

   @Basic(optional = false)
   @Column(name = "mail", length = 200,
      nullable = false, unique = true)
   private String mail;
   
   @Basic(optional = false)
   @Column(name = "site", length = 200,
      nullable = false, unique = true)
   private String site;
   
   @Basic(optional = false)
   @Column(name = "birthday", length = 200,
      nullable = false, unique = true)
   private String birthday;
   
   @Basic(optional = false)
   @Column(name = "pwd", length = 200,
      nullable = false, unique = true)
   private String pwd;
   
   @Version()
   private long version = 0;

   @Transient
   public static long updateCounter = 0;

   public Person() {
      super();
   }

   public Person(String firstName, String birthday) {
      super();
      this.firstName = firstName;
      this.birthday = birthday;
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
      return "Person(id=" + getId() + "," + firstName + "," + birthday + ","
            + ",v" + getVersion() + ")";
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getBirthDay() {
      return birthday;
   }

   public void setBirthDay(String birthDay) {
      this.birthday = birthDay;
   }

   public long getVersion() {
      return version;
   }

   public void setVersion(long version) {
      this.version = version;
   }

}