package com.zuba.dao;

import com.zuba.moclass.Reply;

public interface ReplyDao {
	
	public Reply insertReply(Reply reply);
	
	public Reply selectReply(Reply reply);
}
