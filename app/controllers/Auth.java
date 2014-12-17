package controllers;

import java.util.List;

import models.Online;
import models.Resource;
import models.Role;
import models.User;
import play.mvc.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class Auth extends Controller {

	public static void auth(String ak,String sk,String token){
		Resource res = Resource.find("byAppkeyAndSecurekey", ak,sk).first();
		JsonObject json = new JsonObject();
		json.addProperty("appkey", ak);
		json.addProperty("securekey", sk);
		json.addProperty("securekey", sk);
		if(res != null) {
			
			Online online = Online.find("byAccesstoken", token).first();
			if(online == null){
				json.addProperty("error", play.i18n.Messages.get("auth.error.nologin"));
				json.addProperty("status", false);
				renderJSON(json);
			}
			
			List<User> users = User.find("select u from User u join u.roles ur join ur.resources res where u.email=(:email) and res.resource in (:resource)")
					.bind("email", online.username).bind("resource", res.resource).fetch();
			
			System.out.println(new Gson().toJson(users));
			
			if(users.size() >0){
				json.addProperty("status", true);
				json.addProperty("username", online.username);
			}else{
				json.addProperty("error", play.i18n.Messages.get("auth.error.noauth"));
				json.addProperty("status", false);
			}
			
			
		}else{
			json.addProperty("error", play.i18n.Messages.get("auth.error.noapp"));
			json.addProperty("status", false);
		}
		renderJSON(json);
	}
	
}
