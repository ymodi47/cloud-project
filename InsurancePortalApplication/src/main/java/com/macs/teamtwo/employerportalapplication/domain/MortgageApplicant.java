package com.macs.teamtwo.employerportalapplication.domain;



public class MortgageApplicant {

	private int applicantID;
	
	private String firstName;
	
	private String lastName;
	
	private String employerName;
	
	private String address;
	
	private String salary;
	
	private double phoneNumber;
	
	private String applicationNumber;
	
	private String email;
	
	private String applicationStatus;
	
	
	public MortgageApplicant(){
		
	}
	
	public MortgageApplicant(String firstName, String lastName,String employerName,String address,String salary,double phoneNumber,String applicationNumber,String email,String applicationStatus) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.employerName=employerName;
		this.address=address;
		this.salary=salary;
		this.phoneNumber=phoneNumber;
		this.applicationNumber=applicationNumber;
		this.applicationStatus=applicationStatus;
		this.email=email;
		
	}
	
	public int getApplicantID() {
		return applicantID;
	}

	public void setApplicantID(int applicantID) {
		this.applicantID = applicantID;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString(){
		return String.format("Applicant [Applicant ID = %d, firstName = %s, lastName = %s", applicantID, firstName, lastName);
	}

	
}
