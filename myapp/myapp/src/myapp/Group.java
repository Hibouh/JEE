package myapp;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Group implements HttpSessionBindingListener {
	private String name;
	private long id;
	
	public Group() {
		super();
	}
	public Group(String name, long id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("-- HttpSessionBindingListener#valueBound() --");
        System.out.printf("added attribute name: %s, value:%s %n",
                event.getName()," ",this.getName()," ",this.getId());
    }

    @Override	
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("-- HttpSessionBindingEvent#valueUnbound() --");
        System.out.printf("removed attribute name: %s, value:%s %n",
        		event.getName()," ",this.getName()," ",this.getId());
    }
    public void show() {
    	System.out.println(this.getId() +" "+ this.getId()+" " + this.getName());
    }
}
