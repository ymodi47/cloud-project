package com.macs.teamtwo.insuranceportalapplication.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "insurance")
public class MIsIDDetails {
	
	@Id
	@Column(name="misID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int misID;
	

	@Column(name="insured_value")
	private double insured_value;


	@Column(name="deductible_value")
	private double deductible_value;
	

	public MIsIDDetails(){
		
	}


	public int getMisID() {
		return misID;
	}


	public void setMisID(int misID) {
		this.misID = misID;
	}


	public double getInsured_value() {
		return insured_value;
	}


	public void setInsured_value(double insured_value) {
		this.insured_value = insured_value;
	}


	public double getDeductible_value() {
		return deductible_value;
	}


	public void setDeductible_value(double deductible_value) {
		this.deductible_value = deductible_value;
	}


	public MIsIDDetails(int misid, double insured_value, double deductible_value) {
		super();
		misID = misid;
		this.insured_value = insured_value;
		this.deductible_value = deductible_value;
	}
	
	
		
}