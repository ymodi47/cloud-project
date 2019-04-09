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
	
	public MIsIDDetails( int msID) {
		super();
		this.MIsID = msID;
	}
	
	@Id
	@Column(name="MIsID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int MIsID;
	

	@Column(name="insuredvalue")
	private String insuredvalue;


	@Column(name="deductiblevalue")
	private String deductiblevalue;
	

	public MIsIDDetails(){
		
	}
	
	public String getInsuredvalue() {
		return insuredvalue;
	}


	public void setInsuredvalue(String insuredvalue) {
		this.insuredvalue = insuredvalue;
	}

	public int getMIsID() {
		return MIsID;
	}

	public void setMIsID(int mIsID) {
		MIsID = mIsID;
	}

	public String getDeductiblevalue() {
		return deductiblevalue;
	}

	public void setDeductiblevalue(String deductiblevalue) {
		this.deductiblevalue = deductiblevalue;
	}
	
}
