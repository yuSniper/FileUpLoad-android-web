package com.zuba.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.zuba.utils.JDBCUtils;

public class InsertUrl {

	public boolean inserturlfile(String username, String url) {

		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		// String sqls =
		// "insert into publish_table(topic_id,username,type,topic,phonenum,salary,context,imgurl,pub_date) "
		// + "values (null,?,?,?,?,?,?,?,?)";
		String sqls = "update publish_table set  imgurl = ? where username = ?";
		Object[] params = new Object[] { url + "|", username };

		try {
			queryRunner.update(sqls, params);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
