package com.skip.resources;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.skip.entities.Product;
import com.skip.entities.Store;
import com.skip.service.ProductService;
import com.skip.service.ServicesController;
import com.skip.service.StoreService;

/**
 * @author Marcos.Gregorio
 *
 */
@Path("/Store")
@Consumes({MediaType.APPLICATION_JSON}) 
@Produces(MediaType.APPLICATION_JSON)
public class StoreResource extends SkipBaseResource {

	public StoreResource() {
		super();
	}
	
	private static ServicesController servicesController;
	private static StoreService storeService;
	private static ProductService productService;
	
	//private static SimpleDateFormat dateFormatDateTime = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
	
	static {
		servicesController = ServicesController.getInstance();
		storeService = servicesController.getStoreService();
		productService = servicesController.getProductService();
	}
	
	@GET
	public Response listStore() {
		
		try {
			List<Store> list = storeService.list();
			
			Response response = createResponse(list);
			
			return response;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GET
	@Path("/search/{nameLike}")
	public Response listStoreSearch(@PathParam("nameLike") String nameLike) {
		
		try {
			//TODO test
			nameLike = "ni";
			List<Store> list = storeService.listNameLike(nameLike);
			
			Response response = createResponse(list);
			
			return response;
			
		//} catch (ServiceException e) {
		} catch (Exception e) {
			e.printStackTrace();
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@GET
	@Path("/{storeId}")
	public Response listCousineStores(@PathParam("storeId") String storeId) {
		
		try {
			//TODO Test
			storeId = "2";
			
			Integer storeIdInt = Integer.parseInt(storeId);
			
			Store store = storeService.searchID(storeIdInt);
			
			Response response = createResponse(store);
			
			return response;
			
		//} catch (ServiceException e) {
		} catch (Exception e) {
			e.printStackTrace();
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GET
	@Path("/{storeId}/products")
	public Response listStoreProducts(@PathParam("storeId") String storeId) {
		
		try {
			//TODO Test
			storeId = "1";
			Integer storeIdInt = Integer.parseInt(storeId);
			
			List<Product> listStore = productService.listByStore(storeIdInt);
			
			Response response = createResponse(listStore);
			
			return response;
			
		//} catch (ServiceException e) {
		} catch (Exception e) {
			e.printStackTrace();
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
}
