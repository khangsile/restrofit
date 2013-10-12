package com.llc.restrofit;

import java.util.Date;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

/**
 * A Retrofit Adapter that stores the baseURL and allows you to reuse the same restAdapter as opposed
 * to reinstantiating it.
 * @author KhangSiLe
 *
 */
public class Restrofit {
	
	private static RestAdapter restAdapter = null;
	
	public static RestAdapter sharedAdapter() {
		return restAdapter;
	}
	
	public static RestAdapter defaultAdapter(String baseURL) {
		Gson gson = Restrofit.defaultGson();

		restAdapter = new RestAdapter.Builder()
    		.setServer(baseURL)
    		.setConverter(new GsonConverter(gson))
    		.setRequestInterceptor(new JSONRequestInterceptor())
    		.build();
		
		return restAdapter;
	}
	
	public static Gson defaultGson() {
		return new GsonBuilder()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.registerTypeAdapter(Date.class, new DateTypeAdapter())
			.create();
	}
	
	public static void setSharedAdapter(RestAdapter adapter) {
		restAdapter = adapter;
	}
}
