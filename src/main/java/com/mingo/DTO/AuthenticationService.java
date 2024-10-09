package com.mingo.DTO;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mingo.auth.AuthenticationRequest;
import com.mingo.auth.AuthenticationResponse;
import com.mingo.auth.RegisterRequest;
import com.mingo.config.JwtService;
import com.mingo.dao.repository.AuthenticationRepository;
import com.mingo.dao.repository.DepartmentRepository;
import com.mingo.dao.repository.EmployeeRepository;
import com.mingo.entity.AuthDetail;
import com.mingo.entity.Department;
import com.mingo.entity.Employee;
import com.mingo.entity.EmployeeAddress;
import com.mingo.entity.EmployeeName;
import com.mingo.entity.Role;
import com.mingo.exception.DepartmentNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final AuthenticationRepository authenticationRepository;
	private final EmployeeRepository empRepository;
	private final DepartmentRepository departmentRepository;
	private final PasswordEncoder encoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;


	public AuthenticationResponse register(EmployeeAuthenticationDTO request) {
		var signInDetails = AuthDetail.builder()
                .email(request.getEmployeeAuthDTO().getEmail())
                .password(encoder.encode(request.getEmployeeAuthDTO().getPassword()))
				.role(Role.ADMIN)
                .build();
		authenticationRepository.save(signInDetails);
//////////////////////////////////////////////////////////////
		EmployeeName name=new EmployeeName();
		name.setFirstName(request.getEmployeeDTO().getEmpNameDTO().getFirstName());
		name.setLastName(request.getEmployeeDTO().getEmpNameDTO().getLastName());
		
		EmployeeAddress employeeAddress=new EmployeeAddress();
		employeeAddress.setAddressLine_1(request.getEmployeeDTO().getEmpAddressDTO().getAddressLine_1());
		employeeAddress.setAddressLine_2(request.getEmployeeDTO().getEmpAddressDTO().getAddressLine_2());
		employeeAddress.setCity(request.getEmployeeDTO().getEmpAddressDTO().getCity());
		employeeAddress.setState(request.getEmployeeDTO().getEmpAddressDTO().getState());
		employeeAddress.setCountry(request.getEmployeeDTO().getEmpAddressDTO().getCountry());
		employeeAddress.setPinCode(request.getEmployeeDTO().getEmpAddressDTO().getPinCode());
		
		Employee employee=new Employee();
		employee.setEmpName(name);
		employee.setEmpAddress(employeeAddress);
		employee.setEmpAge(request.getEmployeeDTO().getEmpAge());
		employee.setMobileNumber(request.getEmployeeDTO().getMobileNumber());
		employee.setGender(request.getEmployeeDTO().getGender());
		employee.setDateOfBirth(request.getEmployeeDTO().getDateOfBirth());
		employee.setDateOfJoing(request.getEmployeeDTO().getDateOfJoing());
		employee.setExperience(request.getEmployeeDTO().getExperience());
		employee.setDesignation(request.getEmployeeDTO().getDesignation());
		employee.setMarritalStatus(request.getEmployeeDTO().getMarritalStatus());
		
		Department department=departmentRepository.findById(request.getEmployeeDTO().getDepartmentId())
				.orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
		employee.setDepartment(department);
		
		employee.setAuthDetail(signInDetails);
		
		empRepository.save(employee);
		////////////////////////////////
		var jwtToken=jwtService.generateToken(signInDetails);
		return AuthenticationResponse.builder()
		.token(jwtToken)
		.build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
		);
		var user=authenticationRepository.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken=jwtService.generateToken(user);
		return AuthenticationResponse.builder()
		.token(jwtToken)
		.build();
	}

}
