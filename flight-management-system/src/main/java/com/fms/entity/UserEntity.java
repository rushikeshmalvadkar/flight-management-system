package com.fms.entity;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fms.enums.Role;
import com.fms.enums.Status;
import com.ruishanio.Ksuid;

/**
 * Responsible to represent user
 * 
 * @author RUSHIKESH MALVADKAR
 *
 */
@Entity
@Table(name = "user_details")
public class UserEntity {

	/**
	 * The user id
	 */
	@Id
	@Column(name = "ID")
	private String id;

	/**
	 * The name of user
	 */
	@Column(name = "NAME" , nullable = false)
	private String name;

	/**
	 * The user name
	 */

	@Column(name = "USER_NAME" , nullable = false)
	private String userName;

	/**
	 * The password
	 */
	@Column(name = "PASSWORD" , nullable = false)
	private String password;
    
	/**
	 * The created on time
	 */
	@Column(name = "CREATED_ON" , nullable = false)
	private LocalDateTime createdOn;
	
	/**
	 * The updated on time
	 */
	@Column(name = "UPDATED_ON" , nullable = false)
	private LocalDateTime updatedOn;
	
	/**
	 * The role of user
	 */
	@Enumerated(EnumType.STRING )
	@Column(name = "ROLE" , nullable = false)
	private Role role;
	
	/**
	 * The status of user
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "ACTIVE_STATUS" , nullable = false)
	private Status status;
	
    /**
     * get the id of user
     * @return id
     */
	public String getId() {
		return id;
	}
	
     /**
      * set id
      * @param id
      */
	public void setId(String id) {
		this.id = id;
	}
	
    /**
     * getname of user
     * @return the name of user
     */
	public String getName() {
		return name;
	}
	
   /**
    *  set the name of user  
    * @param name
    */
	public void setName(String name) {
		this.name = name;
	}
     
	/**
	 * get the name of user
	 * @return name of user
	 */
	public String getUserName() {
		return userName;
	}
	
      /**
       * set the userNmae
       * @param userName
       */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
     /**
      * get password 
      * @return userpassword
      */
	public String getPassword() {
		return password;
	}
	
    /**
     * set user password
     * @param password
     */
	public void setPassword(String password) {
		this.password = password;
	}
	
     /**
      * get date when user created
      * @return  createddate
      */
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	
    /**
     * set when user created
     * @param createdOn
     */
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	
    /**
     * get date when user updated
     * @return updatedOn
     */
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	
    /**
     * set the when updated this user
     * @param updatedOn
     */
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
    
	/**
	 * get role of user admin or customer
	 * @return
	 */
	public Role getRole() {
		return role;
	}
	
    /**
     * set role it is admin or customer
     * @param role
     */
	public void setRole(Role role) {
		this.role = role;
	}
	
     /**
      * get status of user active or nonactive
      * @return status
      */
	public Status getStatus() {
		return status;
	}
	
   /**
    * set status of user either coustomer or admin
    * @param status
    */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	@PrePersist
	public void beforeInsert() throws IOException  {
		Ksuid ksuid = new Ksuid();
		this.id = ksuid.generate();
		this.createdOn = LocalDateTime.now();
		this.updatedOn = LocalDateTime.now();
	}

}
