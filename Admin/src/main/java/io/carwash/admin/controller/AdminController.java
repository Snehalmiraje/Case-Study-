package io.carwash.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.carwash.admin.model.Admin;
import io.carwash.admin.model.AuthenticationRequest;
import io.carwash.admin.model.Washer;
import io.carwash.admin.repository.AdminRepo;
import io.carwash.admin.service.AdminService;
import io.carwash.admin.service.WasherService;


@RestController
@CrossOrigin(origins="*",allowedHeaders = "*")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private WasherService washerService;

    @Autowired
    private AuthenticationManager authenticationManager;

    
    @RequestMapping("/check")
    public String create() {
      
        return "test";
    }
    ////This is for retriving and modificationof customers data of all customers
    @RequestMapping("/createcustomer")
    public Admin create(@RequestBody Admin admin) {
        Admin p = adminService.create(admin);
        return p;
    }

  /*  @GetMapping("/testing")
    public RedirectView testing() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:4200/admin");
        return redirectView;
    }

    @CrossOrigin(origins="*",allowedHeaders = "*")
   @GetMapping("/test")
    public RedirectView test(){
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("http://localhost:4200/admin");
        return redirectView;
    }*/

    @CrossOrigin(origins="*",allowedHeaders = "*")
    @RequestMapping("/getcustomer")
    public Admin getAdmin(@RequestBody AuthenticationRequest authenticationRequest){
        Admin p=adminService.getByEmail(authenticationRequest.getEmail());
        return p;
    }
    @CrossOrigin(origins="*",allowedHeaders = "*")
    @RequestMapping("/getlogin")
    public String getAdmin(@RequestParam String email) {
        Admin p = adminService.getByEmail(email);
        return p.toString();
    }

    @CrossOrigin(origins="*",allowedHeaders = "*")
    @RequestMapping("/getAll")
    public List<Admin> getAll(){
        return adminService.getAll();
    }

    @CrossOrigin(origins="*",allowedHeaders = "*")
    @RequestMapping("/update")
    public String update(@RequestBody Admin req) {
        Admin p = adminService.update(req.getName(),req.getPassword(), req.getEmail(),req.getContact());
        return p.toString();
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Map<String,Boolean>> deleteCustomer(@PathVariable String email)
   
    {
    	try {
			Admin c=adminService.getByEmail(email);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		adminService.delete(email);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam String name) {
        adminService.delete(name);
        return name;
    }

    @RequestMapping ("/deleteAll")
    public String deleteAll() {
        adminService.deleteAll();
        return "Deleted all records";
    }
    ////*****************************************************************////
    //this is for retriving and modification of Washer data
    @RequestMapping("/createWasher")
    public String createW(@RequestBody Washer washer) {
    	Washer p = washerService.create(washer);
        return p.toString();
    }
    @RequestMapping("/getAllWasher")
    public List<Washer> getAllw(){
        return washerService.getAll();
    }
    @RequestMapping("/deleteWasher")
    public String deleteW(@RequestParam String name) {
    	washerService.delete(name);
        return name;
    }
    @RequestMapping ("/deleteAllWasher")
    public String deleteAllW() {
    	washerService.deleteAll();
        return "Deleted all records";
    }
    @DeleteMapping("/deletewasher/{email}")
    public ResponseEntity<Map<String,Boolean>> deletewasher(@PathVariable String email)
   
    {
    	try {
			Washer c=washerService.getByEmail(email);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
    	washerService.delete(email);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
    }
    
    

}