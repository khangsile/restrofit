package com.llc.restrofit;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	
	public static RestAdapter.Builder defaultBuilder(String baseURL) {
		Gson gson = Restrofit.defaultGsonBuilder().create();

		RestAdapter.Builder builder = new RestAdapter.Builder()
    		.setServer(baseURL)
    		.setConverter(new GsonConverter(gson))
    		.setRequestInterceptor(new JSONRequestInterceptor());
		
		restAdapter = builder.build();
		
		return builder;
	}
	
	public static GsonBuilder defaultGsonBuilder() {
		return new GsonBuilder()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.setDateFormat("yyyy-MM-DD'T'hh:mm:ss.sss'Z'"); //Rails UTC DateFormat
	}
	
	public static void setSharedAdapter(RestAdapter adapter) {
		restAdapter = adapter;
	}
}
