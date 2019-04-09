package com.macs.teamtwo.brokerportalapplication.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macs.teamtwo.brokerportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.brokerportalapplication.repository.MortgageApplicantRepository;

// employee service class
@Service
public class MortgageApplicantService {
	
	MortgageApplicantService()
	{
		
	}
	
	@Autowired
	private MortgageApplicantRepository mortgageApplicantRepository;
	
	// inserting employee
	public MortgageApplicant addMortgageApplicant(MortgageApplicant applicant) {
		applicant.setApplicationStatus("Work In Progress");
		MortgageApplicant mortgageApplicant=mortgageApplicantRepository.save(applicant);
		return mortgageApplicant;
	}

	// update employee
		public MortgageApplicant UpdateMortgageApplicant(int MortgageID) {
			MortgageApplicant mortgageApplicant=mortgageApplicantRepository.getApplicantByMortgageID(MortgageID);
			mortgageApplicant.setApplicationStatus("Verified!");
			MortgageApplicant Applicant=mortgageApplicantRepository.save(mortgageApplicant);
			return Applicant;
		}
	
	public MortgageApplicant getApplicantByMortgageID(int MortgageID) {
		// TODO Auto-generated method stub
		MortgageApplicant mortgageApplicant=mortgageApplicantRepository.getApplicantByMortgageID(MortgageID);
		return mortgageApplicant;
	}
	
}
