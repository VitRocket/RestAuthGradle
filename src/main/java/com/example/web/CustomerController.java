package com.example.web;

import com.example.dao.CustomerRepository;
import com.example.domain.Customer;
import com.example.publisher.RabbitPublisher;
import com.example.web.dto.CustomerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Vitalii on 20.08.18.
 */
@RestController
@RequestMapping("api")
public class CustomerController {

	private final CustomerRepository repository;
	private final RabbitPublisher publisher;

	@Autowired
	public CustomerController(CustomerRepository repository, RabbitPublisher publisher) {
		this.repository = repository;
		this.publisher = publisher;
	}

	@GetMapping("customer")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> customers = repository.findAll();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@PostMapping("customer")
	public ResponseEntity<String> addCustomer(@RequestBody CustomerDto customerDto) {
		ModelMapper modelMapper = new ModelMapper();
		Customer customer = modelMapper.map(customerDto, Customer.class);
		repository.save(customer);

		publisher.produceMsg("customer created, id: " + customer.getId());

		return new ResponseEntity<>(customer.getId(), HttpStatus.CREATED);
	}

}