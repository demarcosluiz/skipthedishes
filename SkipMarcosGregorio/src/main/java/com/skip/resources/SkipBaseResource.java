package com.skip.resources;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skip.util.gson.GsonBuilderUtil;

/**
 * @author Marcos.Gregorio
 *
 */
public class SkipBaseResource extends BaseResource {
	
	public SkipBaseResource() {
		super();
	}
	
	protected Response createResponse(Object objectResponse) {
		GsonBuilder gsonBuilder = GsonBuilderUtil.getDefaultBuild();
		gsonBuilder.excludeFieldsWithoutExposeAnnotation();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();
		String response = gson.toJson(objectResponse);
		
		ResponseBuilder builder =  Response.ok(response);
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoCache(true);
		builder.cacheControl(cacheControl);
		
		Response resposta = builder.build();
		return resposta;
	}
	
	public Response createBasicResponse(ResponseBuilder builder) {
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoCache(true);
		builder.cacheControl(cacheControl);
		
		Response response = builder.build();
		
		return response;
	}
	
}
