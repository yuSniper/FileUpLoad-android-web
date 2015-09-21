package com.zuba.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.zuba.moclass.User;
import com.zuba.utils.JDBCUtils;

public class TestData {
	@Test
	public void add() throws SQLException {

		String insert_sql = "insert into user_table values (null,?,?,?,?,?,?,?,?,?)";
		String insert_login_sql = "insert into user_table (id,username,psw) values (null,?,?)";

		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

		// String sql = "delete from user_table where user_name = ?";
		// runner.update(sql, "admin");
		// User user = new User();
		// User u = null;
		// String sql = "select * from user_table where id = ? ";
		// u = runner.query(sql, new BeanHandler<User>(User.class), "1");
		// System.out.println(u.getAddress());
		// for (int i = 1; i <= 10; i++) {
		// runner.update("insert into user_table values (null,'admin', '123', 'realname', '1887001997','1.jpg', '昵称', '攻城狮', '男', 1, '南昌');");
		// }
		runner.update(insert_sql, "张三", "123", "张三",
				"http://localhost:8080.mytest.1jpg", "昵称", "攻城狮", "男", 20, "南昌");
		// for (int i = 1; i <= 20; i++){
		// runner.update(sql, "admin", "123"+i, "realname"+i,
		// "1887001997"+i,i+".jpg", "昵称", "攻城狮", "男", i, "南昌");
		// }s
	}

}
