package com.mingo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mingo.dao.DepartmentDao;
import com.mingo.entity.Department;

@RestController
@RequestMapping("/v2/department")
public class DepartmentController {

	@Autowired
	private DepartmentDao departmentDao;
	
	@GetMapping
	public List<Department> getEmployee() {
		return departmentDao.getDepartment();
	}
	
	@PostMapping
	public void saveDepartment(@RequestBody Department department) {
		departmentDao.addDepartment(department);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDepartment(@PathVariable Integer id) {
		departmentDao.removeDepartment(id);
	}
}
