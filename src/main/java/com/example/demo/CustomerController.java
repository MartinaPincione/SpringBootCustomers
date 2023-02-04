package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.CustomerRepository;


@RestController
public class CustomerController {
	
	@Autowired
	private final CustomerRepository customerRepo; //dependency injection
	
	
	
	public CustomerController(CustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	@GetMapping("/getCustomers")
	public ResponseEntity<Object> getCustomers(){
		return new ResponseEntity<>(customerRepo.findAll(), HttpStatus.OK);
	}
	
	//Implement PutMapping here
	@PostMapping("/postCustomer")
	public ResponseEntity<Object> postCustomer(@RequestBody Customer customer){
		if(!customerRepo.findByName(customer.getName()).isEmpty()) {
			return new ResponseEntity<>("This customer id already exists", HttpStatus.NOT_ACCEPTABLE);
		} 
		else {
			customerRepo.save(customer);
			return new ResponseEntity<Object>("Successfully put customer", HttpStatus.OK);
		}
	}
	
	@PutMapping("/putCustomer")
	public ResponseEntity<Object> putCustomer(@RequestBody Customer customer){
		if (customerRepo.findByName(customer.getName()).isEmpty()) {
			customerRepo.save(customer);
			return new ResponseEntity<>("Successfully posted customer", HttpStatus.CREATED);
		} 
		else {
			List<Customer> original = customerRepo.findByName(customer.getName());
			((Customer) original).setDob(customer.getDob());
			((Customer) original).setEmail(customer.getEmail());
			return new ResponseEntity<>("Successfully updated customer "+customer.getName(), HttpStatus.ACCEPTED);		
		}
		
		
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<Object> deleteCustomerById(@PathVariable("id") Long id){
		customerRepo.deleteById(id);
		return new ResponseEntity<>("Customer was successfully deleted", HttpStatus.OK);
	}
	

}
