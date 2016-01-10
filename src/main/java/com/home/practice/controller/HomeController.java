package com.home.practice.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.home.practice.domain.Employee;
import com.home.practice.serviceInterface.EmployeeService;
import com.home.practice.validator.EmployeeValidator;

@Controller
public class HomeController {
	/*
	 * @Autowired //@Qualifier("employeeValidator") private EmployeeValidator
	 * EmployeeValidator;
	 * 
	 * @InitBinder private void initBinder(WebDataBinder binder) {
	 * binder.setValidator(EmployeeValidator); }
	 */
	 @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	        dateFormat.setLenient(true);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }
	
	@Autowired
	private EmployeeValidator EmployeeValidator;

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome() {
		return "home";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegistrationPage(
			@ModelAttribute("formRegister") Employee emp, Model model) {
		mylist(model);
		return "employeeregistration";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView showMessage(@RequestParam(value = "name") String name) {
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", "welocme to Spring MVC");
		mv.addObject("name", name);
		return mv;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerEmployee(Model model,
			@ModelAttribute("formRegister") @Valid Employee emp,
			BindingResult result,HttpServletRequest request,RedirectAttributes attr) {
		EmployeeValidator.validate(emp, result);
		if (result.hasErrors()) {
			mylist(model);
			return "employeeregistration";
		}
		if (!employeeService.checkUsername(emp.getName())) {
			if (!employeeService.checkEmail(emp.getEmail())) {
				//emp.setDob(chageDate(request.getParameter("datepicker")));
				emp.setPassword(employeeService.encryptPass(emp.getPassword()));
				employeeService.add(emp);
				attr.addFlashAttribute("message", "welocme to Spring MVC");
				attr.addAttribute("name", emp.getName());
				return "redirect:hello";
			} else {
				System.out.println("I am here");
				model.addAttribute("errMsg", "Email already exist");
			}
		} else {
			model.addAttribute("errMsg", "UserName Already exist!");
		}
		mylist(model);
		return "employeeregistration";
	}
	private void mylist(Model model) {
		List<String> courses = new ArrayList<String>();
		courses.add("Maths");
		courses.add("Physics");
		courses.add("Geometry");
		courses.add("Algebra");
		courses.add("Painting");
		model.addAttribute("courses", courses);

		List<String> genders = new ArrayList<String>();
		genders.add("Male");
		genders.add("Female");
		model.addAttribute("genders", genders);

		List<String> roles = new ArrayList<String>();
		roles.add("Admin");
		roles.add("Anonymous");
		roles.add("Register");
		model.addAttribute("roles", roles);
		model.addAttribute("genders", genders);
	}
	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
	public String getRediectHelloWorld(Model model) {
		return "helloworld";
	}
}
