package com.tka.ProjectDemo3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
  String username;
  String password;
  
  public User() {
	  
  }
  
  

public User(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}








public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
}




  
}