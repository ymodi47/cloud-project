package com.macs.teamtwo.brokerportalapplication.service;


import java.util.Optional;
import java.util.UUID;

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

	// inserting Applicant
	public MortgageApplicant addMortgageApplicant(MortgageApplicant applicant) {
		applicant.setApplicationStatus("Work In Progress");
		MortgageApplicant mortgageApplicant=mortgageApplicantRepository.save(applicant);
		return mortgageApplicant;
	}

	// update employee
	public MortgageApplicant UpdateMortgageApplicantStatus(int applicantID) {
		//applicant.setApplicationStatus("Done");
		MortgageApplicant mortgageApplicant=mortgageApplicantRepository.getApplicantByapplicantID(applicantID);
		mortgageApplicant.setApplicationStatus("Employer verified and waiting for Appraisal value !");
		MortgageApplicant Applicant=mortgageApplicantRepository.save(mortgageApplicant);
		return Applicant;
	}

	// get Applicant detail by ApplicationID
	public MortgageApplicant getApplicantDetails(int applicantID) {
		// TODO Auto-generated method stub
		MortgageApplicant mortgageApplicant=mortgageApplicantRepository.getApplicantByapplicantID(applicantID);
		return mortgageApplicant;
	}

}
