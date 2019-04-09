package com.macs.teamtwo.realstateportalapplication.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "mortageapplicantdetails")
public class MortgageApplicant {
	
	public MortgageApplicant(int mortgageID, String applicantName, int msID) {
		super();
		this.mortgageID = mortgageID;
		this.applicantName = applicantName;
		this.MSID = msID;
	}
	
	
	@Id
	@Column(name="mortgageID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mortgageID;
	
	@Column(name="applicantName")
	private String applicantName;
	
	@Column(name="appraiserValue")
	private double appraiserValue;
	
	@Column(name="MSID")
	private int MSID;
	

	
	public MortgageApplicant(){
		
	}



	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public double getAppraiserValue() {
		return appraiserValue;
	}

	public void setAppraiserValue(double appraiserValue) {
		this.appraiserValue = appraiserValue;
	}

	public int getMSID() {
		return MSID;
	}

	public void setMSID(int mSID) {
		this.MSID = mSID;
	}

	public void setMortgageID(int mortgageID) {
		this.mortgageID = mortgageID;
	}

	public int getMortgageID() {
		return mortgageID;
	}

	
	
}