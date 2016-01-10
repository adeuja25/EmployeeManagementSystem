package com.home.practice.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.practice.domain.Employee;
import com.home.practice.repositoryInterface.EmployeeRepository;
import com.home.practice.repositoryInterface.EmployeeRepository2;
import com.home.practice.serviceInterface.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	/*
	 * @Autowired EmployeeRepository empRepo;
	 */
	@Autowired
	EmployeeRepository2 empRepo2;
	public void add(Employee emp) {
		// TODO Auto-generated method stub
		// empRepo.save(emp);
		empRepo2.add(emp);

	}

	public void edit(Employee emp) {
		// TODO Auto-generated method stub

	}

	public void delete(int empId) {
		// TODO Auto-generated method stub
		//empRepo.delete(empId);
	}

	public Employee getEmployee(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		// return (List<Employee>) empRepo.findAll();
		return (empRepo2.getAllEmployee());
	}

	public Employee validateMember(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkUsername(String name) {
		return (empRepo2.checkUsername(name)!=null);
	}

	public String encryptPass(String password) {
		BCryptPasswordEncoder pass1 = new BCryptPasswordEncoder();
		return pass1.encode(password);
	}

	public boolean checkPassword(String password, String encodedPassword) {
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		return passEncoder.matches(password, encodedPassword);
	}

	public List<Employee> getAllEmployee(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		//return (empRepo.getEmployeeByEmail(email) != null);
		return (empRepo2.checkEmail(email)!=null);
	}

}
