package com.zuba.moclass;

public class Publish {
	int topic_id;
	String username;
	String pub_date;
	int type;
	String topic;
	String phonenum;
	String context;
	String imgurl;
	String salary;
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
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Publish [topic_id=" + topic_id + ", username=" + username
				+ ", pub_date=" + pub_date + ", type=" + type + ", topic="
				+ topic + ", phonenum=" + phonenum + ", context=" + context
				+ ", imgurl=" + imgurl + ", salary=" + salary + "]";
	}

	
}
