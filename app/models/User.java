package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.org.apache.bcel.internal.generic.NEW;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.libs.Codec;

@Entity
public class User extends Model{
	
	@Required
	public String username;
	
	@Required
	public String password;
	
	public String fullname;
	
	@Email
    @Required
	public String email;
	
	public String address;
	
	@Required
	public boolean status=false;
	
	@Required
	public boolean isAdmin=false;
	
	public Date registerDate;
	
	public Date lastLoginDate;
	
	@Required
	@ManyToMany(cascade=CascadeType.PERSIST)
	public List<Role> roles;
	
	public static User connect(String email, String password) {
        return find("byEmailAndPasswordAndStatus", email, Codec.hexMD5(password),false).first();
    }
	
	public String toString(){
		return email;
	}
	
}
