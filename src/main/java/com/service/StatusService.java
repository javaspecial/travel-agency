package com.service;

import java.util.List;

import com.model.Status;

public interface StatusService {
	public List<Status> list();

	public boolean delete(Status status);

	public boolean update(Status status);

	public boolean save(Status status) throws Exception;

	public Status getStatusById(Integer valueOf);

	public List<Status> listOfStatusByUserId(String userId);
}
