package saisystem.vn.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import saisystem.vn.mongodb.entities.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{

}
