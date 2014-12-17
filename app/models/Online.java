package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Online extends Model{
	
	public String username;
	public String accesstoken;
//	public String appkey;
//	public String securekey;
//	public Date expiretime;
	
	public Online(String username, String accesstoken) {
		this.username = username;
		this.accesstoken = accesstoken;
	}
	
	public String toString(){
		return username;
	}

}
