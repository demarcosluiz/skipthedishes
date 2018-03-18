package com.skip.resources;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skip.util.gson.GsonBuilderUtil;

public abstract class BaseResource {

	//protected Log logger = GatewayVTexLogger.getResources();
	
	protected Response createResponse(Object paymentResponse) {
		GsonBuilder gsonBuilder = GsonBuilderUtil.getDefaultBuild();
		gsonBuilder.excludeFieldsWithoutExposeAnnotation();
		gsonBuilder.serializeNulls();
		//Creating parameters
		Gson gson = gsonBuilder.create();
		String response = gson.toJson(paymentResponse);
		
		ResponseBuilder builder =  Response.ok(response);
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoCache(true);
		builder.cacheControl(cacheControl);
		
		Response resposta = builder.build();
		return resposta;
	}
	
	
}
