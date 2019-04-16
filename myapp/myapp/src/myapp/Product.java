package myapp;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Product implements HttpSessionBindingListener{ 
    String name;
    String price;
    String desc;
    public Product() {
    	System.out.println("name : " + name +" price : "+ price+" desc : " + desc);
    }
    public String getName() { return name; }
    public String getPrice() { return price; }
    public String getDesc() { return desc; }
    public void setName(String name) { this.name = name; }
    public void setPrice(String price) { this.price = price; }
    public void setDesc(String desc) { this.desc = desc; } 
    
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("-- HttpSessionBindingListener#valueBound() --");
        System.out.printf("added attribute name: %s, value:%s %n",
                event.getName(), event.getValue());
    }

    @Override	
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("-- HttpSessionBindingEvent#valueUnbound() --");
        System.out.printf("removed attribute name: %s, value:%s %n",
                event.getName(), event.getValue());
    }
}