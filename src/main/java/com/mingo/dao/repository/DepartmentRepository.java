package com.mingo.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mingo.entity.Department;
import com.mingo.entity.Employee;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer>{
	
}
