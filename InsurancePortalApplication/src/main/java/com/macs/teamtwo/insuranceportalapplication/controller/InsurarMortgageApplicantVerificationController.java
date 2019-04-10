package com.macs.teamtwo.insuranceportalapplication.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.macs.teamtwo.insuranceportalapplication.service.Config;



@RestController
public class InsurarMortgageApplicantVerificationController {
	
	//brokerPortalCloudUrl
	public static final String MBR_PORTAL=Config.getProperty("brokerPortalCloudUrl");

	// Verify the Applicant application Number
	@GetMapping(value = "/submitvaluefromre/{MortId}/{appraisalValue}/{MsID}")
	public void processDetails(@PathVariable int MortId,@PathVariable double appraisalValue,@PathVariable int MsID) {
		
		//INSInc will work on this value and call MBR to return these values-
		double deductiblevalue=appraisalValue*.03;
		double insuredValue=appraisalValue*.08;
		//get the details from real State Portal
		sendAllDetailsToMBR(MortId,insuredValue,MsID, deductiblevalue,appraisalValue);
		System.out.println("requested by ins portal");
		
	}
	
	 // get employee by email id and password
		public Boolean sendAllDetailsToMBR(int mortgageID,double insuredValue,int MsID,double deductiblevalue,double appraisalValue) {
			RestTemplate restTemplate = new RestTemplate();
			/*MortgageApplicant applicant = */
			//@GetMapping(value = "/submitvaluefrominc/{mortgageID}/{insuredValue}/{ MsID}/{deductiblevalue}/{appraisedValue}")
			String hardCodeUrl="http://localhost:8086/";
			//String hardCodeUrl="https://insuranceportalteam2.azurewebsites.net";
			//String brokerPortal=MBR_PORTAL+mortgageID+"/"+insuredValue+"/"+MsID+"/"+deductiblevalue+"/"+appraisalValue;
			String brokerPortal=hardCodeUrl+"/submitvaluefrominc/"+mortgageID+"/"+insuredValue+"/"+MsID+"/"+deductiblevalue+"/"+appraisalValue;
			System.out.println("brokerPortal URL from Insuror : "+brokerPortal);
			restTemplate.getForObject(brokerPortal, String.class);
		    System.out.println("applicant : "+brokerPortal);
				return false;
		}

	
}
