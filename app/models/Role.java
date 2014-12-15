package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Role extends Model {

	@Required
	public String role;
	public String desc;
	
	@Required
	@ManyToMany(cascade=CascadeType.PERSIST)
	public List<Resource> resources;
	
	public String toString(){
		return role;
	}

}
