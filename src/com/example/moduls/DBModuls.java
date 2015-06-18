package com.example.moduls;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.server.MyApp;
import com.example.constant.Constant;
import com.example.object.UserObject;
import com.example.server.DatabaseHelper;

public class DBModuls {
	private SQLiteDatabase db;
	


	public void addUser(ArrayList<UserObject> userData) {
		
		db = MyApp.getDatabase().getWritableDatabase();
		
		ContentValues contentValues = new ContentValues();
		for (int j = 0; j < userData.size(); j++) {
			contentValues.put(Constant.User.USER_NAME, userData.get(j).getUserName());
			
			db.insert(Constant.DB.TABLE_USER, null, contentValues);
		}
		
		
	}
	
	
}
