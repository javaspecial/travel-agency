package com.dao;

import java.util.List;

import com.model.Location;

public interface LocationDao {
	public List<Location> getListOfLocation();

	public boolean save(Location location) throws Exception;
}
