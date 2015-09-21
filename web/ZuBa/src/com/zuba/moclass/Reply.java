package com.zuba.moclass;

public class Reply {
	int reply_id;
	int topic_id;
	String username;
	String com_date;
	String comment;

	public int getReply_id() {
		return reply_id;
	}

	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCom_date() {
		return com_date;
	}

	public void setCom_date(String com_date) {
		this.com_date = com_date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Reply [reply_id=" + reply_id + ", topic_id=" + topic_id
				+ ", username=" + username + ", com_date=" + com_date
				+ ", comment=" + comment + "]";
	}

}
