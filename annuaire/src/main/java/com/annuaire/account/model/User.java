package com.annuaire.account.model;


import javax.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
	private String firstName;
	private String lastName;
	private String mail;
	private String site;
	private String birthday;
    private Set<Role> roles;
    //private Set<Person> person;
    public User() {
    	super();
    }
    public User(String string, String string2) {
		this.firstName = string;
		this.mail = string2;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }


	/*public Set<Person> getPerson() {
		return person;
	}
	@ManyToMany
    @JoinTable(name = "user_person", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
	public void setPerson(Set<Person> person) {
		this.person = person;
	}*/

	@ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
