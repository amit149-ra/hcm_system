package com.mingo.dao.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mingo.entity.Department;
import com.mingo.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
public List<Employee> findByDepartment(Department department);
}
