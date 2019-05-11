package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "USERS")
public class User {
	public final static String USER_ID = "userId";
	public final static String USER_PASSWORD = "password";
	public final static String USER_EMAIL = "email";
	public static final String USER_NAME = "userName";
	public static final String USER_STATUS_ID = "userStatusId";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = USER_ID, unique = true, nullable = false)
	private Integer userId;

	@Column(name = USER_PASSWORD, unique = true, length = 50)
	private String password;

	@Column(name = USER_EMAIL, unique = true)
	private String email;

	@Column(name = USER_NAME)
	private String userName;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = UserType.USER_TYPE_ID, referencedColumnName = UserType.USER_TYPE_ID)
	private UserType userType;

	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = USER_STATUS_ID)
	private List<Status> status;

	public User() {

	}

	public User(UserType userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer user_id) {
		this.userId = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean hasPermission(UserPermission permission) {
		return getUserType().hasPermission(permission);
	}

	public boolean isAdministrator() {
		return hasPermission(UserPermission.PERFORM_ADMINISTRATIVE_TASK);
	}
}