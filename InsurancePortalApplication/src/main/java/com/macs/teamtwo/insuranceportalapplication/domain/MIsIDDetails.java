package com.macs.teamtwo.insuranceportalapplication.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "MIsIDDetails")
public class MIsIDDetails {
	
	@Id
	@Column(name="MIsID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int MIsID;
	

	@Column(name="insuredvalue")
	private double insuredvalue;


	@Column(name="deductiblevalue")
	private double deductiblevalue;
	

	public MIsIDDetails(){
		
	}
	
	public double getInsuredvalue() {
		return insuredvalue;
	}


	public void setInsuredvalue(double insuredvalue) {
		this.insuredvalue = insuredvalue;
	}

	public int getMIsID() {
		return MIsID;
	}

	public void setMIsID(int MIsID) {
		this.MIsID = MIsID;
	}

	public double getDeductiblevalue() {
		return deductiblevalue;
	}

	public void setDeductiblevalue(double deductiblevalue) {
		this.deductiblevalue = deductiblevalue;
	}
	
}
