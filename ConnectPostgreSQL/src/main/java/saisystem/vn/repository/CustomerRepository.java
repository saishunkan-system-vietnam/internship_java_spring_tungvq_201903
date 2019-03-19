package saisystem.vn.repository;

import org.springframework.data.repository.CrudRepository;

import saisystem.vn.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
