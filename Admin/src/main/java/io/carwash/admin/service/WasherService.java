package io.carwash.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.carwash.admin.model.Admin;
import io.carwash.admin.model.Washer;
import io.carwash.admin.repository.WasherRepo;

@Service
public class WasherService {

	
	@Autowired
	WasherRepo washerRepo;
	
	 //Create operation
    public Washer create(Washer washer) {
        return washerRepo.save(washer);
    }
    
  //Retrieve operation
    public List<Washer> getAll(){
        return washerRepo.findAll();
    }
    
    public Washer getByEmail(String email)
    {
        return washerRepo.findByEmail(email);
    }
    
    //Delete operation
    public void deleteAll()
    {
    	washerRepo.deleteAll();
    }

    public void delete(String email) {
        Washer p = washerRepo.findByEmail(email);
        washerRepo.delete(p);
    }
}
