package com.bootspringrest.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootspringrest.example.model.Flights;
import com.bootspringrest.example.repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	@Autowired
	EmployeeRepository employeeRepository;
	
	/*public Flights save(Flights emp){
		return employeeRepository.save(emp);
	}*/
	
	public List<Flights> findAll(){
		return employeeRepository.findAll();
	}
	
	public Flights findOne(Long id){
		return employeeRepository.findOne(id);
	}
	
	public List<Flights> findByType(String type){
		return employeeRepository.findbytype(type);
	}
	
	public List<Flights> findByEndpoints(String deptApt, String arrApt){
		return employeeRepository.findbyendpoints(deptApt, arrApt);
	}
	/*public void delete(Employee emp){
		employeeRepository.delete(emp);
	}*/
}
