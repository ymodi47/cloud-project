package com.macs.teamtwo.realstateportalapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macs.teamtwo.realstateportalapplication.domain.MortgageApplicant;
import com.macs.teamtwo.realstateportalapplication.repository.AppraiserValueEvaluatorRepository;

@Service
public class AppraiserValueEvaluatorService {

	AppraiserValueEvaluatorService() {

	}

	@Autowired
	private AppraiserValueEvaluatorRepository appraiserValueEvaluatorRepository;

	public MortgageApplicant getAppraiserValueByMortgageAndMSID(int mortgageID, int mSID) {
		return appraiserValueEvaluatorRepository.getAppraserValueByMortgageIDAndMSID(mortgageID,mSID);
	}
}
