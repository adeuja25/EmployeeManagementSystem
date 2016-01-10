package com.home.practice.repositoryInterface;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.home.practice.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	@Query("select e from Employee e where e.name = :name")
	Employee getEmployeeByUsername(@Param("name") String name);
	
	@Query("select m from Employee m where id = :memberId")
	Employee getEmployeeById(@Param("memberId")int empId);
	
	@Query("select m from Employee m where name = :name")
	List<Employee> getEmployeeByName(@Param("name") String name);
	
	@Query("select m from Employee m where m.email = :email")
	Employee getEmployeeByEmail(@Param("email") String email);
}
