package com.macs.teamtwo.realstateportalapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.macs.teamtwo.realstateportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.realstateportalapplication.repository.AppraiserValueEvaluatorRepository;

@Service
public class AppraiserValueEvaluatorService {

	//public static final String INSINC_PORTAL = "http://localhost:8085/submitvaluefromre/3/5/6";
	
	public static final String INSINC_PORTAL =Config.getProperty("insurancePortalCloudUrl");

	AppraiserValueEvaluatorService() {

	}

	@Autowired
	private AppraiserValueEvaluatorRepository appraiserValueEvaluatorRepository;

	public MortgageApplicant getAppraiserValueByMortgageAndMSID(int mortgageID, int mSID) {
		// pass this value to INSinc
		MortgageApplicant Mort = appraiserValueEvaluatorRepository.getAppraserValueByMortgageIDAndMSID(mortgageID,mSID);
		sendAppraisalDetailsTOINSinc(mortgageID, Mort.getAppraiserValue(), mSID);
		return Mort;
	}

	// get employee by email id and password
	public Boolean sendAppraisalDetailsTOINSinc(int mortgageID, double appraisalvalue, int mSID) {
		RestTemplate restTemplate = new RestTemplate();
		//String hardCodeUrl="https://brokerportalteam2.azurewebsites.net";
		String hardCodeUrl="http://localhost:8085";
		String insuranceUrlWithParams=hardCodeUrl+"/submitvaluefromre"+"/"+mortgageID+"/"+appraisalvalue+"/"+mSID;
		System.out.println("insuranceUrlWithParams : " + insuranceUrlWithParams);
		MortgageApplicant applicant = restTemplate.getForObject(insuranceUrlWithParams, MortgageApplicant.class);
		System.out.println("applicant : " + applicant);		
		return false;
	}

}
