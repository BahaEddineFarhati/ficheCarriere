package com.bct.ficheCarriere.model;

import java.util.List;

public class EmployeeDetails {
	String id;
	String fName;
	String lName;
	ContactDetails contactDetails;
	String birthDate;
	String actualPosition;
	String actualDepartment;
	String hireDate;
	String hireGrade;
	List<Formation> formationsList;
	List<Function> functionsList;
	List<Function> positionsList;
	
	
	public EmployeeDetails() {
		
	}

	public List<Formation> getFormationsList() {
		return formationsList;
	}

	public void setFormationsList(List<Formation> formationsList) {
		this.formationsList = formationsList;
	}

	public List<Function> getFunctionsList() {
		return functionsList;
	}

	public void setFunctionsList(List<Function> functionsList) {
		this.functionsList = functionsList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	

	
	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getActualPosition() {
		return actualPosition;
	}

	public void setActualPosition(String actualPosition) {
		this.actualPosition = actualPosition;
	}

	public String getActualDepartment() {
		return actualDepartment;
	}

	public void setActualDepartment(String actualDepartment) {
		this.actualDepartment = actualDepartment;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public List<Function> getPositionsList() {
		return positionsList;
	}

	public void setPositionsList(List<Function> positionsList) {
		this.positionsList = positionsList;
	}

	public String getHireGrade() {
		return hireGrade;
	}

	public void setHireGrade(String hireGrade) {
		this.hireGrade = hireGrade;
	}

	
	
	
	
	

}
