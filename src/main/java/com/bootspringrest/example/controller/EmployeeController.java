package com.bootspringrest.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootspringrest.example.dao.EmployeeDAO;
import com.bootspringrest.example.model.Flights;

@RestController
@RequestMapping("/FlightApi")
public class EmployeeController {
	@Autowired
	EmployeeDAO employeedao;
	
	/*@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp){
		return employeedao.save(emp);
	}
	*/
	@GetMapping("/flightInfo")
	public List<Flights> getAllEmployees(){
		return employeedao.findAll();
	}
	
	@GetMapping("/flightInfo/{id}")
	public ResponseEntity<Flights> getFlightsById(@PathVariable(value = "id") Long empid){
		Flights flight = employeedao.findOne(empid);
		if(flight == null){
			return ResponseEntity.notFound().build();
		}
		else{
			return ResponseEntity.ok().body(flight);
		}
	}
	
	@GetMapping("/flightInfo/airport/{type}")
	public List<Flights> getFlightByType(@PathVariable(value = "type") String type){
		return employeedao.findByType(type);
	}
	
	@GetMapping("/flightInfo/departure/{departure}/arrival/{arrival}")
	public List<Flights> getFlightByEndpoints(@PathVariable(value = "departure") String deptApt, @PathVariable(value= "arrival") String arrApt){
		return employeedao.findByEndpoints(deptApt,arrApt);
	}
	
	/*@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empid, @Valid @RequestBody Employee empDetails){
		Employee emp = employeedao.findOne(empid);
		if(emp == null){
			return ResponseEntity.notFound().build();
		}
		else{
			emp.setName(empDetails.getName());
			emp.setDesignation(empDetails.getDesignation());
			emp.setExpertise(empDetails.getExpertise());
			Employee updatedEmp = employeedao.save(emp);
			return ResponseEntity.ok().body(updatedEmp);
		}
	}*/
	
	/*@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long empid){
		Employee emp = employeedao.findOne(empid);
		if(emp == null){
			return ResponseEntity.notFound().build();
		}
		else{
			employeedao.delete(emp);
			return ResponseEntity.ok().build();
		}
	}*/
	
}
