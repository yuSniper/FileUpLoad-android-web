package com.zuba.moclass;

public class User {
	int id;
	String username;
	String pwd;
	String name;
	String headpicture;
	String nickname;
	String job;
	String sex;
	int age;
	String address;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadpicture() {
		return headpicture;
	}
	public void setHeadpicture(String headpicture) {
		this.headpicture = headpicture;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd
				+ ", name=" + name + ", headpicture=" + headpicture
				+ ", nickname=" + nickname + ", job=" + job + ", sex=" + sex
				+ ", age=" + age + ", address=" + address + "]";
	}
	

}
