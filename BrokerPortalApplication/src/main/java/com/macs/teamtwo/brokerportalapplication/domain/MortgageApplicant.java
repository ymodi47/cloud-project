package com.macs.teamtwo.brokerportalapplication.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name = "mortageapplicant")
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
	
	@Column(name="Pswd")
	private String Pswd;
	
	@Column(name="ApplicationStatus")
	private String ApplicationStatus;
	
	
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

	public String getPswd() {
		return Pswd;
	}

	public void setPswd(String pswd) {
		Pswd = pswd;
	}

	public MortgageApplicant(){
		
	}

	public MortgageApplicant(int applicantID, String applicantName, double mortgageValue, int mSID,
			String employerName, String pswd, String applicationStatus) {
		super();
		this.applicantID = applicantID;
		this.applicantName = applicantName;
		MortgageValue = mortgageValue;
		this.mSID = mSID;
		this.employerName = employerName;
		Pswd = pswd;
		ApplicationStatus = applicationStatus;
	}
}
