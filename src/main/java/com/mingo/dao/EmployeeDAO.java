package com.mingo.dao;

import java.util.List;

import com.mingo.DTO.EmployeeAuthenticationDTO;
import com.mingo.entity.Department;
import com.mingo.entity.Employee;

public interface EmployeeDAO {
	
	void saveEmployee(EmployeeAuthenticationDTO employeeDTO);
	List<Employee> getEmployees();
	void delete(int id);
	List<Employee> findEmployees(Department department);

}
