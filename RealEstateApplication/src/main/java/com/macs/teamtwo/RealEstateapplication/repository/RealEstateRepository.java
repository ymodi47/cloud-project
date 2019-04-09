package com.macs.teamtwo.RealEstateapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macs.teamtwo.RealEstateapplication.domain.RealEstate;



@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate, Integer>{

	RealEstate getEmployeeByEmailAndPassword(String email,String password);
}
