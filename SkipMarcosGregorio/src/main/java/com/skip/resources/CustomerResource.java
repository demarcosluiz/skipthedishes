package com.skip.resources;

import java.io.Reader;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.skip.dao.service.ServiceException;
import com.skip.entities.Customer;
import com.skip.service.CustomerService;
import com.skip.service.ServicesController;

/**
 * @author Marcos.Gregorio
 *
 */
@Path("/Customer")
@Consumes({MediaType.APPLICATION_JSON}) 
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource extends SkipBaseResource {
	
	private static ServicesController servicesController;
	private static CustomerService customerService;
	
	//private static SimpleDateFormat dateFormatDateTime = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
	
	static {
		servicesController = ServicesController.getInstance();
		customerService = servicesController.getCustomerService();
	}
	
	public CustomerResource() {
		super();
	}
	
	@POST
	public Response saveCustomer(@Context HttpServletRequest httpServletRequest, Reader reader) {
		
		Gson gson = new Gson();
		Customer customer = gson.fromJson(reader, Customer.class);
		try {
			customerService.save(customer);
		} catch (ServiceException e) {
			e.printStackTrace();
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		Response response = createBasicResponse(Response.ok());
		
		return response;
	}
	
	@POST
	@Path("{auth}")
	public Response auth(@QueryParam("email") String email,
						 @QueryParam("password") String password) {
		
		
		
		try {
			boolean ret = customerService.auth(email, password);
			
			if (ret) {
				Response response = createBasicResponse(Response.ok());
				return response;
				
			} else {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
	
	//public 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
