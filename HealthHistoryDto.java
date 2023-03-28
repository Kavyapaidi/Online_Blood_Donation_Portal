package com.kavyasri.bdp.payload;

import java.time.LocalDate;


public class HealthHistoryDto {

	private LocalDate year;

	private String issue;

	private String fullyrecovered;
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
