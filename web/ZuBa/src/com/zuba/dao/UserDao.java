package com.zuba.dao;

import com.zuba.moclass.User;

public interface UserDao {

	public User login(User user);
	
	public User register(User user);
	
	public User update_info(User user);
	
	public User selectid(User user);
}
