package com.macs.teamtwo.realstateportalapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macs.teamtwo.realstateportalapplication.domain.MortgageApplicant;

@Repository
public interface AppraiserValueEvaluatorRepository extends JpaRepository<MortgageApplicant, Integer> {

	double getAppraserValueByMortgageIDAndMSID(int mortgageID, int mSID);
}
