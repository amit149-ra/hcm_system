package com.mingo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mingo.dao.repository.DepartmentRepository;
import com.mingo.entity.Department;

@Service
public class DepartmentImp implements DepartmentDao {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public void addDepartment(Department department) {
		departmentRepository.save(department);
		
	}

	@Override
	public void removeDepartment(Integer id) {
		
		departmentRepository.deleteById(id);
		
	}

	@Override
	public List<Department> getDepartment() {
		return (List<Department>) departmentRepository.findAll();
	}

}
