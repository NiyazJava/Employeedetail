package com.app.Employeedetail.dao;

import java.util.HashMap;

import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.Employeedetail.enteties.Employee;

public class EmployeeDaoImpl implements  EmployeeDao
{
	
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	
 public void saveEmployee(Employee emp) 
 {
	
	HashMap<Integer, Employee> hp = new HashMap();
	
	Session session = this.sessionFactory.getCurrentSession();
	
	hp.put(1, new Employee());
	
	session.persist(emp);
	
}

	public void updatEmployee(Employee emp) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		
		session.update(emp);	
		
		
	}

	public void deleteEmployee(Employee emp) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Employee emp1 = (Employee) session.load(Employee.class, new Integer(1));
		if(null != emp1){
			session.delete(emp1);
		}
	}
	
	


}
