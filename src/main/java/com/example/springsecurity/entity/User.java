package com.example.springsecurity.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

// ORM - Object Relation Mapping

@Data
@Entity
public class User {

////	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id // primary key
	private BigDecimal id;

	private String username;

	private String password;

	private String email;

	private String role; //ROLE_USER, ROLE_ADMIN

	@CreationTimestamp
	private Timestamp createDate;
}
