package com.macs.teamtwo.brokerportalapplication.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name = "mortageapplicantdetails")
public class MortgageApplicant {

	@Id
	@Column(name="MortgageId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int MortgageID;
	
	@Column(name="Applicant_name")
	private String ApplicantName;
	
	@Column(name="Mortgage_Value")
	private double MortgageValue;
	
	@Column(name="MSID")
	private int MSID;
	
	@Column(name="employer_name")
	private String employerName;
	
	@Column(name="pswd")
	private String pswd;
	
	@Column(name="application_status")
	private String applicationStatus;
	
	
	public MortgageApplicant(){
		
	}


	public MortgageApplicant(int mortgageID, String applicantName, double mortgageValue, int mSID, String employerName,
			String pswd, String applicationStatus) {
		super();
		this.MortgageID = mortgageID;
		ApplicantName = applicantName;
		MortgageValue = mortgageValue;
		MSID = mSID;
		this.employerName = employerName;
		this.pswd = pswd;
		this.applicationStatus = applicationStatus;
	}

	public int getMortgageID() {
		return MortgageID;
	}


	public void setMortgageID(int mortgageID) {
		MortgageID = mortgageID;
	}


	public String getApplicantName() {
		return ApplicantName;
	}


	public void setApplicantName(String applicantName) {
		ApplicantName = applicantName;
	}


	public double getMortgageValue() {
		return MortgageValue;
	}


	public void setMortgageValue(double mortgageValue) {
		MortgageValue = mortgageValue;
	}


	public int getMSID() {
		return MSID;
	}


	public void setMSID(int mSID) {
		MSID = mSID;
	}


	public String getEmployerName() {
		return employerName;
	}


	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}


	public String getPswd() {
		return pswd;
	}


	public void setPswd(String pswd) {
		this.pswd = pswd;
	}


	public String getApplicationStatus() {
		return applicationStatus;
	}


	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	
//	
//	@Override
//	public String toString(){
//		return String.format("Applicant [MortgageID = %d, Name = %s, lastName = %s", applicantID, firstName, lastName);
//	}

	
}
