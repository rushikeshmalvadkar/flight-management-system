package com.fms.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.fms.enums.Role;
import com.fms.enums.Status;

/**
 * 
 * @author Rushikesh MALVADKAR
 *
 */

@Entity
public class UserEntity {

	/**
	 * this is id of user or admin
	 */
	@Id
	@Column(name = "ID")
	private String Id;

	/**
	 * name of user or admin
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * This is the username of user or admin
	 */

	@Column(name = "USER_NAME")
	private String userName;

	/**
	 * this is the password of user or admin
	 */
	@Column(name = "PASSWORD")
	private String password;
    
	/**
	 * when this user created
	 */
	@Column(name = "CREATEDON")
	private LocalDateTime createdOn;
	
	/**
	 * date when user updated
	 */
	private LocalDateTime updatedOn;
	
	/**
	 * role of user customers or admin
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE")
	private Role role;
	
	/**
	 * status of user active or nonactive
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "ACTIVE_STATUS")
	private Status status;

	public UserEntity() {

	}
	
    /**
     * get the id of user
     * @return id
     */
	public String getId() {
		return Id;
	}
	
     /**
      * set id
      * @param id
      */
	public void setId(String id) {
		this.Id = id;
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

}
