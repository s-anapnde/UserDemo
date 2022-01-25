package com.lms.demo.user.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lms.demo.user.demo.config.UserIdGenerator;

/**
 * @author shital
 * This class is a JPA entity class for User table.
 *
 */
@Entity(name = "tbl_lms_user")

@JsonIgnoreProperties(value={ "education_ug", "education_pg","comments","lastname","user_visa_status","creation_time","last_mod_time" })
public class Tbl_lms_user implements Serializable  {
	private static final long serialVersionUID = -3322113303362981686L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
	@GenericGenerator(name = "user_id", strategy = "com.lms.demo.user.demo.config.UserIdGenerator", parameters = {
			@Parameter(name = UserIdGenerator.INCREMENT_PARAM, value = "01"),
			@Parameter(name = UserIdGenerator.VALUE_PREFIX_DEFAULT, value = "U"),
			@Parameter(name = UserIdGenerator.NUMBER_FORMAT_DEFAULT, value = "%1d") })
	private String user_id;
	
	@Column(name ="user_first_name")
	@NotBlank(message = "please specify FirstName")
	private String name;

	
	@Column(name = "user_last_name")
	private String lastname;
	
	@Transient
	@NotBlank
	@Size(min= 10, max=10,message = "phone number must be 10 digits")
	private String phone_number;
	
	@Column(name = "user_phone_number")
	private long phonenumber;
	
	
	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Column(name = "user_location")
	@NotBlank(message = "please specify Location")
	private String location;
	
	@Column(name = "user_time_zone")
	@NotBlank(message = "please specify Time Zone, default value  is 'EST'")
	private String time_zone;
	
	@Column(name = "user_linkedin_url")
	@URL(protocol = "https")
	private String linkedin_url;
	
	@Column(name = "user_edu_ug")
	private String education_ug;
	
	@Column(name = "user_edu_pg")
	private String education_pg;
	
	@Column(name = "user_comments")
	private String comments;

	@Column(name = "user_visa_status")
	@NotBlank(message = "please specify Visa Status default value is 'Not-Specified'")
	private String  visa_status;
	
	@Column(name = "creation_time")
	private LocalDateTime creation_time;
	
	@Column(name = "last_mod_time")
	private LocalDateTime last_mod_time;
	

	
	
	public String getPhone_number() {
		return phone_number;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	
	public Tbl_lms_user() {
		
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setCreation_time(LocalDateTime creation_time) {
		this.creation_time = creation_time;
	}
	
	public void setLast_mod_time(LocalDateTime last_mod_time) {
		this.last_mod_time = last_mod_time;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public LocalDateTime getCreation_time() {
		return creation_time;
	}

	
	public LocalDateTime getLast_mod_time() {
		return last_mod_time;
	}

	public String getTime_zone() {
		return time_zone;
	}

	public String getLinkedin_url() {
		return linkedin_url;
	}

	public String getEducation_ug() {
		return education_ug;
	}

	public String getEducation_pg() {
		return education_pg;
	}

	public String getComments() {
		return comments;
	}
	
	public String getVisa_status() {
		return visa_status;
	}

	
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}

	public void setLinkedin_url(String linkedin_url) {
		this.linkedin_url = linkedin_url;
	}
	
	public void setEducation_ug(String education_ug) {
		this.education_ug = education_ug;
	}
	
	public void setEducation_pg(String education_pg) {
		this.education_pg = education_pg;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public void setVisa_status(String visa_status) {
		this.visa_status = visa_status;
	}

}
