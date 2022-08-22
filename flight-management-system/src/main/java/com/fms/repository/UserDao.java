package com.fms.repository;

import java.util.List;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fms.entity.UserEntity;
import com.fms.expection.UserNotFoundException;
import com.ruishanio.Ksuid;

@Repository
public class UserDao {

	@Autowired
	private EntityManager emt;

	public UserEntity addUser(UserEntity userEntity) throws IOException {
		Ksuid ksuid = new Ksuid();
		String id = ksuid.generate();
		userEntity.setId(id);
		userEntity.setUpdatedOn(LocalDateTime.now());
		userEntity.setCreatedOn(LocalDateTime.now());
		this.emt.persist(userEntity);
		return userEntity;
	}

	public UserEntity getUserByUserName(String userName) {
		TypedQuery<UserEntity> query = this.emt.createQuery("select u from UserEntity  u where u.userName= :u",
				UserEntity.class);
		query.setParameter("u", userName);
		UserEntity user = null;
		try {
			user = query.getSingleResult();
		} catch (NoResultException e) {
           throw new UserNotFoundException("User Not found with userName"+ userName);
		}
		return null;

	}

	public UserEntity getUserById(String id) throws UserNotFoundException {
		TypedQuery<UserEntity> query = this.emt.createQuery("select u from UserEntity u where Id = :id",
				UserEntity.class);
		query.setParameter("id", id);
		UserEntity user = null;
		try {
			user = query.getSingleResult();
		} catch (NoResultException e) {
			throw new UserNotFoundException("User not found with id : " + id);
		}
		return user;
	}

	public List<UserEntity> getAllUser() {
		TypedQuery<UserEntity> query = this.emt.createQuery("select u from UserEntity u", UserEntity.class);
		return query.getResultList();

	}

	public UserEntity updateUser(UserEntity userEntity) {
		userEntity.setUpdatedOn(LocalDateTime.now());
		this.emt.merge(userEntity);
		return userEntity;
	}
	
	public void deleteUserById(String id){
		UserEntity user = getUserById(id);
		this.emt.remove(user);
	  
		
	}
	

}
