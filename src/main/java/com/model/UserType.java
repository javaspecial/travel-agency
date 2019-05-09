/**
 * ************************************************************************
 * * The contents of this file are subject to the MRPL 1.2
 * * (the  "License"),  being   the  Mozilla   Public  License
 * * Version 1.1  with a permitted attribution clause; you may not  use this
 * * file except in compliance with the License. You  may  obtain  a copy of
 * * the License at http://www.softpos.org/license.html
 * * Software distributed under the License  is  distributed  on  an "AS IS"
 * * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * * License for the specific  language  governing  rights  and  limitations
 * * under the License.
 * * The Original Code is SOFT POS.
 * * All Rights Reserved.
 * ************************************************************************
 */
package com.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author toxic-pc
 *
 */
@Entity()
@Table(name = "USER_TYPE")
public class UserType {
	public final static String USER_TYPE_ID = "userTypeId";
	public final static String USER_TYPE_NAME = "userTypeName";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = USER_TYPE_ID, unique = true, nullable = false)
	private Integer userTypeId;

	@Column(name = USER_TYPE_NAME)
	private String userTypeName;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = USER_TYPE_ID, insertable = false, updatable = false, nullable = false)
	private Set<UserPermission> userPermission;

	public UserType() {
	}

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public Set<UserPermission> getUserPermission() {
		return userPermission;
	}

	public void setUserPermission(Set<UserPermission> userPermission) {
		this.userPermission = userPermission;
	}

	public boolean hasPermission(UserPermission permission) {
		Set<UserPermission> permissions = getUserPermission();
		if (permissions == null)
			return false;
		for (UserPermission permissionPrint : permissions) {
			if (permissionPrint.getUserPermission().equals(permission.getUserPermission()))
				return true;
		}
		return false;
	}

}
