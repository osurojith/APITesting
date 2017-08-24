package com.Test;

import org.json.JSONException;
import org.json.JSONObject;

public class Posts {
public static JSONObject setdata(String username,String password) throws JSONException{
	JSONObject js = new JSONObject();
	js.put("username", "nikom@gmail.com");
	js.put("password", "");
	return js;
}

}
