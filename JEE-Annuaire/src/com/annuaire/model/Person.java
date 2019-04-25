package com.annuaire.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity(name = "Person")
@Table(name = "TPerson", uniqueConstraints = { @UniqueConstraint(columnNames = { "first_name", "birth_day" }) })
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Basic(optional = false)
	@Column(name = "first_name", length = 200, nullable = false, unique = false)
	private String firstName;

	@Basic(optional = false)
	@Column(name = "last_name", length = 200, nullable = false, unique = false)
	private String lastName;

	@Basic(optional = false)
	@Column(name = "mail", length = 200, nullable = false, unique = false)
	private String mail;

	@Basic(optional = false)
	@Column(name = "pwd", length = 200, nullable = false, unique = false)
	private String pwd;

	@Basic(optional = false)
	@Column(name = "site", length = 200, nullable = false, unique = false)
	private String site;

	@Basic()
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_day")
	private Date birthDay;

	@ManyToOne(cascade = CascadeType.ALL)
	private Group group;

	@Version()
	private long version = 0;

	@Transient
	public static long updateCounter = 0;

	public Person() {
		super();
	}

	public Person(String firstName, Date date) {
		super();
		this.firstName = firstName;
		this.birthDay = date;
		this.pwd = "pwd";
		this.mail = "mail";
		this.lastName = "lastName";
		this.site = "site";
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
		return "Person(id=" + getId() + "," + firstName + "," + birthDay + "," + ",v" + getVersion() + ")";
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}