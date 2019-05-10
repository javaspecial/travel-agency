package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATION")
public class Location {
	public static final String LOCATION_ID = "locationId";
	public static final String LOCATION = "locationName";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = LOCATION_ID, unique = true, nullable = false)
	private Integer locationId;

	@Column(name = LOCATION, length = 255)
	private String locationName;

	public Location() {
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
}
