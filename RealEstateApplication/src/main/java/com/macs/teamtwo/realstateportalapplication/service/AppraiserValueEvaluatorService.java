package com.macs.teamtwo.realstateportalapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.macs.teamtwo.realstateportalapplication.repository.AppraiserValueEvaluatorRepository;

@Service
public class AppraiserValueEvaluatorService {

	AppraiserValueEvaluatorService() {

	}

	@Autowired
	private AppraiserValueEvaluatorRepository appraiserValueEvaluatorRepository;

	public double getAppraiserValueByMortgageAndMSID(int mortgageID, int MSID) {
		return appraiserValueEvaluatorRepository.getAppraserValueByMortgageIDAndMSID(mortgageID,MSID);
	}

}
