package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LocationDao;
import com.model.Location;
import com.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	LocationDao locationDao;

	@Override
	public List<Location> getListOfLocation() {
		return locationDao.getListOfLocation();
	}

	@Override
	public boolean save(Location location) throws Exception {
		return locationDao.save(location);
	}

}
