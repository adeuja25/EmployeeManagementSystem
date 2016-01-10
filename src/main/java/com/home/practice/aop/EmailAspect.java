package com.home.practice.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.home.practice.domain.Employee;
import com.home.practice.email.Email;


@Aspect
@Component
public class EmailAspect {
	@Autowired
	private Email email;
	
	/*@After("execution(* com.home.practice.serviceImp.EmployeeServiceImpl.add(..))")
	public void aopEmail(JoinPoint jp)
	{
		Employee emp= (Employee) jp.getArgs()[0];
		email.sendEmail(emp.getEmail(), "Success","Namaskar Aaramai Hunhunchha!!");
	}*/
	
	
}
