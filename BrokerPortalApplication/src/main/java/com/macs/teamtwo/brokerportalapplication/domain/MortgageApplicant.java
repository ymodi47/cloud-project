package com.macs.teamtwo.brokerportalapplication.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name = "mortageapplicantdetails",uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class MortgageApplicant {

	@Id
	@Column(name="applicant_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int applicantID;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="employer_name")
	private String employerName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="salary")
	private String salary;
	
	@Column(name="phone_number")
	private double phoneNumber;
	
	@Column(name="application_number")
	private String applicationNumber;
	
	@Column(name="email",unique=true)
	private String email;
	
	@Column(name="application_status")
	private String applicationStatus;
	
	
	public MortgageApplicant(){
		
	}
	
	public MortgageApplicant(String firstName, String lastName,String employerName,String address,String salary,int phoneNumber,String applicationNumber,String email,String applicationStatus) {
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
