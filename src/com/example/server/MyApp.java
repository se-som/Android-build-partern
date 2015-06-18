package com.example.server;

import java.io.IOException;

import android.app.Application;
import android.database.SQLException;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.server.DatabaseHelper;
import com.example.server.HttpsTrustManager;
public class MyApp extends Application {

	public static final String TAG = MyApp.class.getSimpleName();

	private RequestQueue mRequestQueue;

	private static MyApp mInstance;

	private static DatabaseHelper myDbHelper;

	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
		myDbHelper = new DatabaseHelper(this);
		try {
			myDbHelper.createDataBase();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			myDbHelper.openDataBase();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		}
		HttpsTrustManager.allowAllSSL();
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
		myDbHelper.close();
	}

	public static synchronized MyApp getInstance() {
		return mInstance;
	}

	public RequestQueue getRequestQueue() {
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(getApplicationContext());
		}

		return mRequestQueue;
	}

	public <T> void addToRequestQueue(Request<T> req, String tag) {
		req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
		getRequestQueue().add(req);
	}

	public <T> void addToRequestQueue(Request<T> req) {
		req.setTag(TAG);
		getRequestQueue().add(req);
	}

	public void cancelPendingRequests(Object tag) {
		if (mRequestQueue != null) {
			mRequestQueue.cancelAll(tag);
		}
	}

	public static DatabaseHelper getDatabase() {
		return myDbHelper;
	}

}
