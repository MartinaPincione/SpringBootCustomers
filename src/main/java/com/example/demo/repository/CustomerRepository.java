package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	//comes with all methods is findAll, findById, etc...
}
