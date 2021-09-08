package io.carwash.admin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "washer")
public class Washer {
	
		@Id
	    String id;
	    String Name;
	    String email;
	    String contact;
	    
	    
		public Washer(String id, String name, String email, String contact) {
			
			this.id = id;
			this.Name = name;
			this.email = email;
			this.contact = contact;
		}
		public Washer() {
			
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
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
		@Override
		public String toString() {
			return "washer [id=" + id + ", Name=" + Name + ", email=" + email + ", contact=" + contact + "]";
		}
		


}
