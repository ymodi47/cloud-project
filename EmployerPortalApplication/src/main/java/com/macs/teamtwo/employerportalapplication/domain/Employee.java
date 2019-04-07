package com.macs.teamtwo.employerportalapplication.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "employee")
public class Employee {

	@Id
	@Column(name="employee_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeID;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="last_name")
	private String lastName;
	
	
	@Column(name="email")
	private String email;
	
	
	public Employee(){
		
	}
	
	public Employee(String firstName, String lastName,String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email=email;
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString(){
		return String.format("Employee [Employee ID = %d, firstName = %s, lastName = %s", employeeID, firstName, lastName);
	}

	
}
