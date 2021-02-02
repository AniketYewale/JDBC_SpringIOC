package com.indus.training.persist.entity;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable
{

	private static final long serialVersionUID = -3198605381617161225L;
	
	private int employee_id;
	private String fName;
	private String lName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private int jobID;
	private Double salary;
	private Integer managerID;
	private int departmentID;
	
	
	public Employee() 
	{

	}


	public Employee(int employee_id, String fName, String lName, String email, String phoneNumber, Date hireDate, int jobID, Double salary, Integer managerID, int departmentID) 
	{
		super();
		this.employee_id = employee_id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobID = jobID;
		this.salary = salary;
		this.managerID = managerID;
		this.departmentID = departmentID;
	}


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Date getHireDate() {
		return hireDate;
	}


	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	public int getJobID() {
		return jobID;
	}


	public void setJobID(int jobID) {
		this.jobID = jobID;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public Integer getManagerID() {
		return managerID;
	}


	public void setManagerID(Integer managerID) {
		this.managerID = managerID;
	}


	public int getDepartmentID() {
		return departmentID;
	}


	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + departmentID;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + employee_id;
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
		result = prime * result + jobID;
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + ((managerID == null) ? 0 : managerID.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (departmentID != other.departmentID)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employee_id != other.employee_id)
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (hireDate == null) {
			if (other.hireDate != null)
				return false;
		} else if (!hireDate.equals(other.hireDate))
			return false;
		if (jobID != other.jobID)
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (managerID == null) {
			if (other.managerID != null)
				return false;
		} else if (!managerID.equals(other.managerID))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}


	@Override
	public String toString() 
	{
		return "Employee [employee_id=" + employee_id + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobID=" + jobID + ", salary=" + salary
				+ ", managerID=" + managerID + ", departmentID=" + departmentID + "]";
	}

}
