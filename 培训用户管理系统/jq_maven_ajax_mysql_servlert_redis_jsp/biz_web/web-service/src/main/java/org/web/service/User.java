package org.web.service;

public class User {
	String user_id;
	String user_name;
	String user_pwd;
	String user_mail;
	String user_area;
	String user_hobby;
	String user_creat_time;
	String user_job;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public String getUser_area() {
		return user_area;
	}
	public void setUser_area(String user_area) {
		this.user_area = user_area;
	}
	public String getUser_hobby() {
		return user_hobby;
	}
	public void setUser_hobby(String user_hobby) {
		this.user_hobby = user_hobby;
	}
	public String getUser_creat_time() {
		return user_creat_time;
	}
	public void setUser_creat_time(String user_creat_time) {
		this.user_creat_time = user_creat_time;
	}
	public String getUser_job() {
		return user_job;
	}
	public void setUser_job(String user_job) {
		this.user_job = user_job;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_pwd=" + user_pwd + ", user_mail="
				+ user_mail + ", user_area=" + user_area + ", user_hobby=" + user_hobby + ", user_creat_time="
				+ user_creat_time + ", user_job=" + user_job + "]";
	}
	

}
