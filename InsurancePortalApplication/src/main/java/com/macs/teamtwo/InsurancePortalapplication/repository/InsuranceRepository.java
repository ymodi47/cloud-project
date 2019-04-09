package com.macs.teamtwo.InsurancePortalapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macs.teamtwo.InsurancePortalapplication.domain.Insurance;



@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer>{

	Insurance getEmployeeByEmailAndPassword(String email,String password);
}
