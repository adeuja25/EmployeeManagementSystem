package com.home.practice.serviceInterface;

import java.util.LinkedList;
import java.util.List;

import com.home.practice.domain.Employee;
public interface EmployeeService {
public void add(Employee emp);
public void edit(Employee emp);
public void delete(int empId);
public Employee getEmployee(int empId);
public List<Employee> getAllEmployee();
public Employee validateMember(Employee emp);
public boolean checkUsername(String username);
public String encryptPass(String password);
public boolean checkPassword(String password, String encodedPassword);
public List<Employee> getAllEmployee(String name);
public boolean checkEmail(String email);
	

}
