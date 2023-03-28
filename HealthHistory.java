package com.kavyasri.bdp.entity;

import java.time.LocalDate;


import jakarta.persistence.*;

	@Entity 
	@Table(name="healthHistory")
	public class HealthHistory {
        @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long healthId;
		@Column(name="year",nullable=false)
		private LocalDate year;
		@Column(name="issue",nullable=true)
		private String issue;
		@Column(name="fullyrecovered",nullable=true)
		private String fullyrecovered;
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="usersId")
		private Users users;
		
		public long getHealthId() {
			return healthId;
		}
		public void setHealthId(long healthId) {
			this.healthId = healthId;
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
		public Users getUsers() {
			return users;
		}
		public void setUsers(Users users) {
			this.users = users;
		}
		@Override
		public String toString() {
			return "HealthHistory [healthId=" + healthId + ", year=" + year + ", issue=" + issue + ", fullyrecovered="
					+ fullyrecovered + ", users=" + users + ", getHealthId()=" + getHealthId() + ", getYear()="
					+ getYear() + ", getIssue()=" + getIssue() + ", getFullyrecovered()=" + getFullyrecovered()
					+ ", getUsers()=" + getUsers() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
					+ ", toString()=" + super.toString() + "]";
		}
		
}
