package com.lms.demo.user.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lms.demo.user.demo.converter.LMSUserEntityConverter;
import com.lms.demo.user.demo.dto.UserInfoDTO;
import com.lms.demo.user.demo.entity.Tbl_lms_user;
import com.lms.demo.user.demo.jpa.repository.UserRepository;

/**
 * @author shital
 * This class is service class having service layer operations.
 *
 */
@Service
public class UserDAOService {

	@Autowired
	UserRepository repository;
	@Autowired 
	LMSUserEntityConverter converter;
	
	public List<Tbl_lms_user> findAll() {
		
		
		List<Tbl_lms_user> userList = repository.findAll();
		List<Tbl_lms_user> returnList = converter.getAllUsers(userList);
		return returnList;
	}
	public UserInfoDTO createUser(Tbl_lms_user newUser) {
		String methodName = "POST";
		Tbl_lms_user lmsUser = converter.enityToDtoForPost(newUser);
		//Tbl_lms_user customUser= converter.dtoToEntity(lmsUser);
		Tbl_lms_user savedUser = repository.saveAndFlush(lmsUser);
		return converter.customMsgObject(savedUser,methodName);
		
	}
	public Tbl_lms_user finOneUser(String id) throws JsonProcessingException {
		Tbl_lms_user userDTO = new Tbl_lms_user();
		userDTO = converter.enityToDtoGetoneUser(repository.findById(id).get());
		return userDTO;
	}
	public UserInfoDTO updateUser(Tbl_lms_user newUser) {
		String methodName = "UPDATE";
		Tbl_lms_user lmsUser =repository.findById(newUser.getUser_id()).get(); 
		Tbl_lms_user updateUser = converter.enityToDtoForUpdate(lmsUser,lmsUser.getCreation_time());
		Tbl_lms_user updatedUser = repository.save(updateUser);
		return converter.customMsgObject(updatedUser,methodName); 
	}

	public void deleteUser(String id) {
		System.out.println("id"+id);
		
		repository.delete(repository.getById(id));
		
	}
	 
	
}
