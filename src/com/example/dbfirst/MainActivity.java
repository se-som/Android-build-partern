package com.example.dbfirst;

import java.util.ArrayList;
















import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.constant.Constant;
import com.example.moduls.DBModuls;
import com.example.object.UserObject;
import com.example.utils.ConvertData;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {
	ArrayList<UserObject> userData;
	ImageView button;
	ConvertData c;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		listener();
		 userData = new ArrayList<UserObject>();
		c = new ConvertData();
	}

	private void init() {
		button = (ImageView) findViewById(R.id.imageButton1);
		
		
	}
	private void listener() {
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				JSONObject jsonObject = new JSONObject();
				JSONArray jsonarray = new JSONArray();
				try {
					jsonObject.put(Constant.User.USER_ID, 1);
					jsonObject.put(Constant.User.USER_NAME, "A");
					jsonObject.put(Constant.User.USER_AGE, 27);
					jsonObject.put(Constant.User.USER_TEL, "012");
					
					jsonarray.put(jsonObject);
					JSONObject jsonObjects = new JSONObject();
					jsonObjects.put(Constant.User.USER_NAME, "B");
					jsonObjects.put(Constant.User.USER_AGE, 28);
					jsonObjects.put(Constant.User.USER_TEL, "011");
					
					jsonarray.put(jsonObjects);
					
					userData = c.userObject(jsonarray);
					
					int dd = userData.get(1).getUserID();
					Log.i("ONuserData", "="+userData.get(0).getUserID());
					//Log.i("ONuserData", "="+userData.get(1).getUserID());
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			//	DBModuls db = new DBModuls();
				//db.addUser(userData);
				
			}
		});
	}


	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
