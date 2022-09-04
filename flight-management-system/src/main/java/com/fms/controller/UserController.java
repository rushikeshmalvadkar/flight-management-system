package com.fms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.fms.dto.FmsResponseBody;
import com.fms.entity.UserEntity;
import com.fms.expection.UserNotFoundException;
import com.fms.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userServise;

	@PostMapping("/users")
	public FmsResponseBody<UserEntity> addUser(@RequestBody UserEntity userEntity) throws IOException {
		UserEntity savedUser = userServise.addUser(userEntity);
		return new FmsResponseBody<>(savedUser, HttpStatus.OK.value());
	}

	@GetMapping("/users/{userName}")
	public FmsResponseBody<UserEntity> getUserByUserName(@PathVariable String userName) {
		UserEntity user = null;
		try {
			user = this.userServise.getUserByUserName(userName);
		} catch (UserNotFoundException e) {
			return new FmsResponseBody<>(e.getMessage(), HttpStatus.NOT_FOUND.value());
		}
		return new FmsResponseBody<>(user, HttpStatus.OK.value());
	}

	@GetMapping("/users")
	public List<UserEntity> getAllUser() {
		return this.userServise.getAllUser();

	}

	@GetMapping("/user/{id}")
	public FmsResponseBody<UserEntity> getUserById(@PathVariable String id) {

		UserEntity user;
		try {
			user = this.userServise.getUserById(id);
		} catch (UserNotFoundException e) {
			return new FmsResponseBody<>(e.getMessage(), HttpStatus.NOT_FOUND.value());
		}

		return new FmsResponseBody<>(user, HttpStatus.OK.value());

	}

	@PutMapping("/users")
	public FmsResponseBody<UserEntity> updateUser(@RequestBody UserEntity userEntity) {
		UserEntity updateUser = this.userServise.updateUser(userEntity);
		return new FmsResponseBody<>(updateUser, HttpStatus.OK.value());
	}

	@DeleteMapping("/users/{id}")
	public FmsResponseBody<Boolean> deleteUserById(@PathVariable String id) {
		try {
			this.userServise.deleteUserById(id);
		} catch (UserNotFoundException e) {
			return new FmsResponseBody<>(e.getMessage(), HttpStatus.OK.value());
		}
		return new FmsResponseBody<>(true, HttpStatus.OK.value());
	}

}
