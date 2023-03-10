package com.example.demo;

import java.time.LocalDate;

public class Customer {
	String name;
	Integer id;
	String email;
	LocalDate dob;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + ", email=" + email + ", dob=" + dob + "]";
	}
	
}
