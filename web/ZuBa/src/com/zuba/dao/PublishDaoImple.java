package com.zuba.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.zuba.moclass.Publish;
import com.zuba.utils.JDBCUtils;

public class PublishDaoImple implements PublishDao {

	@Override
	public Publish insertPublish(Publish publish) {

		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		int checkPublish;
		// insert into publish_table set username = ?, type = ?, topic = ?,
		// phonenum = ?,
		// salary = ?, context = ?, imgurl = ?, pub_date = ?;
		String sqls = "insert into publish_table(topic_id,imgurl,username,type,topic,phonenum,salary,context,pub_date) "
				+ "values (null,?,?,?,?,?,?,?,?)";

		Object[] params = new Object[] { publish.getImgurl(),
				publish.getUsername(), publish.getType(), publish.getTopic(),
				publish.getPhonenum(), publish.getSalary(),
				publish.getContext(), publish.getPub_date() };

		try {
			checkPublish = queryRunner.update(sqls, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return publish;
	}

	@Override
	public Publish selectPublish(Publish publish) {
		// TODO Auto-generated method stub
		return null;
	}

}
