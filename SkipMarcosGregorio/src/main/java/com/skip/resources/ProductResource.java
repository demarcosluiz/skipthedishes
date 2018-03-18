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
import com.skip.service.ProductService;
import com.skip.service.ServicesController;

/**
 * @author Marcos.Gregorio
 *
 */
@Path("/Product")
@Consumes({MediaType.APPLICATION_JSON}) 
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource extends SkipBaseResource {
	
	public ProductResource() {
		super();
	}
	
	
	private static ServicesController servicesController;
	private static ProductService productService;
	
	//private static SimpleDateFormat dateFormatDateTime = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
	
	static {
		servicesController = ServicesController.getInstance();
		productService = servicesController.getProductService();
	}
	
	@GET
	public Response listProduct() {
		
		try {
			List<Product> listProduct = productService.list();
			
			Response response = createResponse(listProduct);
			
			return response;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GET
	@Path("/search/{nameLike}")
	public Response listProductSearch(@PathParam("nameLike") String nameLike) {
		
		try {
			//TODO test
			nameLike = "ca";
			List<Product> listProduct = productService.listNameLike(nameLike);
			
			Response response = createResponse(listProduct);
			
			return response;
			
		//} catch (ServiceException e) {
		} catch (Exception e) {
			e.printStackTrace();
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@GET
	@Path("/{productId}")
	public Response listCousineStores(@PathParam("productId") String productId) {
		
		try {
			//TODO Test
			productId = "2";
			
			Integer productIdInt = Integer.parseInt(productId);
			
			Product product = productService.searchID(productIdInt);
			
			Response response = createResponse(product);
			
			return response;
			
		//} catch (ServiceException e) {
		} catch (Exception e) {
			e.printStackTrace();
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
