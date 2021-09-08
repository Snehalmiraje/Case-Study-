package io.carwash.admin.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.carwash.admin.model.Admin;
import io.carwash.admin.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AdminService implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepo;

    //Create operation
    public Admin create(Admin customer) {
        return adminRepo.save(customer);
    }
    
    //Retrieve operation
    public List<Admin> getAll(){
        return adminRepo.findAll();
    }

    public Admin getByEmail(String email)
    {
        return adminRepo.findByEmail(email);
    }

    //Update operation
    public Admin update(String Name, String password,String email,String contact) {
        Admin p = adminRepo.findByEmail(email);
        p.setName(Name);
        p.setPassword(password);
        p.setEmail(email);
        p.setContact(contact);
        return adminRepo.save(p);
    }

    //Delete operation
    public void deleteAll()
    {
        adminRepo.deleteAll();
    }

    public void delete(String email) {
        Admin p = adminRepo.findByEmail(email);
        adminRepo.delete(p);
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin p=adminRepo.findByEmail(email);
        if(p == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("customer"));
        return new User(p.getEmail(),p.getPassword(),authorities);
    }
}