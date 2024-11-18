package com.tka.ProjectDemo3.Dao;

import java.util.List;
import java.util.Objects;

import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.ProjectDemo3.entity.Country;
import com.tka.ProjectDemo3.entity.Employee;



@Repository
public class MainDao {
	@Autowired
	SessionFactory factory;


	public String addCountry(Country c) {

		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {

			session=factory.openSession();
			tx=session.beginTransaction();

			session.persist(c);
			tx.commit();
			msg="Data added successfully...";



		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}


	public String updateCountry(Country c) {

		Session session=null;
		Transaction tx=null;
		String msg=null;

		try {
			session=factory.openSession();
			tx=session.beginTransaction();

			Country country =session.get(Country.class, c.getCid());
			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			msg="Data is updated..";

		}catch(Exception e2) {
			if(tx!=null) {
				tx.rollback();

			}
			e2.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}


	public String deleteCountry(int id) {

		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {		
			session= factory.openSession();
			tx=session.beginTransaction();
			Country country	 = session.get(Country.class, id);

			session.remove(country);
			tx.commit();

			msg="Record is Deleted";
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}

			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}

		return msg;


	}

	public Country getParticularCountryByID(int id) {

		Session session=null;
		Transaction tx=null;
		Country country=null;
		try {		
			session= factory.openSession();
			tx=session.beginTransaction();
			country= session.get(Country.class, id);
			tx.commit();		 

		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}

			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}



		return country;
	}



	public List<Country> getAllCountry() {
		Session session=null;
		Transaction tx=null;
		String strQuery="from Country";
		List<Country> list=null;
		try {		
			session= factory.openSession();
			tx=session.beginTransaction();

			Query<Country> query= session.createQuery(strQuery,Country.class);

			list=query.list();
			tx.commit();


		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}

			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}


		return list;
	}


	public String addEmployee(Employee e) {
		Session session=null;
		Transaction tx=null;
		String msg=null;

		try {
			session=factory.openSession();
			tx=session.beginTransaction();

			session.persist(e);
			tx.commit();
			msg="Record is added..";

		}catch(Exception e2) {
			if(tx!=null) {
				tx.rollback();
			}
			e2.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}


	public String updateEmployee(Employee e) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Employee emp=session.get(Employee.class, e.getId());

			emp.setName(e.getName());
			emp.setPhoneno(e.getPhoneno());
			emp.setCountry(e.getCountry());
			emp.setCreatedby(e.getCreatedby());
			emp.setCreateddtm(e.getCreateddtm());
			emp.setDepeartment(e.getDepeartment());
			emp.setStatus(e.getStatus());
			emp.setUpdatedby(e.getUpdatedby());
			emp.setUpdateddtm(e.getUpdateddtm());

			session.merge(emp);	


			tx.commit();
			msg="Record is updated";



		}catch(Exception e3) {
			if(tx!=null) {
				tx.rollback();
			}
			e3.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}


	public String deleteEmployee(int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;

		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Employee employee=	session.get(Employee.class, id);
			session.remove(employee);
			tx.commit();
			msg="Data is deleted successfully..";
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}


	public Employee getParticularEmployeeByID(int id) {
		Session session=null;
		Transaction tx=null;
		Employee employee=null;

		try {
			session=factory.openSession();
			tx=session.beginTransaction();

			employee=session.get(Employee.class, id);
			tx.commit();

		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return employee;
	}


	public List<Employee> getAllEmp() {
		Session session=null;
		Transaction tx=null;
		String strQuery="from Employee";
		List<Employee> list=null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();

			Query<Employee> query=	session.createQuery(strQuery,Employee.class);
			list=  query.list();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}


	public List<Employee> getAllEmpStatus(String status) {
		Session session=null;
		Transaction tx=null;
		String strQuery="from Employee where status=:mystatus";
		List<Employee> list=null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();

			Query<Employee> query=	session.createQuery(strQuery,Employee.class);
			query.setParameter("mystatus", status);

			list=query.list();
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}


	public Employee checkuser(Employee emp) {
		Session session =null;
		Transaction tx=null;
		String strQuery="from Employee where name=:name and phoneno=:phoneno";
		Employee employee=null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();

			Query<Employee> query=	session.createQuery(strQuery,Employee.class);

			query.setParameter("name", emp.getName());
			query.setParameter("phoneno", emp.getPhoneno());
			employee=query.uniqueResult();
			tx.commit();
		}catch(Exception e){
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();

		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return employee;
	}


	
	public User loginUser(User user) {

		Session session=null;
		Transaction tx=null;
		String strQuery="from User where username=:username and password=:password";
		User u=null;
		try {		
			 session= factory.openSession();
			 tx=session.beginTransaction();

			 Query<User> query= session.createQuery(strQuery,User.class);

			 query.setParameter("username",user.getUsername() );
			 query.setParameter("password", user.getPassword());

			 u= query.uniqueResult();

			 tx.commit();

		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}

			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}

		return u;

	}


	public String adduser(User u) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {

			session=factory.openSession();
			tx=session.beginTransaction();

			session.persist(u);
			tx.commit();
			msg="Data added successfully...";



		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	}
		