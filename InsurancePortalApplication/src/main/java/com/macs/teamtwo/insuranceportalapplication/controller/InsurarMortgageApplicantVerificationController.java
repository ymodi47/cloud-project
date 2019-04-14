package com.macs.teamtwo.insuranceportalapplication.controller;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.macs.teamtwo.insuranceportalapplication.service.Config;



@RestController
public class InsurarMortgageApplicantVerificationController {
	
	final static Logger logger = Logger.getLogger(InsurarMortgageApplicantVerificationController.class);
	
	public static final String MBR_PORTAL=Config.getProperty("brokerPortalCloudUrl");

	@GetMapping(value = "/submitvaluefromre/{MortId}/{appraisalValue}/{MsID}")
	public void processDetails(@PathVariable int MortId,@PathVariable double appraisalValue,@PathVariable int MsID) {
		
		logger.info("Appraisal Value provided by Real Estate : "+appraisalValue+" for morgage ID and House ID is : "+MortId+","+MsID);
		double deductiblevalue=appraisalValue*.03;
		double insuredValue=appraisalValue*.08;
		sendAllDetailsToMBR(MortId,insuredValue,MsID, deductiblevalue,appraisalValue);
		
	}
	
	 // get employee by email id and password
		public Boolean sendAllDetailsToMBR(int mortgageID,double insuredValue,int MsID,double deductiblevalue,double appraisalValue) {
			RestTemplate restTemplate = new RestTemplate();
			String hardCodeUrl="http://localhost:8086/";
			logger.info("invoking MBR portal with Insurable and Deductible Value  "+insuredValue+" , "+deductiblevalue+"  "+appraisalValue);
			String brokerPortal=MBR_PORTAL+"/submitvaluefrominc/"+mortgageID+"/"+insuredValue+"/"+MsID+"/"+deductiblevalue+"/"+appraisalValue;
			String value=restTemplate.getForObject(brokerPortal, String.class);
			logger.info("MBR portal invocation from Insurance is done.");
			if(value==null)
			{
				
				 System.out.println("Could not be verified : "+brokerPortal);
				 return false;
				
			}else
			{
				return true;
			}
				
		}

	
}
