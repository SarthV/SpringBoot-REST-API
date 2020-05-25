package com.bootspringrest.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootspringrest.example.model.Employee;
import com.bootspringrest.example.repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee save(Employee emp){
		return employeeRepository.save(emp);
	}
	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	public Employee findOne(Long empid){
		return employeeRepository.findOne(empid);
	}
	public void delete(Employee emp){
		employeeRepository.delete(emp);
	}
}
