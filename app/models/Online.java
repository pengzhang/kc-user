package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Online extends Model{
	
	public String accessToken;
	public String appKey;
	public String secureKey;
	public Date expireTime;

}
