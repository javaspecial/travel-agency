package com.service;

import java.util.List;

import com.model.User;

public interface UsersService {
	public List<User> list();

	public boolean delete(User User);

	public boolean saveOrUpdate(User User);

	public boolean save(User User) throws Exception;

	public boolean validateUser(String username, String password) throws Exception;

	public boolean existEmail(String string);

	public String getCurrentUserByEmail(String userEmail);

}