package com.mingo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mingo.DTO.AuthenticationService;
import com.mingo.DTO.EmployeeAuthenticationDTO;
import com.mingo.config.JwtService;
import com.mingo.dao.EmployeeDAO;
import com.mingo.dao.EmployeeDAOImp;
import com.mingo.entity.Department;
import com.mingo.entity.Employee;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v2/manager")
@RequiredArgsConstructor
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@PreAuthorize("hasAuthority('admin:read') or hasRole('MANAGER')")
	@GetMapping("employee")
	public ResponseEntity<?> getEmployees() {
	    return ResponseEntity.ok("You have access!");
	}

	@PostMapping
	public void saveEmployee(@RequestBody EmployeeAuthenticationDTO employeeAuthenticationDTO) {
		if (employeeAuthenticationDTO.getEmployeeAuthDTO() == null || employeeAuthenticationDTO.getEmployeeDTO() == null) {
            throw new IllegalArgumentException("Employee and Sign-in details are required");
        }
		employeeDAO.saveEmployee(employeeAuthenticationDTO);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		employeeDAO.delete(id);
	}
	
	@GetMapping("/department/{departmentId}")
	public List<Employee> getEmployees(@PathVariable Integer departmentId) {
		Department department=new Department();
		department.setDepartmentId(departmentId);
		return employeeDAO.findEmployees(department);
	}

}
