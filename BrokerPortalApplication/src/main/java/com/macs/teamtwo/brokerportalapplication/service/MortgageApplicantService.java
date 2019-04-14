package com.macs.teamtwo.brokerportalapplication.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macs.teamtwo.brokerportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.brokerportalapplication.repository.MortgageApplicantRepository;

@Service
public class MortgageApplicantService {
	
	private static final Logger logger = Logger.getLogger(MortgageApplicantService.class);


	MortgageApplicantService() {
	}

	@Autowired
	private MortgageApplicantRepository mortgageApplicantRepository;

	// inserting Applicant
	public MortgageApplicant addMortgageApplicant(MortgageApplicant applicant) {
		applicant.setApplicationStatus("Work In Progress");
		MortgageApplicant mortgageApplicant = mortgageApplicantRepository.save(applicant);
		return mortgageApplicant;
	}

	// update employee
	public MortgageApplicant UpdateMortgageApplicantStatus(int applicantID) {
		MortgageApplicant mortgageApplicant = mortgageApplicantRepository.getApplicantByapplicantID(applicantID);
		mortgageApplicant.setApplicationStatus("Employer verified and waiting for Appraisal value !");
		MortgageApplicant Applicant = mortgageApplicantRepository.save(mortgageApplicant);
		System.out.println("retruned from status update  : " + Applicant);
		return Applicant;
	}

	// get Applicant detail by ApplicationID
	public MortgageApplicant getApplicantDetails(int applicantID) {
		MortgageApplicant mortgageApplicant = mortgageApplicantRepository.getApplicantByapplicantID(applicantID);
		if (mortgageApplicant != null) {
			mortgageApplicant = UpdateMortgageApplicantStatus(applicantID);
		}
		return mortgageApplicant;
	}

	public MortgageApplicant UpdateMortgageApplicantDetailsAndStatus(int mortgageID, double insuredValue,
			double deductiblevalue, double appraisalvalue) {
		MortgageApplicant mortgageApplicant = mortgageApplicantRepository.getApplicantByapplicantID(mortgageID);
		if (mortgageApplicant != null) {
			mortgageApplicant.setAppraisalvalue(appraisalvalue);
			mortgageApplicant.setDeductiblevalue(deductiblevalue);
			mortgageApplicant.setInsuredValue(insuredValue);
			mortgageApplicant.setApplicationStatus("Final Verified from Insuraror!");
			MortgageApplicant Applicant = mortgageApplicantRepository.save(mortgageApplicant);
			return null;
		} else {
			return null;
		}

	}

	// gt Application Status
	public MortgageApplicant getApplicationStatus(int applicationId, String Password) {
		MortgageApplicant mortgageApplicant = mortgageApplicantRepository
				.getApplicantByapplicantIDAndPassword(applicationId, Password);
		return mortgageApplicant;
	}

}
