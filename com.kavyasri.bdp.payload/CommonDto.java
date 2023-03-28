package com.kavyasri.bdp.payload;

import java.time.LocalDate;



public class CommonDto {
	
	private String fname;
	
	private String lname;
	private String contact;
	private String bloodgroup;
	private String gender;
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	private LocalDate year;

	private String issue;

	private String fullyrecovered;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public LocalDate getYear() {
		return year;
	}

	public void setYear(LocalDate year) {
		this.year = year;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getFullyrecovered() {
		return fullyrecovered;
	}

	public void setFullyrecovered(String fullyrecovered) {
		this.fullyrecovered = fullyrecovered;
	}
	
}
