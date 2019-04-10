package com.macs.teamtwo.brokerportalapplication.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "broker")
public class MortgageApplicant {

	@Id
	@Column(name="applicantID",unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int applicantID;
	
	@Column(name="applicantName")
	private String applicantName;
	
	@Column(name="MortgageValue")
	private double MortgageValue;
	
	@Column(name="mSID")
	private int mSID;
	
	@Column(name="employerName")
	private String employerName;
	
	@Column(name="password")
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="ApplicationStatus")
	private String ApplicationStatus;
	
	@Column(name="appraisalvalue")
	private double appraisalvalue;
	
	@Column(name="insuredValue")
	private double insuredValue;
	
	@Column(name="deductiblevalue")
	private double deductiblevalue;
	
	
	
	public double getInsuredValue() {
		return insuredValue;
	}

	public void setInsuredValue(double insuredValue) {
		this.insuredValue = insuredValue;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public double getAppraisalvalue() {
		return appraisalvalue;
	}

	public void setAppraisalvalue(double appraisalvalue) {
		this.appraisalvalue = appraisalvalue;
	}

	public double getDeductiblevalue() {
		return deductiblevalue;
	}

	public void setDeductiblevalue(double deductiblevalue) {
		this.deductiblevalue = deductiblevalue;
	}

	
	
	public int getApplicantID() {
		return applicantID;
	}

	public String getApplicationStatus() {
		return ApplicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		ApplicationStatus = applicationStatus;
	}

	public void setApplicantID(int applicantID) {
		this.applicantID = applicantID;
	}

	public String getapplicantName() {
		return applicantName;
	}

	public void setapplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public double getMortgageValue() {
		return MortgageValue;
	}

	public void setMortgageValue(double mortgageValue) {
		MortgageValue = mortgageValue;
	}

	public int getmSID() {
		return mSID;
	}

	public void setmSID(int mSID) {
		this.mSID = mSID;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	

	public MortgageApplicant(){
		
	}

	public MortgageApplicant(int applicantID, String applicantName, double mortgageValue, int mSID,
			String employerName, String password, String applicationStatus) {
		super();
		this.applicantID = applicantID;
		this.applicantName = applicantName;
		MortgageValue = mortgageValue;
		this.mSID = mSID;
		this.employerName = employerName;
		this.password = password;
		ApplicationStatus = applicationStatus;
	}
}
