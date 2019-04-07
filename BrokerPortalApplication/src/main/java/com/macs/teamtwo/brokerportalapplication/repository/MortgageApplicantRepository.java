package com.macs.teamtwo.brokerportalapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macs.teamtwo.brokerportalapplication.domain.MortgageApplicant;



@Repository
public interface MortgageApplicantRepository extends JpaRepository<MortgageApplicant, Integer>{

	MortgageApplicant getApplicantByApplicationNumber(String applicationNumber);
}
