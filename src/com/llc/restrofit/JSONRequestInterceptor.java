package com.llc.restrofit;

import retrofit.RequestInterceptor;

public class JSONRequestInterceptor implements RequestInterceptor {

	@Override
	public void intercept(RequestFacade request) {
		// TODO Auto-generated method stub
		request.addHeader("Content-type", "application/json");
		request.addHeader("HTTP-accept", "application/json");
	}
}
