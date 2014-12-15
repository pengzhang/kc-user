package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class User extends Model{

	public String username;
	public String password;
	public String fullname;
	public String email;
	public String address;
	public boolean status;
	public boolean isAdmin;
	public Date registerDate;
	public Date lastLoginDate;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	public List<Role> roles;
	
	public static User connect(String email, String password) {
        return find("byEmailAndPassword", email, password).first();
    }
	
	public String toString(){
		return email;
	}
	
}
