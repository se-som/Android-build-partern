package com.example.object;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.constant.Constant;

public class UserObject {
	private int userID;
	private String userName;
	private int userAge;
	private String userTel;
	JSONObject userDataJSONObject;
	public UserObject(UserBuilder build) {
		this.userID = build.userID;
		this.userName = build.userName;
		this.userAge = build.userAge;
		this.userTel = build.userTel;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	
	
	public JSONObject toJSONObject(){
		try {
			userDataJSONObject.put(Constant.User.USER_ID, getUserID());
			userDataJSONObject.put(Constant.User.USER_NAME, getUserName());
			userDataJSONObject.put(Constant.User.USER_AGE, getUserAge());
			userDataJSONObject.put(Constant.User.USER_TEL, getUserTel());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDataJSONObject;
	}
	
	public static class UserBuilder{
		
		private int userID,
					userAge;
		private String 
					userName,
					userTel;
		
		public UserBuilder(){
			super();
		}
		public UserBuilder userID(int userID){
			this.userID = userID;
			return this;
		}
		public UserBuilder userName(String userName){
			this.userName = userName;
			return this;
		}
		public UserBuilder userAge(int userAge){
			this.userAge = userAge;
			return this;
		}
		
		public UserBuilder userTel(String userTel){
			this.userTel = userTel;
			return this;
		}
		
		public UserObject build(){
			return new UserObject(this);
			
		}	 
	}	
}
