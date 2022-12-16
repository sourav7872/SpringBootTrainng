package com.sparc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="doctor_tab",schema = "healthcare")
@Data
@AllArgsConstructor//for generating all argument constructor
@NoArgsConstructor
@RequiredArgsConstructor
//@JsonIncludeProperties(value = {"firstName","lastName"})
public class Doctor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="doc_id_col")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="doc_fn_col")
	@NonNull
	private String firstName;
	
	@Column(name="doc_ln_col")
	@NonNull
	private String lastName;
	
	@Column(name="doc_mail_col")
	@NonNull
	private String email;
	
	@Column(name="doc_addr_col")
	private String address;
	
	@Column(name="doc_mob_col")
	private String mobile;
	
	@Column(name="doc_gen_col")
	private String gender;
	
	@Column(name="doc_note_col")
	private String note;
	
	@Column(name="doc_img_col")
	private String photoLoc;
	
	
	//----------Association Mapping------------------
	@ManyToOne
	@JoinColumn(name="spec_id_fk_col",nullable = false)
	@JsonIncludeProperties(value = {"id","specName"})
	//@JsonIgnore
	private Specialization specialization; //HAS-A


	/*
	 * public Long getId() { return id; }
	 * 
	 * 
	 * public void setId(Long id) { this.id = id; }
	 * 
	 * 
	 * public String getFirstName() { return firstName; }
	 * 
	 * 
	 * public void setFirstName(String firstName) { this.firstName = firstName; }
	 * 
	 * 
	 * public String getLastName() { return lastName; }
	 * 
	 * 
	 * public void setLastName(String lastName) { this.lastName = lastName; }
	 * 
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 * 
	 * 
	 * public String getAddress() { return address; }
	 * 
	 * 
	 * public void setAddress(String address) { this.address = address; }
	 * 
	 * 
	 * public String getMobile() { return mobile; }
	 * 
	 * 
	 * public void setMobile(String mobile) { this.mobile = mobile; }
	 * 
	 * 
	 * public String getGender() { return gender; }
	 * 
	 * 
	 * public void setGender(String gender) { this.gender = gender; }
	 * 
	 * 
	 * public String getNote() { return note; }
	 * 
	 * 
	 * public void setNote(String note) { this.note = note; }
	 * 
	 * 
	 * public String getPhotoLoc() { return photoLoc; }
	 * 
	 * 
	 * public void setPhotoLoc(String photoLoc) { this.photoLoc = photoLoc; }
	 * 
	 * 
	 * public Specialization getSpecialization() { return specialization; }
	 * 
	 * 
	 * public void setSpecialization(Specialization specialization) {
	 * this.specialization = specialization; }
	 */
	

	
}
