package com.fms.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.entity.UserEntity;
import com.fms.exception.UserNotFoundException;
import com.fms.repository.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public UserEntity addUser(UserEntity userEntity) throws IOException {
		return userDao.addUser(userEntity);
	}

	public UserEntity getUserByUserName(String userName) {
		return this.userDao.getUserByUserName(userName);
	}

	public UserEntity getUserById(String id) {
        return  this.userDao.getUserById(id);
         
	}

	public List<UserEntity> getAllUser() {
		return this.userDao.getAllUser();
	}

	@Transactional
	public UserEntity updateUser(UserEntity userEntity) {
		return this.userDao.updateUser(userEntity);

	}
	@Transactional
	public void deleteUserById(String id) {
		this.userDao.deleteUserById(id);
	}
}