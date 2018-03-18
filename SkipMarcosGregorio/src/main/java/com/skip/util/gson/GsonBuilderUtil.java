package com.skip.util.gson;

import java.util.Date;
import java.util.List;

import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;


public class GsonBuilderUtil {

	public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mmZ";//"dd/MM/yyyy HH:mm:ss";
	
	public static GsonBuilder getDefaultNoListBuild() {
		GsonBuilder gsonBuilder = getDefaultBuild();
		gsonBuilder.addSerializationExclusionStrategy(new TypeExclusionStrategy(List.class));
		//gsonBuilder.addSerializationExclusionStrategy(new HibernateNoProxyExclusionStrategy());
		return gsonBuilder;
	}
	
	public static GsonBuilder getDefaultBuild() {
		/*TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
		df.setTimeZone(tz);*/
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateTypeAdapter());
		//gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);
		//gsonBuilder.setDateFormat(DATE_FORMAT);
		return gsonBuilder;
	}
	
}
