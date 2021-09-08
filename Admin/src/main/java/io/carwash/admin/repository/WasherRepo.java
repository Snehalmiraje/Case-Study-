package io.carwash.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.carwash.admin.model.Admin;
import io.carwash.admin.model.Washer;

public interface WasherRepo  extends MongoRepository<Washer, String>{

	Washer findByEmail(String email);

	
}
