package com.axsos.license.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

//...
@Entity
@Table(name="persons")
public class Person {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @NotNull
 private String firstName;
 @NotNull
 private String lastName;
 @Column(updatable=false)
 @DateTimeFormat(pattern="yyyy-MM-dd")
 private Date createdAt;
 @DateTimeFormat(pattern="yyyy-MM-dd")
 private Date updatedAt;
	@PrePersist
 protected void onCreate(){
     this.createdAt = new Date();
 }
	@PreUpdate
 protected void onUpdate(){
     this.updatedAt = new Date();
 }
 @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
 private License license;
 
 public Person() {
     
 }

public Person(String firstName, String lastName, License license) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.license = license;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public License getLicense() {
	return license;
}

public void setLicense(License license) {
	this.license = license;
}

public Long getId() {
	return id;
}

public Date getCreatedAt() {
	return createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}
 
}
