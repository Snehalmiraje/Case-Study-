package io.carwash.admin.model;

public class AuthenticationRequest {
    String email;
    String Name;
    String contact;

    public AuthenticationRequest(String Name, String email, String contact) {
        this.email = email;
        this.Name = Name;
        this.contact = contact;
    }

    public AuthenticationRequest(String name, String email) {
        this.email = email;
        this.Name = Name;
    }
    public AuthenticationRequest() {

    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
