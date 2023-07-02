package com.biswa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="add_id")
	private int Id;
	
	private String address1;
	private String address2;
	private String country;
	private String state;
	private String dist;
	private String pin;
	
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a")
	@CreationTimestamp
	private LocalDateTime crateDateTime;
	
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a")
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

}
