package myapp;

import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Person implements HttpSessionBindingListener{
	private long id;
    private String name;
    private String firstName;
    private String birthday;
    private String mail;
    private Group group;
    public Person() {
    	Group group = new Group("Test",0);
    	initPerson(1,"Nicolas","a","00/00/0000","Nicolas@gmail.com",group);
    }
    public Person(String name, Date birhtday) {
    	Group group = new Group("Test",0);
    	initPerson(1,name,name,birthday,name, group);
    }
    public void initPerson(int id, String name, String firstName, String birthday, String mail, Group group ) {
    	this.id = id;
    	this.name = name;
    	this.firstName = firstName;
    	this.birthday = birthday;
    	this.mail = mail;
    	this.group = group;
    }
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
    
	@Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("-- HttpSessionBindingListener#valueBound() --");
        System.out.printf("added attribute name: %s, value:%s %n",
                event.getName()," ",this.getFirstName()," ",this.getId());
    }

    @Override	
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("-- HttpSessionBindingEvent#valueUnbound() --");
        System.out.printf("removed attribute name: %s, value:%s %n",
        		event.getName()," ",this.getFirstName()," ",this.getId());
    }
    public void show() {
    	System.out.println(this.getId() +" "+ this.getFirstName()+" " + this.getBirthday() +" "+ this.getMail());
    }
    	
}
