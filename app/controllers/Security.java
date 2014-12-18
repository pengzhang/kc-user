package controllers;

import java.util.Date;

import models.Online;
import models.User;
import play.libs.Codec;

public class Security extends Secure.Security {

	static boolean authentify(String email, String password) {
		if (User.connect(email, password) != null) {
			Online online = Online.find("byUsername", email).first();
			if (online == null) {
				String access_token = Codec.UUID();
				flash.put("access_token", access_token);
				new Online(email, access_token, new Date()).save();
			}else{
				flash.put("access_token", online.accesstoken);
			}
		}
		
		//TODO 自动下线
		return User.connect(email, password) != null;
	}

	static boolean check(String profile) {
		if ("admin".equals(profile)) {
			return User.find("byEmail", connected()).<User> first().isAdmin;
		}
		return false;
	}
	
	static void onDisconnect(){
		String username = session.get("username");
		User user = User.find("byEmail", username).first();
		Online online = Online.find("byUsername", username).first();
		if (online != null) {
			user.lastLoginDate = online.logintime;
			user.save();
			online.delete();
		}
	}

	static void onDisconnected() {
		Application.index();
	}

	static void onAuthenticated() {
		String url = flash.get("return_url");

		if (url == null) {
			Admin.index();
		}
		redirect(url + "?access_token=" + flash.get("access_token"));

	}
}
