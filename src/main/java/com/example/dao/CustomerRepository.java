package com.example.dao;

import com.example.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Vitalii on 21.08.18.
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

	Customer findByFirstName(String firstName);
	List<Customer> findByLastName(String lastName);

}
