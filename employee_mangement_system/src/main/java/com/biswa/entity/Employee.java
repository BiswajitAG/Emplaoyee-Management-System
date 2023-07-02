package com.biswa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table (name = "employee")
public class Employee {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name ="Id")
		private int id;
		
		@Column(name ="Fitst_Name",length = 100,nullable = false)
		private String fname;
		
		@Column(name = "Last_Name", length = 100,nullable = false)
		private String lname;
		
		@Column(name ="mail_id", nullable =  false,unique = true)
		private String mailid;
		
		@Column(name= "mobile",length =12, nullable =  false,unique = true)
		private String mobile;
		
		@JsonIgnore
		@Column(name= "password",length =50)
		private String password;

		@Column(name= "gender",length =10)
		private String gender;
		
		@JsonFormat(pattern = "dd/MM/yyyy")
		@Column(name= "dob")
		private LocalDate dob;
		
		@Column(name = "address_id", insertable = false,updatable = false)
		private int addressid;
		
		@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a")
		@CreationTimestamp
		private LocalDateTime crateDateTime;
		
		@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a")
		@UpdateTimestamp
		private LocalDateTime updateDateTime;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name= "address_id")
		Address address;
		
		
}
