package com.axsos.license.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;


//...
@Entity
@Table(name="licenses")
public class License {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private Integer number;
@DateTimeFormat(pattern="yyyy-MM-dd")
 private Date expirationDate;
@NotNull
 private String state;
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
 @NotNull
 @OneToOne(fetch=FetchType.LAZY)
 @JoinColumn(name="person_id")
 private Person person;
 public License() {
     
 }
 
public License( Integer number,Date expirationDate, String state, Person person) {
	super();
	this.number = number;
	this.expirationDate = expirationDate;
	this.state = state;
	this.person = person;
}

public Integer getNumber() {
	return number;
}
public void setNumber(Integer number) {
	this.number = number;
}
public String getNumberAsString() {
	StringBuilder zeros = new StringBuilder("");
	for(int i=0;i<6-this.number.toString().length();i++)
		zeros.append(0);
	zeros.append(this.number);
	return zeros.toString();
}
public Date getExpirationDate() {
	return expirationDate;
}
public void setExpirationDate(Date expirationDate) {
	this.expirationDate = expirationDate;
}
public String getExpirationDateFormat() {
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	return df.format(this.expirationDate);

}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public Person getPerson() {
	return person;
}
public void setPerson(Person person) {
	this.person = person;
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
