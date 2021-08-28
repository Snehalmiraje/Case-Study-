package com.customer.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepo;

@Service
public class customerService  /*implements UserDetailsService*/ {

	 	@Autowired
	    private CustomerRepo customerRepo;

	    //Create operation
	    public Customer create(Customer customer) {
	        return customerRepo.save(customer);
	    }
	    
	    
	    //Retrieve operation
	    public List<Customer> getAll(){
	        return customerRepo.findAll();
	    }

	    
	    public Customer getByEmail(String email)
	    {
	        return customerRepo.findByEmail(email);
	    }

	    
	    //Update operation
	    public Customer update(String Name, String password,String email,String contact) {
	        Customer p = customerRepo.findByEmail(email);
	        p.setName(Name);
	        p.setPassword(password);
	        p.setEmail(email);
	        p.setContact(contact);
	        return customerRepo.save(p);
	    }

	    
	    //Delete operation
	    public void deleteAll()
	    {
	        customerRepo.deleteAll();
	    }

	    
	    public void delete(String email) {
	        Customer p = customerRepo.findByEmail(email);
	        customerRepo.delete(p);
	    }
	    
	   // @Override
	   /* public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        Customer p=customerRepo.findByEmail(email);
	        if(p == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("customer"));
	        return new User(p.getEmail(),p.getPassword(),authorities);
	    }*/
	

}
