package com.zuba.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.zuba.moclass.Reply;
import com.zuba.utils.JDBCUtils;

public class ReplyDaoImple implements ReplyDao {

	@Override
	public Reply insertReply(Reply reply) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		int checkReply;
		// insert into reply_table set topic_id = ?, username = ?, comment = ?,
		// com_date = ?;
		String sqls = "insert into reply_table(reply_id,topic_id,username,comment,com_date) "
				+ "values (null,?,?,?,?)";

		Object[] params = new Object[] { reply.getTopic_id(),
				reply.getUsername(), reply.getComment(), reply.getCom_date() };

		try {
			checkReply = queryRunner.update(sqls, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return reply;
	}

	@Override
	public Reply selectReply(Reply reply) {
		// TODO Auto-generated method stub
		return null;
	}

}
