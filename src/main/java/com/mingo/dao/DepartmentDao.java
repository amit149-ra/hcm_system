package com.mingo.dao;

import java.util.List;

import com.mingo.entity.Department;

public interface DepartmentDao {

	List<Department> getDepartment();
	void addDepartment(Department department);
	void removeDepartment(Integer id);
}
