package com.mingo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mingo.DTO.AuthenticationService;
import com.mingo.DTO.EmployeeAuthenticationDTO;
import com.mingo.auth.AuthenticationRequest;
import com.mingo.auth.AuthenticationResponse;
import com.mingo.auth.RegisterRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	
	private final AuthenticationService authenticationService;

	@PostMapping("register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody EmployeeAuthenticationDTO employeeAuthenticationDTO){
		return ResponseEntity.ok(authenticationService.register(employeeAuthenticationDTO));
		
	}
	@PostMapping("authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(authenticationService.authenticate(request));
	}
}
