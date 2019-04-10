package com.macs.teamtwo.insuranceportalapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macs.teamtwo.insuranceportalapplication.domain.MIsIDDetails;
import com.macs.teamtwo.insuranceportalapplication.repository.InsuranceEvaluatorRepository;

@Service
public class InsuranceEvaluatorService {

	InsuranceEvaluatorService() {

	}

	@Autowired
	private InsuranceEvaluatorRepository insuranceRepository;

	public MIsIDDetails constructQuote(int misID) {
		return insuranceRepository.getMIsIDDetailsBymisID(misID);

	}
}