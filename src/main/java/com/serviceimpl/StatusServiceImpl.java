package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StatusDao;
import com.model.Status;
import com.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	StatusDao statusDao;

	@Override
	public List<Status> list() {
		return statusDao.list();
	}

	@Override
	public boolean delete(Status status) {
		return statusDao.delete(status);
	}

	@Override
	public boolean update(Status status) {
		return statusDao.update(status);
	}

	@Override
	public boolean save(Status status) throws Exception {
		return statusDao.save(status);
	}

	@Override
	public Status getStatusById(Integer statusId) {
		return statusDao.getStatusById(statusId);
	}

	@Override
	public List<Status> listOfStatusByUserId(String userId) {
		return statusDao.listOfStatusByUserId(userId);
	}

}
