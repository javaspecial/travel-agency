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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author toxic-pc
 *
 */
@Entity()
@Table(name = "USER_PERMISSION")
public class UserPermission implements Serializable {
	private static final long serialVersionUID = 1L;
	public final static UserPermission CREATE_TICKET = new UserPermission("Create New Ticket");
	public final static UserPermission VIEW_ALL_OPEN_TICKETS = new UserPermission("View All Open Ticket");
	public final static UserPermission VOID_TICKET = new UserPermission("Void Ticket");
	public final static UserPermission VIEW_BACK_OFFICE = new UserPermission("View Back Office");
	public final static UserPermission PERFORM_ADMINISTRATIVE_TASK = new UserPermission("Perform Administrative Task");
	public final static UserPermission PERFORM_MANAGER_TASK = new UserPermission("Perform Manager Task");
	public final static UserPermission AUTHORIZE_TICKETS = new UserPermission("Authorize Tickets");
	public final static UserPermission DRAWER_ASSIGNMENT = new UserPermission("Drawer Assignment");
	public final static UserPermission DRAWER_PULL = new UserPermission("Drawer Pull");
	public final static UserPermission SPLIT_TICKET = new UserPermission("Split Ticket");
	public final static UserPermission SETTLE_TICKET = new UserPermission("Settle Ticket");
	public final static UserPermission REOPEN_TICKET = new UserPermission("Reopen Ticket");
	public final static UserPermission PAY_OUT = new UserPermission("Pay Out");
	public final static UserPermission SHUT_DOWN = new UserPermission("Shut Down");
	public final static UserPermission ADD_DISCOUNT = new UserPermission("Add Discount");
	public final static UserPermission REFUND = new UserPermission("Refund");
	public final static UserPermission VIEW_EXPLORERS = new UserPermission("View Explorers");
	public final static UserPermission VIEW_REPORTS = new UserPermission("View Reports");
	public final static UserPermission MANAGE_TABLE_LAYOUT = new UserPermission("Manage Table Layout");
	public final static UserPermission TABLE_BOOKING = new UserPermission("Booking");
	public final static UserPermission MODIFY_PRINTED_TICKET = new UserPermission("Modify Printed Ticket");
	public final static UserPermission TRANSFER_TICKET = new UserPermission("Transfer Ticket");
	public final static UserPermission KITCHEN_DISPLAY = new UserPermission("Kitchen Display");
	public final static UserPermission ALL_FUNCTIONS = new UserPermission("All Functions");
	public final static UserPermission HOLD_TICKET = new UserPermission("Hold Ticket");
	public final static UserPermission VIEW_ALL_CLOSE_TICKETS = new UserPermission("View All Close Tickets");
	public final static UserPermission QUICK_MAINTENANCE = new UserPermission("Quick Maintenance");

	public final static UserPermission[] permissions = new UserPermission[] { VIEW_ALL_OPEN_TICKETS, CREATE_TICKET,
			VOID_TICKET, VIEW_BACK_OFFICE, AUTHORIZE_TICKETS, SPLIT_TICKET, SETTLE_TICKET, REOPEN_TICKET, PAY_OUT,
			DRAWER_ASSIGNMENT, DRAWER_PULL, VIEW_EXPLORERS, VIEW_REPORTS, SHUT_DOWN, ADD_DISCOUNT, REFUND,
			PERFORM_MANAGER_TASK, PERFORM_ADMINISTRATIVE_TASK, MANAGE_TABLE_LAYOUT, TABLE_BOOKING,
			MODIFY_PRINTED_TICKET, TRANSFER_TICKET, KITCHEN_DISPLAY, ALL_FUNCTIONS, HOLD_TICKET, VIEW_ALL_CLOSE_TICKETS,
			QUICK_MAINTENANCE };

	public final static String USER_PERMISSION_ID = "userPermissionId";
	public final static String USER_PERMISSION = "userPermission";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = USER_PERMISSION_ID, unique = true, nullable = false)
	private Integer userPermissionId;

	@Column(name = USER_PERMISSION)
	private String userPermission;

	@Column(name = UserType.USER_TYPE_ID, insertable = false, updatable = false, nullable = false)
	private Integer userTypeId;

	public UserPermission() {
	}

	public UserPermission(String userPermission) {
		this.userPermission = userPermission;
	}

	/**
	 * @return the userTypeId
	 */
	public Integer getUserTypeId() {
		return userTypeId;
	}

	/**
	 * @param userTypeId
	 *            the userTypeId to set
	 */
	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	/**
	 * @return the userPermissionId
	 */
	public Integer getUserPermissionId() {
		return userPermissionId;
	}

	/**
	 * @param userPermissionId
	 *            the userPermissionId to set
	 */
	public void setUserPermissionId(Integer userPermissionId) {
		this.userPermissionId = userPermissionId;
	}

	/**
	 * @return the userPermission
	 */
	public String getUserPermission() {
		return userPermission;
	}

	/**
	 * @param userPermission
	 *            the userPermission to set
	 */
	public void setUserPermission(String userPermission) {
		this.userPermission = userPermission;
	}
}
