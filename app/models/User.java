package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class User extends Model{

	public String username;
	public String password;
	public String fullname;
	public String email;
	public String address;
	public boolean isAdmin;
	
	public User(String username, String password, String fullname, String email, String address, boolean isAdmin) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.isAdmin = isAdmin;
	}
	
	
}
