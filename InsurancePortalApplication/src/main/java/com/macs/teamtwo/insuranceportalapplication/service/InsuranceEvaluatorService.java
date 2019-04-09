package com.macs.teamtwo.insuranceportalapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.macs.teamtwo.insuranceportalapplication.domain.MIsIDDetails;
import com.macs.teamtwo.insuranceportalapplication.repository.InsuranceEvaluatorRepository;

@Service
public class InsuranceEvaluatorService {
	
	public static String mbrLink="http://localhost:8080/insurancedetails";
	
	
	
	@Autowired
	private InsuranceEvaluatorRepository insuranceRepository;

	public void constructQuote(int MIsID) {
		//MIsIDDetails mIsIDDetails = insuranceRepository.getMIsIDDetailsByMIsID(MIsID);
		//submitDetailToMBRPortal(mIsIDDetails);
	}

	//Once the INSinc receives information on the property MlsID from the RE, it constructs an insurance quote on the property
	//MlsID and submits it to the MBR by invoking the MBR’s web service and providing it with confirmation of insurance
	//availability - it supplies it with MlsID, insured $ value, deductible ($ value), and Bob’s name.
	private void submitDetailToMBRPortal(MIsIDDetails mIsIDDetails ) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(mbrLink +mIsIDDetails.getMIsID() , mIsIDDetails,String.class);
	}
}
