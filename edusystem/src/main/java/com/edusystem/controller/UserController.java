package com.edusystem.controller;

import java.util.List;

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

import com.edusystem.entity.User;
import com.edusystem.model.UserLoginRequest;
import com.edusystem.model.UserLoginResponse;
import com.edusystem.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/save")
	public ResponseEntity<User> addUser(@RequestBody User user) {

		User newUser = userService.saveUser(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(newUser, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<User> fetchUsers(@PathVariable("userId") int userId) {

		User user = userService.getUserById(userId);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/user/all")
	public List<User> fetchAllUsers() {

		List<User> userList = userService.getAllUsers();
		return userList;
	}

	@PutMapping("/user/update")
	public ResponseEntity<User> modifyUser(@RequestBody User user) {

		User updatedUser = userService.updateUser(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(updatedUser, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/user/delete/{userId}")
	public ResponseEntity<String> removeUser(@PathVariable("userId") int userId) {

		userService.deleteUser(userId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("User Deleted Successfully.", HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/user/login")
	public ResponseEntity<UserLoginResponse> singin(@RequestBody UserLoginRequest loginReq) {

		User user1 = userService.doLogin(loginReq.getUserId(), loginReq.getUserPassword());

		UserLoginResponse loginResp = new UserLoginResponse();
		loginResp.setUserId(user1.getUserId());
		loginResp.setUserName(user1.getUserName());
		loginResp.setUserRole(user1.getUserRole());

		ResponseEntity<UserLoginResponse> responseEntity = new ResponseEntity<>(loginResp, HttpStatus.OK);
		return responseEntity;
	}

}
