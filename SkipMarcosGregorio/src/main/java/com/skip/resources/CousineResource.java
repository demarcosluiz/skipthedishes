package com.skip.resources;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.skip.entities.Cousine;
import com.skip.entities.Store;
import com.skip.service.CousineService;
import com.skip.service.ServicesController;
import com.skip.service.StoreService;

/**
 * @author Marcos.Gregorio
 *
 */
@Path("/")
@Consumes({MediaType.APPLICATION_JSON}) 
@Produces(MediaType.APPLICATION_JSON)
public class CousineResource extends SkipBaseResource {
	
	private static ServicesController servicesController;
	private static CousineService cousineService;
	private static StoreService storeService;
	
	//private static SimpleDateFormat dateFormatDateTime = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
	
	static {
		servicesController = ServicesController.getInstance();
		cousineService = servicesController.getCousineService();
		storeService = servicesController.getStoreService();
	}
	
	public CousineResource() {
		super();
	}
	
	@GET
	@Path("/Cousine")
	public Response listCousine() {
		
		/*
		Gson gson = new Gson();
		Customer customer = gson.fromJson(reader, Customer.class);
		*/
		try {
			List<Cousine> listCousine = cousineService.list();
			
			Response response = createResponse(listCousine);
			
			return response;
			
		//} catch (ServiceException e) {
		} catch (Exception e) {
			e.printStackTrace();
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GET
	@Path("/Cousine/search/{nameLike}")
	public Response listCousineSearch(@PathParam("nameLike") String nameLike) {
		
		/*
		Gson gson = new Gson();
		Customer customer = gson.fromJson(reader, Customer.class);
		*/
		try {
			//TODO test
			nameLike = "bra";
			List<Cousine> listCousine = cousineService.listNameLike(nameLike);
			
			Response response = createResponse(listCousine);
			
			return response;
			
		//} catch (ServiceException e) {
		} catch (Exception e) {
			e.printStackTrace();
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GET
	@Path("/Cousine/{idCousine}/stores")
	public Response listCousineStores(@PathParam("idCousine") String idCousine) {
		
		/*
		Gson gson = new Gson();
		Customer customer = gson.fromJson(reader, Customer.class);
		*/
		try {
			//TODO Test
			idCousine = "1";
			Integer idCousineInt = Integer.parseInt(idCousine);
			
			List<Store> listStore = storeService.listByCousine(idCousineInt);
			
			Response response = createResponse(listStore);
			
			return response;
			
		//} catch (ServiceException e) {
		} catch (Exception e) {
			e.printStackTrace();
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
