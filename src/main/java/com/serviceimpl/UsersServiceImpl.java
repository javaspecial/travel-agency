package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UsersDao;
import com.model.User;
import com.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersDao userDao;

	public boolean save(User users) throws Exception {
		return userDao.save(users);
	}

	public boolean saveOrUpdate(User users) {
		return userDao.saveOrUpdate(users);
	}

	@Transactional
	public List<User> list() {
		return userDao.list();
	}

	public boolean delete(User users) {
		return userDao.delete(users);
	}

	public boolean validateUser(String username, String password) throws Exception {
		return userDao.validateUser(username, password);
	}

	public boolean existEmail(String users) {
		return userDao.existEmail(users);
	}

	@Override
	public String getCurrentUserByEmail(String userEmail) {
		return userDao.getCurrentUserByEmail(userEmail);
	}

}
