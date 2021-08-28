package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.AuthenticationRequest;
import com.customer.model.AuthenticationResponse;
import com.customer.model.Customer;
import com.customer.repository.CustomerRepo;
import com.customer.services.customerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
		@Autowired
	    private customerService customerService;
		
		@Autowired
		CustomerRepo customerRepo;
		
		/*@Autowired
	    private AuthenticationManager authenticationManager;*/

		
		 
		 @GetMapping("/test")
		    public String test() {
			 return "testing";
		    }
		 
		 @RequestMapping("/create")
		    public String create(@RequestBody Customer customer) {
		        Customer p = customerService.create(customer);
		        return p.toString();
		    }
		 
		 @RequestMapping("/update")
		    public String update(@RequestParam String Name, @RequestParam String password,@RequestParam String email,@RequestParam String contact) {
		        Customer p = customerService.update(Name, password,email,contact);
		        return p.toString();
		 }
		
		 
		 @RequestMapping("/getAll")
		    public List<Customer> getAll(){
		        return customerService.getAll();
		   }
		 
		 @RequestMapping("/deleteAll")
		    public void deteleall(){
		       customerService.deleteAll();
		   }
		
		 @RequestMapping("/delete")
		    public void deteleone(@RequestParam String email){
		       customerService.delete(email);
		   }
		 
		/* @PostMapping("/authenticate")
		    private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		        String email=authenticationRequest.getEmail();

		        try {
		            authenticationManager.authenticate(
		                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
		        }catch (Exception e){
		            return ResponseEntity.ok(new AuthenticationResponse("Invalid Username or Password")) ;
		        }
		        UserDetails loadedUser=customerService.loadUserByUsername(email);
		        String generatedToken =jwtUtil.generateToken(loadedUser);
		        return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
		    }*/
		 
		

}
