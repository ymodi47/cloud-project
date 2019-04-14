package com.macs.teamtwo.realstateportalapplication.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.macs.teamtwo.realstateportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.realstateportalapplication.repository.AppraiserValueEvaluatorRepository;

@Service
public class AppraiserValueEvaluatorService {

	private static final Logger logger = Logger.getLogger(AppraiserValueEvaluatorService.class);	
	public static final String INSINC_PORTAL =Config.getProperty("insurancePortalCloudUrl");

	AppraiserValueEvaluatorService() {

	}


	@Autowired
	private AppraiserValueEvaluatorRepository appraiserValueEvaluatorRepository;

	public MortgageApplicant getAppraiserValueByMortgageAndMSID(int mortgageID, int mSID,String name) {
		// pass this value to INSinc
		MortgageApplicant mortageApplicant = appraiserValueEvaluatorRepository.getAppraserValueByMSID(mSID);
		if(mortageApplicant==null)
		{
			mortageApplicant=new MortgageApplicant();
		}
		mortageApplicant.setmSID(mSID);
		mortageApplicant.setAppraiserValue(generateRandomAppraiserValue());
		mortageApplicant.setMortgageID(mortgageID);
		mortageApplicant.setApplicantName(name);
		appraiserValueEvaluatorRepository.save(mortageApplicant);
		sendAppraisalDetailsTOINSinc(mortgageID, mortageApplicant.getAppraiserValue(), mSID);
		return mortageApplicant;
	}

	// get employee by email id and password
	public Boolean sendAppraisalDetailsTOINSinc(int mortgageID, double appraisalvalue, int mSID) {
		RestTemplate restTemplate = new RestTemplate();
		String hardCodeUrl="http://localhost:8085";
		logger.info("Invokig Insurror with values : "+ appraisalvalue+", "+ mSID);
		String insuranceUrlWithParams=INSINC_PORTAL+"/submitvaluefromre"+"/"+mortgageID+"/"+appraisalvalue+"/"+mSID;
		MortgageApplicant applicant = restTemplate.getForObject(insuranceUrlWithParams, MortgageApplicant.class);
		logger.info("Insuror Invocation is done and MBR portal has been supplied values.");
		return false;
	}

	private double generateRandomAppraiserValue()
	{
		 Double min = 0.0; //  Set To Your Desired Min Value
         Double max = 100000.0; //    Set To Your Desired Max Value
         double x = (Math.random() * ((max - min) + 1)) + min; //    This Will Create 
        // A Random Number Inbetween Your Min And Max.
         double xrounded = Math.round(x * 100.0) / 100.0; // Creates Answer To 
         //The Nearest 100 th, You Can Modify This To Change How It Rounds.
         System.out.println(xrounded); //    This Will Now Print Out The 
        // Rounded, Random Number.
         return xrounded;
	}
	
}
