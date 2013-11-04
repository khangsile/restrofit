package com.llc.restrofit;

import java.io.InputStream;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit.client.Response;

public class ResponseConverter {

	public static String responseToString(Response r) throws Exception {
		InputStream in = r.getBody().in();
        return new Scanner(in,"UTF-8").useDelimiter("\\A").next();
	}
	
	public static JSONObject responseToJSONObject(Response r) throws Exception {
		String s = responseToString(r);
		return new JSONObject(s);
	}
	
	public static JSONArray responseToJSONArray(Response r) throws Exception {
		String s = responseToString(r);
		return new JSONArray(s);
	}
	
}
