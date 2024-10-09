package com.mingo.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private Integer empId;
	
	@Embedded
	private EmployeeName empName;
	
	@Embedded
	private EmployeeAddress empAddress;
	
	@Column(name="emp_age")
	private Integer empAge;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	private long mobileNumber;

	@Column(name="gender")
	private Character gender;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_joing")
	private Date dateOfJoing;
	
	@Column(name="experience")
	private Float Experience;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="marrital_status")
	private Character marritalStatus;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name="department_id")
	private Department department;
	
	@OneToOne
	@JoinColumn(name = "authDetail_id", referencedColumnName = "email")
	private AuthDetail authDetail;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer empId, EmployeeName empName, EmployeeAddress empAddress, Integer empAge, String email,
			long mobileNumber, Character gender, Date dateOfBirth, Date dateOfJoing, Float experience,
			String designation, Character marritalStatus, Department department, AuthDetail authDetail) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empAge = empAge;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoing = dateOfJoing;
		Experience = experience;
		this.designation = designation;
		this.marritalStatus = marritalStatus;
		this.department = department;
		this.authDetail = authDetail;
	}
	public Employee( EmployeeName empName, EmployeeAddress empAddress, Integer empAge, String email,
			long mobileNumber, Character gender, Date dateOfBirth, Date dateOfJoing, Float experience,
			String designation, Character marritalStatus, Department department, AuthDetail authDetail) {
		super();
		this.empName = empName;
		this.empAddress = empAddress;
		this.empAge = empAge;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoing = dateOfJoing;
		Experience = experience;
		this.designation = designation;
		this.marritalStatus = marritalStatus;
		this.department = department;
		this.authDetail = authDetail;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public EmployeeName getEmpName() {
		return empName;
	}

	public void setEmpName(EmployeeName empName) {
		this.empName = empName;
	}

	public EmployeeAddress getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(EmployeeAddress empAddress) {
		this.empAddress = empAddress;
	}

	public Integer getEmpAge() {
		return empAge;
	}

	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public AuthDetail getAuthDetail() {
		return authDetail;
	}

	public void setAuthDetail(AuthDetail authDetail) {
		this.authDetail = authDetail;
	}
	
}
