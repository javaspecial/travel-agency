package com.dao;

import java.util.List;

import com.model.Status;

public interface StatusDao {
	public List<Status> list();

	public boolean delete(Status status);

	public boolean update(Status status);

	public boolean save(Status status) throws Exception;

	public Status getStatusById(Integer statusId);

	public List<Status> listOfStatusByUserId(String userId);
}
