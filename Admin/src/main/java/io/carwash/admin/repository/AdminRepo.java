package io.carwash.admin.repository;


import io.carwash.admin.model.Admin;
import io.carwash.admin.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepo extends MongoRepository<Admin, String>{
    public Admin findByEmail(String Email);
}

