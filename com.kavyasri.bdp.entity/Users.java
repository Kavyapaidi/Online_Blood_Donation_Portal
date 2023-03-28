package com.kavyasri.bdp.entity;

import jakarta.persistence.*; 


import java.time.LocalDate;



	@Entity 
	@Table(name="users",uniqueConstraints= {@UniqueConstraint(columnNames= {"email"})})
	public class Users {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
		@Column(name="fname",nullable=false)
		private String fname;
		@Column(name="lname",nullable=false)
		private String lname;
		@Column(name="email",nullable=false)
		private String email;
		@Column(name="password",nullable=false)
		private String password;
		@Column(name="gender",nullable=false)
		private String gender;
		@Column(name="dob",nullable=false)
		private LocalDate dob;
		@Column(name="contact",nullable=false)
		private String contact;
		@Column(name="address",nullable=false)
		private String address;
		@Column(name="bloodgroup",nullable=false)
		private String bloodgroup;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public LocalDate getDob() {
			return dob;
		}
		public void setDob(LocalDate dob) {
			this.dob = dob;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getBloodgroup() {
			return bloodgroup;
		}
		public void setBloodgroup(String bloodgroup) {
			this.bloodgroup = bloodgroup;
		}
		@Override
		public String toString() {
			return "Users [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
					+ password + ", gender=" + gender + ", dob=" + dob + ", contact=" + contact + ", address=" + address
					+ ", bloodgroup=" + bloodgroup + ", getId()=" + getId() + ", getFname()=" + getFname()
					+ ", getLname()=" + getLname() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
					+ ", getGender()=" + getGender() + ", getDob()=" + getDob() + ", getContact()=" + getContact()
					+ ", getAddress()=" + getAddress() + ", getBloodgroup()=" + getBloodgroup() + ", getClass()="
					+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}	
		
	}

