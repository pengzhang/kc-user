package models;

import java.util.List;

import javax.persistence.Entity;

import play.db.jpa.Model;
import play.libs.Codec;

/**
 * 资源
 * @author zp
 *
 */

@Entity
public class Resource extends Model {

	public String resource;
	public String domain;
	public String appKey = Codec.UUID();
	public String secureKey = Codec.UUID();
	
	
}
