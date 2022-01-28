package com.lms.demo.user.demo.converter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.lms.demo.user.demo.dto.UserInfoDTO;
import com.lms.demo.user.demo.entity.Tbl_lms_user;

/**
 * @author shital
 * This class is helper class is used to have methods which will be used to covert the entity to DTO and DTO to entity class. 
 *
 */
@Component
public class LMSUserEntityConverter {

	public Tbl_lms_user enityToDtoGetoneUser(Tbl_lms_user lms_user) {
		Tbl_lms_user dtoUser = new Tbl_lms_user();
		String fullName = (lms_user.getName()+","+lms_user.getLastname());		
		dtoUser.setName(fullName);
		dtoUser.setCreation_time(LocalDateTime.now());
		dtoUser.setLast_mod_time(LocalDateTime.now());
		dtoUser.setComments(lms_user.getComments());
		dtoUser.setEducation_pg(lms_user.getEducation_pg());
		dtoUser.setEducation_ug(lms_user.getEducation_ug());
		dtoUser.setLinkedin_url(lms_user.getLinkedin_url());
		dtoUser.setLocation(lms_user.getLocation());
		dtoUser.setPhone_number(String.valueOf(lms_user.getPhonenumber()));
		dtoUser.setTime_zone(lms_user.getTime_zone());
		dtoUser.setVisa_status(lms_user.getVisa_status());
		dtoUser.setUser_id(lms_user.getUser_id());
		return dtoUser;
	}

	public UserInfoDTO enityToDto(Tbl_lms_user lms_user) {
		UserInfoDTO dtoUser = new UserInfoDTO();
		dtoUser.setName(lms_user.getName());
		dtoUser.setCreation_time(LocalDateTime.now());
		dtoUser.setLast_mod_time(LocalDateTime.now());
		dtoUser.setComments(lms_user.getComments());
		dtoUser.setEducation_pg(lms_user.getEducation_pg());
		dtoUser.setEducation_ug(lms_user.getEducation_ug());
		dtoUser.setLinkedin_url(lms_user.getLinkedin_url());
		dtoUser.setLocation(lms_user.getLocation());
		dtoUser.setPhone_number(lms_user.getPhone_number());
		dtoUser.setTime_zone(lms_user.getTime_zone());
		dtoUser.setVisa_status(lms_user.getVisa_status());
		dtoUser.setUser_id(lms_user.getUser_id());
		return dtoUser;
	}

	public List<Tbl_lms_user> getAllUsers(List<Tbl_lms_user> userList) {
		return userList.stream().map(x -> enityToDtoGetoneUser(x)).collect(Collectors.toList());
	}

	public Tbl_lms_user enityToDtoUserDetails(Tbl_lms_user lms_user) {
		Tbl_lms_user dtoUser = new Tbl_lms_user();
		dtoUser.setUser_id(lms_user.getUser_id());
		dtoUser.setName(lms_user.getName());
		dtoUser.setLastname(lms_user.getLastname());
		dtoUser.setUser_id(lms_user.getUser_id());
		return dtoUser;
	}

	public Tbl_lms_user enityToDtoForPost(Tbl_lms_user lms_user) {
		Tbl_lms_user dtoUser = new Tbl_lms_user();
		String[] lastName = lms_user.getName().split(",");
		for (int i = 0; i < lastName.length;) {
			dtoUser.setName(lastName[i]);
			dtoUser.setLastname(lastName[i + 1]);
			break;
		}

		dtoUser.setLocation(lms_user.getLocation());
		dtoUser.setPhone_number(String.valueOf(lms_user.getPhone_number()));
		dtoUser.setTime_zone(lms_user.getTime_zone());
		dtoUser.setLinkedin_url(lms_user.getLinkedin_url());
		dtoUser.setEducation_pg(lms_user.getEducation_ug());
		dtoUser.setEducation_ug(lms_user.getEducation_pg());
		dtoUser.setVisa_status(lms_user.getVisa_status());
		dtoUser.setComments(lms_user.getComments());
		if (lms_user.getCreation_time() == null) {
			dtoUser.setCreation_time(LocalDateTime.now());
		}
		if (lms_user.getLast_mod_time() == null) {
			dtoUser.setLast_mod_time(LocalDateTime.now());
		}

		return dtoUser;

	}

	public Tbl_lms_user enityToDtoForUpdate(Tbl_lms_user newUser, LocalDateTime creationTime) {

		Tbl_lms_user returnObject = new Tbl_lms_user();
		returnObject.setUser_id(newUser.getUser_id());
		returnObject.setName(newUser.getName());
		returnObject.setLastname(newUser.getLastname());
		returnObject.setLocation(newUser.getLocation());
		returnObject.setPhonenumber((Long.valueOf(newUser.getPhone_number())));
		returnObject.setTime_zone(newUser.getTime_zone());
		returnObject.setLinkedin_url(newUser.getLinkedin_url());
		returnObject.setEducation_pg(newUser.getEducation_ug());
		returnObject.setEducation_ug(newUser.getEducation_pg());
		returnObject.setVisa_status(newUser.getVisa_status());
		returnObject.setComments(newUser.getComments());
		returnObject.setCreation_time(creationTime);
		returnObject.setLast_mod_time(LocalDateTime.now());
		return returnObject;

	}

	public UserInfoDTO customMsgObject(Tbl_lms_user lmsuser, String methodName) {
		JSONObject responseMsg = new JSONObject();
		UserInfoDTO responseObject = new UserInfoDTO();
		if (methodName.equalsIgnoreCase("POST")) {
			responseObject = enityToDto(lmsuser);
			responseMsg.put(lmsuser.getUser_id(), "User successfully Created!");
			responseObject.setMessage(responseMsg);
		} else if (methodName.equalsIgnoreCase("UPDATE")) {
			responseObject = enityToDto(lmsuser);
			responseMsg.put(lmsuser.getUser_id(), "User Successfully Updated ");
			responseObject.setMessage(responseMsg);

		}
		return responseObject;
	}

}
