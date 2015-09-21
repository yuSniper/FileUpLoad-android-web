package com.zuba.service;

import com.zuba.dao.ReplyDao;
import com.zuba.dao.ReplyDaoImple;
import com.zuba.moclass.Reply;

public class ReplyService {

	public Reply insert_info(Reply reply) {
		ReplyDao insertdDao = new ReplyDaoImple();
		return insertdDao.insertReply(reply);
	}
}
