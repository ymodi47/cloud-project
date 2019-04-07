package com.macs.teamtwo.employerportalapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macs.teamtwo.employerportalapplication.domain.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee getEmployeeByEmailAndPassword(String email,String password);
}
