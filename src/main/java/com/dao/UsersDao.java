package com.dao;

import java.util.List;

import com.model.User;

public interface UsersDao {
	public List<User> list();

	public boolean delete(User User);

	public boolean saveOrUpdate(User User);

	public boolean save(User User) throws Exception;

	public boolean validateUser(String username, String password) throws Exception;

	public boolean existEmail(String User);

	public String getCurrentUserByEmail(String userEmail);
}
