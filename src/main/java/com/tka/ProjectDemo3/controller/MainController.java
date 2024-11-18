package com.tka.ProjectDemo3.controller;

import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.ProjectDemo3.entity.Country;
import com.tka.ProjectDemo3.entity.Employee;
import com.tka.ProjectDemo3.service.MainService;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class MainController {
	@Autowired
	MainService service;
	@PostMapping("/addcountry")
	public String addcountry(@RequestBody Country c) {
		String msg=service.addCountry(c);
		return msg;
	}

	@PutMapping("/updateco")
	public  String updateCountry(@RequestBody Country c) {
		String msg=	service.updateCountry(c);
		return msg;
	}

	@DeleteMapping("/deleteCountry/{id}")
	public String deleteCountry(@PathVariable int id) {
		String msg= service.deleteCountry(id);	
		return msg;

	}

	@GetMapping("/getparticularCountry/{id}")
	public Country getParticularCountryById(@PathVariable int id) {

		Country con= service.getParticularCountryByID(id);
		return con;
	}
	@GetMapping("/getallCountry")
	public List<Country> getAllCountry(){

		List<Country> List= service.getAllCountry();

		return List;

	}
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee e) {
		String msg=	service.addEmployee(e);
		return msg;
	}
	@PutMapping("/updateEmp")
	public String updateEmployee(@RequestBody Employee e) {
		String msg=service.updateEmployee(e);
		return msg;
	}
	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		String msg=service.deleteEmployee(id);
		return msg;
	}

	@GetMapping("/getparticularEmp/{id}")

	public Employee getparticularEmployeeById(@PathVariable int id) {
		Employee emp=	service.getparticularEmployeeById(id);
		return emp;
	}
	@GetMapping("/getallEmp")
	public List<Employee> getAllEmployee(){
		List<Employee>empList=service.getAllEmp();
		return empList;
	}

	@GetMapping("/getBystatus/{status}")
	public List<Employee> getAllEmpStatus(@PathVariable String status) {
		List<Employee> list=	service.getAllEmpByStatus(status);
		return list;
	}
	@PostMapping("/loginapi")
	public HashMap checkuser(@RequestBody Employee emp) {

		HashMap map=service.checkuser(emp);
		return map;
	}
	@PostMapping("/loginuser")
	public HashMap loginUser(@RequestBody User user) {

		HashMap map= service.loginUser(user);
		return map;

	}
	@PostMapping("/adduser")
	public String adduser(@RequestBody User u) {
		
		String msg= service.adduser(u);
		return msg;
	}
	
	

}

