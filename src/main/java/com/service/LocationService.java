package com.service;

import java.util.List;

import com.model.Location;

public interface LocationService {
	public List<Location> getListOfLocation();

	public boolean save(Location location) throws Exception;
}
