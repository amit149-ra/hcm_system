package com.mingo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mingo.DTO.EmployeeAuthenticationDTO;
import com.mingo.dao.repository.AuthenticationRepository;
import com.mingo.dao.repository.DepartmentRepository;
import com.mingo.dao.repository.EmployeeRepository;
import com.mingo.entity.AuthDetail;
import com.mingo.entity.Department;
import com.mingo.entity.Employee;
import com.mingo.entity.EmployeeAddress;
import com.mingo.entity.EmployeeName;
import com.mingo.exception.DepartmentNotFoundException;

@Service
public class EmployeeDAOImp implements EmployeeDAO {

	@Autowired
	private EmployeeRepository empRepository;
	
	@Autowired
	private DepartmentRepository  departmentRepository;
	
	@Autowired
	private AuthenticationRepository authenticationRepository;
	
	

	public void saveEmployee(EmployeeAuthenticationDTO employeeDTO) {
		AuthDetail authDetail=new AuthDetail();
		authDetail.setEmail(employeeDTO.getEmployeeAuthDTO().getEmail());
		authDetail.setPassword(employeeDTO.getEmployeeAuthDTO().getPassword());
		
		authenticationRepository.save(authDetail);
		
		EmployeeName name=new EmployeeName();
		name.setFirstName(employeeDTO.getEmployeeDTO().getEmpNameDTO().getFirstName());
		name.setLastName(employeeDTO.getEmployeeDTO().getEmpNameDTO().getLastName());
		
		EmployeeAddress employeeAddress=new EmployeeAddress();
		employeeAddress.setAddressLine_1(employeeDTO.getEmployeeDTO().getEmpAddressDTO().getAddressLine_1());
		employeeAddress.setAddressLine_2(employeeDTO.getEmployeeDTO().getEmpAddressDTO().getAddressLine_2());
		employeeAddress.setCity(employeeDTO.getEmployeeDTO().getEmpAddressDTO().getCity());
		employeeAddress.setState(employeeDTO.getEmployeeDTO().getEmpAddressDTO().getState());
		employeeAddress.setCountry(employeeDTO.getEmployeeDTO().getEmpAddressDTO().getCountry());
		employeeAddress.setPinCode(employeeDTO.getEmployeeDTO().getEmpAddressDTO().getPinCode());
		
		Employee employee=new Employee();
		employee.setEmpName(name);
		employee.setEmpAddress(employeeAddress);
		employee.setEmpAge(employeeDTO.getEmployeeDTO().getEmpAge());
		employee.setMobileNumber(employeeDTO.getEmployeeDTO().getMobileNumber());
		employee.setGender(employeeDTO.getEmployeeDTO().getGender());
		employee.setDateOfBirth(employeeDTO.getEmployeeDTO().getDateOfBirth());
		employee.setDateOfJoing(employeeDTO.getEmployeeDTO().getDateOfJoing());
		employee.setExperience(employeeDTO.getEmployeeDTO().getExperience());
		employee.setDesignation(employeeDTO.getEmployeeDTO().getDesignation());
		employee.setMarritalStatus(employeeDTO.getEmployeeDTO().getMarritalStatus());
		
		Department department=departmentRepository.findById(employeeDTO.getEmployeeDTO().getDepartmentId())
				.orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
		employee.setDepartment(department);
		
		employee.setAuthDetail(authDetail);
		
		empRepository.save(employee);
		
	}

	public List<Employee> getEmployees() {
		return (List<Employee>) empRepository.findAll();
	}

	public void delete(int id) {
		empRepository.deleteById(id);
	}

	public List<Employee> findEmployees(Department department) {
		return (List<Employee>) empRepository.findByDepartment(department);
	}
 
}
