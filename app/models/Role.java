package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class Role extends Model {

	public String role;
	public String desc;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	public List<Resource> resources;

}
