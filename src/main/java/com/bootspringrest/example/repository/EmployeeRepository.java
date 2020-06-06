package com.bootspringrest.example.repository;
import com.bootspringrest.example.model.Flights;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Flights, Long>{
	@Query("select flight from Flights flight where flight.type = ?1")
	List<Flights> findbytype(String type);
	
	@Query("select flight from Flights flight where flight.type = ?1")
	List<Flights> findbyendpoints(String deptApt, String arrApt);
	
}
