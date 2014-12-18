package models;

import java.util.List;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.data.validation.URL;
import play.db.jpa.Model;
import play.libs.Codec;

/**
 * 资源
 * @author zp
 *
 */

@Entity
public class Resource extends Model {
	
	@Required
	public String resource;
	@Required
	@URL
	public String domain;
	@Required
	public String appkey = Codec.UUID();
	@Required
	public String securekey = Codec.UUID();
	
	public String toString(){
		return resource;
	}
	
	
}
