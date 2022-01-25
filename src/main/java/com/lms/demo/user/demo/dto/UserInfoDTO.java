package com.lms.demo.user.demo.dto;

import java.time.LocalDateTime;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author shital
 * This class is the Data Transfer Object class for User.
 *
 */

@Component
@JsonIgnoreProperties(value={ "education_ug", "education_pg","comments","lastname","visa_status","creation_time","last_mod_time" })
public class UserInfoDTO {
	
	
	private String user_id;
	private String name;
	private String phone_number;
	private String location;
	private String time_zone;
	private String linkedin_url;
	private String  visa_status;
	private String education_ug;
	private String education_pg;
	private String comments;
	private LocalDateTime creation_time;
	private LocalDateTime last_mod_time;
	private String lastName;
	private JSONObject message;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public JSONObject getMessage() {
		return message;
	}
	public void setMessage(JSONObject message) {
		this.message = message;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public String getLocation() {
		return location;
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
	public void setLocation(String location) {
		this.location = location;
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

	public String getName() {
		return name;
	}
	public void setName(String fullName) {
		this.name = fullName;
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
	public void setCreation_time(LocalDateTime creation_time) {
		this.creation_time = creation_time;
	}
	public void setLast_mod_time(LocalDateTime last_mod_time) {
		this.last_mod_time = last_mod_time;
	}
	
	
	


}
