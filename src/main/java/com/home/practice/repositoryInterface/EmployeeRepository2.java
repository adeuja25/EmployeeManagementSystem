package com.home.practice.repositoryInterface;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.home.practice.domain.Employee;
public interface EmployeeRepository2 extends CrudRepository<Employee, Integer>{
	Employee getEmployeerByUsername(String username);
	public List<Employee> getAllEmployee();
	public Employee checkEmail(String email);
	public Employee checkUsername(String username);
	public  void add(Employee emp);
}
