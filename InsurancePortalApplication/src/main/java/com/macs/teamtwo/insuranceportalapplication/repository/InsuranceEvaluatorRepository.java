package com.macs.teamtwo.insuranceportalapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.macs.teamtwo.insuranceportalapplication.domain.MIsIDDetails;

@Repository
public interface InsuranceEvaluatorRepository extends JpaRepository<MIsIDDetails, Integer> {

	MIsIDDetails getMIsIDDetailsBymisID(int misID);
}