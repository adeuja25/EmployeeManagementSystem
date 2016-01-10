package com.home.practice.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.home.practice.domain.Employee;
import com.home.practice.serviceInterface.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public String getUserList(Model model) {
		List<Employee> empList = employeeService.getAllEmployee();
		model.addAttribute("empList", empList);
		return "employeeList";
	}
	@RequestMapping(value = { "employee/edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("id") int empId, Model model) {
		Employee emp = employeeService.getEmployee(empId);
		model.addAttribute("buttonName", "Update");
		model.addAttribute("title", "Edit");
		model.addAttribute("member", emp);
		return "employeeregistration";
	}
}
