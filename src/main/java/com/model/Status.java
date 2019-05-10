package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STATUS")
public class Status {
	public static final String STATUS_ID = "statusId";
	public static final String STATUS_PRIVACY = "statusPrivacy";
	public static final String STATUS_DISPLAY_TEXT = "statusDisplayText";
	public static final String STATUS_LOCATION = "statusLocation";
	private static final String USER = "user";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = STATUS_ID, unique = true, nullable = false)
	private Integer statusId;

	@Column(name = STATUS_PRIVACY, length = 20)
	private String statusPrivacy;

	@Column(name = STATUS_DISPLAY_TEXT, length = 255)
	private String statusDisplayText;

	@Column(name = STATUS_LOCATION, length = 255)
	private String statusLocation;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = USER, referencedColumnName = User.USER_ID)
	private User user;

	public Status() {
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusPrivacy() {
		return statusPrivacy;
	}

	public void setStatusPrivacy(String statusPrivacy) {
		this.statusPrivacy = statusPrivacy;
	}

	public String getStatusDisplayText() {
		return statusDisplayText;
	}

	public void setStatusDisplayText(String statusDisplayText) {
		this.statusDisplayText = statusDisplayText;
	}

	public String getStatusLocation() {
		return statusLocation;
	}

	public void setStatusLocation(String statusLocation) {
		this.statusLocation = statusLocation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
