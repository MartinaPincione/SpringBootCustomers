package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	List<Customer> findByName(String name);
	//comes with all methods is findAll, findById, etc...

	//this is causing BUG --> why?
	//void deletebyName(String name);
}
