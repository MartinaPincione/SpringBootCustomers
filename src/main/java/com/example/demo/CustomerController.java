package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.CustomerRepository;


@RestController
public class CustomerController {
	
	private final CustomerRepository customerRepo;
	
	
	public CustomerController(CustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	@GetMapping("/getCustomers")
	public ResponseEntity<Object> getCustomers(){
		return new ResponseEntity<>(customerRepo.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/postCustomer")
	public ResponseEntity<Object> postCustomer(@RequestBody Customer customer){
		customerRepo.save(customer);
		System.out.println(customer.getName());
		return new ResponseEntity<>("Successfully posted customer", HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable("id") Long id){
		customerRepo.deleteById(id);
		return new ResponseEntity<>("Customer was successfully deleted", HttpStatus.OK);
	}
	

}
