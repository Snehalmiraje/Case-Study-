package io.carwash.admin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "customer")
public class Admin implements Serializable {
    @Id
    String id;
    String Name;
    String password;
    String email;
    String contact;

    public Admin(String Name, String password, String email, String contact) {
        this.Name = Name;
        this.password = password;
        this.email = email;
        this.contact = contact;
    }

    public Admin() {
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "Name='" + Name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Admin orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
