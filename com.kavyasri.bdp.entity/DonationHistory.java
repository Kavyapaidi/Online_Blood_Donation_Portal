package com.kavyasri.bdp.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name="donationHistory")
public class DonationHistory {

        @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long donationId;
        @Column(name="name",nullable=false)
        private String name;
		@Column(name="date",nullable=false)
		private LocalDate date;
		@Column(name="location",nullable=true)
		private String location;
		@Column(name="isDonated",nullable=true)
		private boolean isDonated;
		@ManyToOne(fetch=FetchType.LAZY)
		//donarId is same as usersId
		@JoinColumn(name="donarId")
		private Users users;
		public long getDonationId() {
			return donationId;
		}
		public void setDonationId(long donationId) {
			this.donationId = donationId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public boolean isDonated() {
			return isDonated;
		}
		public void setDonated(boolean isDonated) {
			this.isDonated = isDonated;
		}
		public Users getUsers() {
			return users;
		}
		public void setUsers(Users users) {
			this.users = users;
		}
		
		
}
