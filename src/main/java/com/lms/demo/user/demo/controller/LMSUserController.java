package com.lms.demo.user.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lms.demo.user.demo.dto.UserInfoDTO;
import com.lms.demo.user.demo.entity.Tbl_lms_user;
import com.lms.demo.user.demo.service.UserDAOService;

/**
 * @author Administrator
 * This is controller class for handling User API requests
 *
 */
@RestController

public class LMSUserController {

	
	@Autowired
	private UserDAOService userDaoservice;
	
	
	

	@GetMapping("/Users")
	public ResponseEntity<List<Tbl_lms_user>> retrieveAllUsers() {
		List<Tbl_lms_user> returnList = userDaoservice.findAll();
		if(returnList.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(returnList));
	}

	
	@GetMapping("/Users/{id}")
	public ResponseEntity<Tbl_lms_user> findoneuser(@Valid @PathVariable String id) throws JsonProcessingException  {
		Tbl_lms_user lms_user =  userDaoservice.finOneUser(id);
		if(lms_user == null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(lms_user));
	}
	
	
	
	
	 
	@PostMapping("/Users")
	public ResponseEntity<UserInfoDTO> createUser(@Valid @RequestBody Tbl_lms_user newUser) {
		UserInfoDTO lms_user = new UserInfoDTO();
		if(newUser == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		lms_user= userDaoservice.createUser(newUser);
		
		return ResponseEntity.of(Optional.of(lms_user));
	}

	
	@PutMapping("/Users/{id}")
	public ResponseEntity<UserInfoDTO> updateUser(@Valid @RequestBody Tbl_lms_user newUser, @Valid @PathVariable String id) {
		
		UserInfoDTO lms_user = userDaoservice.updateUser(newUser);
		if(lms_user == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.of(Optional.of(lms_user));
	}
	
	@DeleteMapping("/User/{id}")
	public ResponseEntity<String> deleteUser(@Valid @PathVariable String id) {
		if(id!= null) {
		userDaoservice.deleteUser(id);
		return ResponseEntity
	            .status(HttpStatus.CREATED)                 
	            .body(id+" " +"Deleted");
	} else {
		return new ResponseEntity<String>(id, HttpStatus.NOT_FOUND);
	}
		
		
}
}