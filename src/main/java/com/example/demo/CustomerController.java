package com.example.demo;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {
	
	private static Map<Integer, Customer> customers = new HashMap<>();
	
	//initialize customers mapping
	
	static {
		
		Customer nick = new Customer();
		nick.setName("Nick"); 
	    LocalDate d = LocalDate.of(1990, 10, 01);
		nick.setDob(d); 
		nick.setEmail("nick@gmail.com"); nick.setId(1234);
		customers.put(nick.getId(), nick);
		
		
		Customer sally = new Customer();
		sally.setName("Sally");
		LocalDate d1 = LocalDate.of(2000, 10, 01);
		sally.setDob(d1);
		sally.setEmail("sally@gmail.com");
		sally.setId(9876);
		customers.put(sally.getId(), sally);
		
	}
	
	
	//utilize response entity 
	
	@GetMapping("/getCustomers")
	public ResponseEntity<Object> getCustomers(){
		return new ResponseEntity<>(customers.values(), HttpStatus.OK);
	}
	
	@PostMapping("/postCustomer/{id}")
	public ResponseEntity<Object> postCustomer(@PathVariable("id") Integer id, @RequestBody Customer customer){
		customers.put(id, customer);
		System.out.println(customer.getName());
		return new ResponseEntity<>("Successfully posted customer", HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable("id") Integer id){
		customers.remove(id);
		return new ResponseEntity<>("Customer was successfully deleted", HttpStatus.OK);
	}
	
	
	
	

}
