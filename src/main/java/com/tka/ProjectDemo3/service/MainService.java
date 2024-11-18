package com.tka.ProjectDemo3.service;

import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.ProjectDemo3.Dao.MainDao;
import com.tka.ProjectDemo3.entity.Country;
import com.tka.ProjectDemo3.entity.Employee;

@Service
public class MainService {
	@Autowired
	MainDao dao;
	public String addCountry(Country c) {
		String msg=	dao.addCountry(c);

		if(Objects.isNull(msg)) {
			msg="Data is not added successfully..";

		}
		return msg;
	}
	public String updateCountry(Country c) {
		String msg=	dao.updateCountry(c);
		if(Objects.isNull(msg)) {
			msg="Data is not updated..";
		}
		return msg;
	}

	public String deleteCountry(int id) {
		String msg= dao.deleteCountry(id);

		if(Objects.isNull(msg)) {
			msg="Record is not be Deleted...";
		}

		return msg;
	}
	public Country getParticularCountryByID(int id) {

		Country con=dao.getParticularCountryByID(id);

		if(Objects.isNull(con)) {
			con=null;
		}

		return con;
	}

	public List<Country> getAllCountry() {
		List<Country> list= dao.getAllCountry ();

		return list;
	}
	public String addEmployee(Employee e) {
		String msg=	dao.addEmployee(e);
		if(Objects.isNull(msg)) {
			msg="Record is not added..";
		}
		return msg;
	}
	public String updateEmployee(Employee e) {

		String msg=	dao.updateEmployee(e);
		if(Objects.isNull(msg)) {
			msg="Data is not updated..";
		}
		return msg;
	}
	public String deleteEmployee(int id) {
		String msg=	dao.deleteEmployee(id);
		if(Objects.isNull(msg)) {
			msg="Data is not deleted..";
		}
		return msg;
	}
	public Employee getparticularEmployeeById(int id) {
		Employee e=	dao.getParticularEmployeeByID(id);
		if(Objects.isNull(e)) {
			e=null;
		}
		return e;
	}
	public List<Employee> getAllEmp() {
		List<Employee>list=	dao.getAllEmp();
		return list;
	}
	public List<Employee> getAllEmpByStatus(String status) {
		List<Employee> list=	dao.getAllEmpStatus(status);
		if(Objects.isNull(list)) {
			list=null;
		}
		return list;
	}
	public HashMap checkuser(Employee emp) {

		Employee e=	dao.checkuser(emp);
		HashMap map = new HashMap();

		if(Objects.isNull(e)) {
			map.put("msg", "Invalid user");
			map.put("user", e);
		}else {
			map.put("msg", "valid user");
			map.put("user", e);
		}
		return map;

	}
	
	public HashMap loginUser(User user) {

		User e= dao.loginUser(user);
		HashMap map=new HashMap();
		if(Objects.isNull(e)) {
			map.put("msg","Invalid User");
			map.put("user", e);
		}else {
			map.put("msg","Valid User");
			map.put("user", e);
	}


		return map;
	}
	public String adduser(User u) {
	String msg=	dao.adduser(u);
	
	if(Objects.isNull(msg)) {
		msg= "user not added successfully";
		
	}
	return msg;
		
	}
	

}



