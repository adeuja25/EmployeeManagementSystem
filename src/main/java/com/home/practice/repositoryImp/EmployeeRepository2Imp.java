package com.home.practice.repositoryImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.practice.domain.Employee;
import com.home.practice.repositoryInterface.EmployeeRepository2;

@Repository
public class EmployeeRepository2Imp implements EmployeeRepository2 {
	
	@Autowired
	private SessionFactory sessionFactory;

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Integer arg0) {
		// TODO Auto-generated method stub

	}

	public void delete(Employee arg0) {
		// TODO Auto-generated method stub

	}

	public void delete(Iterable<? extends Employee> arg0) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Employee> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Employee> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Employee> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee getEmployeerByUsername(String name) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().createQuery("from Employee e where e.name=:name");
		query.setParameter("name", name);
		return (Employee)query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {
		Query query=sessionFactory.getCurrentSession().createQuery("from Employee");
		return query.list();
	}

	public Employee checkEmail(String email) {
		//Query query=sessionFactory.getCurrentSession().createQuery("from employee e where e.email=:email");
		//query.setParameter("email", email);
		
		Query query=sessionFactory.getCurrentSession().createQuery("from Employee where email = :email");
		   query.setParameter("email", email);
		  return (Employee) query.uniqueResult();
		
	}

	public Employee checkUsername(String username) {
		// TODO Auto-generated method stub
			Query query=sessionFactory.getCurrentSession().createQuery("from Employee e where e.name=:name");
			query.setParameter("name", username);
			System.out.println(query.uniqueResult());
			return((Employee)query.uniqueResult());
		
	}
	public void add(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
	}

}
