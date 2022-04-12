package com.BankApp.data.repositories;

import com.BankApp.data.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository <Customer,String>{
     
}
