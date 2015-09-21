package com.zuba.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.zuba.moclass.User;
import com.zuba.utils.JDBCUtils;

public class UserDaoImple implements UserDao {

	public User login(User user) {

		if (user != null) {
			// 创建QueryRunner对象。
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			String sql = "select * from user_table where username = ? and psw = ?";
			User existUser;
			try {
				existUser = queryRunner.query(sql, new BeanHandler<User>(
						User.class), user.getUsername(), user.getPwd());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("用户登录失败!");
			}
			return existUser;
		}
		return null;
	}

	public User register(User user) {
		if (user != null) {

			// 创建QueryRunner对象。
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			String sql = "select * from user_table where username = ? ";
			User existUser;
			User existUsers = null;
			int checkUser;
			try {
				existUser = queryRunner.query(sql, new BeanHandler<User>(
						User.class), user.getUsername());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("用户注册失败!");
			}
			if (existUser == null) {
				// 假如existUser不存在则insert
				String sqls = "insert into user_table (id,username,psw) values (null,?,?)";
				try {
					Object[] params = new Object[] { user.getUsername(),
							user.getPwd() };

					checkUser = queryRunner.update(sqls, params);

					// checkUser = queryRunner.query(sqls, new
					// BeanHandler<User>(User.class),
					// user.getUsername(),user.getPassword());
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("用户注册失败!");
				}

				// 将checkUser转换成User
				String sql2 = "select * from user_table where username = ? and psw = ?";

				try {
					existUsers = queryRunner.query(sql2, new BeanHandler<User>(
							User.class), user.getUsername(), user.getPwd());
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("用户注册失败!");
				}

			}
			return existUsers;
		}
		return null;
	}

	@Override
	public User update_info(User user) {
		if (user != null) {
			// 创建QueryRunner对象。
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

			String sql = "update user_table set headpicture = ?,nickname = ?, name = ?, job = ?, age = ?, sex = ?, address = ? where username = ?";
			User existUser = null;

			Object[] params = new Object[] { user.getHeadpicture(),
					user.getNickname(), user.getName(), user.getJob(),
					user.getAge(), user.getSex(), user.getAddress(),
					user.getUsername() };
			try {

				queryRunner.update(sql, params);
				existUser = user;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("用户登录失败!");
			}

			return existUser;
		}
		return null;
	}

	@Override
	public User selectid(User user) {

		if (user != null) {
			// 创建QueryRunner对象。
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			String sql = "select id from user_table where username = ?";
			User existUser;
			try {
				existUser = queryRunner.query(sql, new BeanHandler<User>(
						User.class), user.getUsername());
				System.out.println("selectid:" + existUser);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("用户登录失败!");
			}
			return existUser;
		}
		return null;

	}

}
