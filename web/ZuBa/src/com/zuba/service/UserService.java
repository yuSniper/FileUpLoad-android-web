package com.zuba.service;

import com.zuba.dao.UserDao;
import com.zuba.dao.UserDaoImple;
import com.zuba.moclass.User;


public class UserService {

	public User login(User user) {
		UserDao logindao = new UserDaoImple();
		return logindao.login(user);
	}
	
	public User register(User user) {
		UserDao registerdao = new UserDaoImple();
		return registerdao.register(user);
	}
	
	public User update(User user){
		UserDao updatedao = new UserDaoImple();
		return updatedao.update_info(user);
	}
	
	public User selectId(User user){
		UserDao selectid = new UserDaoImple();
		return selectid.selectid(user);
	}
}
