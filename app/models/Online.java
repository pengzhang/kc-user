package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Online extends Model{
	
	public String username;
	public String accesstoken;
	public Date logintime;
	
	public Online(String username, String accesstoken,Date logintime) {
		this.username = username;
		this.accesstoken = accesstoken;
		this.logintime = logintime;
	}
	
	public String toString(){
		return username;
	}

}
