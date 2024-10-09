package com.mingo.DTO;

import java.sql.Date;

import com.mingo.auth.AuthenticationRequest;
import com.mingo.entity.EmployeeAddress;
import com.mingo.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAuthenticationDTO {
	private EmployeeDTO employeeDTO;
	private EmployeeAuthDTO employeeAuthDTO;
	
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class EmployeeDTO {
		private Integer empId;
		private EmployeeNameDTO empNameDTO;
		private EmployeeAddressDTO empAddressDTO;
		private Integer empAge;
		private long mobileNumber;
		private Character gender;
		private Date dateOfBirth;
		private Date dateOfJoing;
		private Float Experience;
		private String designation;
		private Character marritalStatus;
		private Integer departmentId;
		public Integer getDepartmentId() {
			return departmentId;
		}
		public void setDepartmentId(Integer departmentId) {
			this.departmentId = departmentId;
		}
		public Integer getEmpId() {
			return empId;
		}
		public void setEmpId(Integer empId) {
			this.empId = empId;
		}
		public EmployeeNameDTO getEmpNameDTO() {
			return empNameDTO;
		}
		public void setEmpNameDTO(EmployeeNameDTO empNameDTO) {
			this.empNameDTO = empNameDTO;
		}
		public EmployeeAddressDTO getEmpAddressDTO() {
			return empAddressDTO;
		}
		public void setEmpAddressDTO(EmployeeAddressDTO empAddressDTO) {
			this.empAddressDTO = empAddressDTO;
		}
		public Integer getEmpAge() {
			return empAge;
		}
		public void setEmpAge(Integer empAge) {
			this.empAge = empAge;
		}
		public long getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public Character getGender() {
			return gender;
		}
		public void setGender(Character gender) {
			this.gender = gender;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public Date getDateOfJoing() {
			return dateOfJoing;
		}
		public void setDateOfJoing(Date dateOfJoing) {
			this.dateOfJoing = dateOfJoing;
		}
		public Float getExperience() {
			return Experience;
		}
		public void setExperience(Float experience) {
			Experience = experience;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public Character getMarritalStatus() {
			return marritalStatus;
		}
		public void setMarritalStatus(Character marritalStatus) {
			this.marritalStatus = marritalStatus;
		}
		
		
	}

	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class EmployeeAuthDTO {
		private String email;
		private String password;
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
	}

	public static class EmployeeNameDTO {
		private String firstName;
		private String lastName;
		
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
	}

	public static class EmployeeAddressDTO {
		private String addressLine_1;
		private String addressLine_2;
		private String city;
		private String state;
		private String country;
		private int pinCode;
		public String getAddressLine_1() {
			return addressLine_1;
		}
		public void setAddressLine_1(String addressLine_1) {
			this.addressLine_1 = addressLine_1;
		}
		public String getAddressLine_2() {
			return addressLine_2;
		}
		public void setAddressLine_2(String addressLine_2) {
			this.addressLine_2 = addressLine_2;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public int getPinCode() {
			return pinCode;
		}
		public void setPinCode(int pinCode) {
			this.pinCode = pinCode;
		}
		
		
	}

	@Override
	public String toString() {
		return "EmployeeAuthenticationDTO [employeeDTO=" + employeeDTO.getEmpNameDTO() + ", employeeAuthDTO=" + employeeAuthDTO.getEmail() + "]";
	}
	
}
