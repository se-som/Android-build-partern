package com.example.utils;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import com.example.constant.Constant;
import com.example.object.UserObject;

public class ConvertData {
	
	public ConvertData(){
		super();
	}
	
	ArrayList<UserObject> userData;
	
	
	public ArrayList<UserObject> userObject(JSONArray userJSArray){
		try {
			userData = new ArrayList<UserObject>();
			
			for (int i = 0; i <userJSArray.length(); i++) {
				UserObject.UserBuilder userBuilder = new UserObject.UserBuilder();
				userBuilder.userID(userJSArray.getJSONObject(i).getInt(Constant.User.USER_ID));
				userBuilder.userName(userJSArray.getJSONObject(i).getString(Constant.User.USER_NAME));
				userBuilder.userAge(userJSArray.getJSONObject(i).getInt(Constant.User.USER_AGE));
				userBuilder.userTel(userJSArray.getJSONObject(i).getString(Constant.User.USER_TEL));
				
				UserObject userObject = userBuilder.build();
				userData.add(userObject);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}	
		return userData;
	}

}
