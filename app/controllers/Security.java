package controllers;

import play.libs.Codec;
import models.Online;
import models.User;

import com.google.gson.Gson;

public class Security extends Secure.Security {
	
    static boolean authentify(String email, String password) {
    	if(User.connect(email, password) != null){
    		String access_token = Codec.UUID();
    		flash.put("access_token", access_token);
    		new Online(email,access_token).save();
    	}
        return User.connect(email, password) != null;
    }
    
    static boolean check(String profile) {
        if("admin".equals(profile)) {
            return User.find("byEmail", connected()).<User>first().isAdmin;
        }
        return false;
    }
    
    static void onDisconnected() {
        Application.index();
    }
    
    static void onAuthenticated() {
    	 String url = flash.get("return_url");
    	 
         if(url == null) {
        	 Admin.index();
         }
         redirect(url+"?access_token"+flash.get("access_token"));
        
    }
}
