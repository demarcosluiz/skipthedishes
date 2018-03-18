/**
 * 
 */
package com.skip.resources;

import java.io.Reader;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.skip.dao.service.ServiceException;
import com.skip.entities.Order;
import com.skip.entities.OrderItem;
import com.skip.entities.OrderItemRest;
import com.skip.entities.OrderRest;
import com.skip.service.OrderItemService;
import com.skip.service.OrderService;
import com.skip.service.ServicesController;

/**
 * @author Marcos.Gregorio
 *
 */

@Path("/Order")
@Consumes({MediaType.APPLICATION_JSON}) 
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource extends SkipBaseResource {
	

	private static ServicesController servicesController;
	private static OrderService orderService;
	private static OrderItemService orderItemService;
	
	
	//private static SimpleDateFormat dateFormatDateTime = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
	
	static {
		servicesController = ServicesController.getInstance();
		orderService = servicesController.getOrderService();
		orderItemService = servicesController.getOrderItemService();
	}
	
	
	public OrderResource() {
		super();
	}
	
	@POST
	public Response saveOrder(@Context HttpServletRequest httpServletRequest, Reader reader) {
		
		Gson gson = new Gson();
		OrderRest orderRest = gson.fromJson(reader, OrderRest.class);
		
		Order order = new Order();
		order.setId(orderRest.getId());
		order.setDate(orderRest.getDate());
		order.setCustomerId(orderRest.getCustomerId());
		order.setDeliveryAddress(orderRest.getDeliveryAddress());
		order.setContact(orderRest.getContact());
		order.setStoreId(orderRest.getStoreId());
		order.setTotal(orderRest.getTotal());
		order.setStatus(orderRest.getStatus());
		order.setLastUpdate(orderRest.getLastUpdate());
		
		try {
			orderService.save(order);
		} catch (ServiceException e) {
			e.printStackTrace();
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		for (OrderItemRest item : orderRest.getOrderItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setId(item.getId());
			orderItem.setOrderId(item.getOrderId());
			orderItem.setPrice(item.getPrice());
			orderItem.setProductId(item.getProductId());
			orderItem.setQuantity(item.getQuantity());
			orderItem.setTotal(item.getTotal());
			
			try {
				orderItemService.save(orderItem);
			} catch (ServiceException e) {
				e.printStackTrace();
				
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		
		
		Response response = createBasicResponse(Response.ok());
		
		return response;
	}
	
	@GET
	@Path("/{orderId}")
	public Response listOrder(@PathParam("orderId") String orderId) {
		
		try {
			//TODO Test
			orderId = "1";
			
			Integer orderIdInt = Integer.parseInt(orderId);
			
			Order order = orderService.searchID(orderIdInt);
			
			Response response = createResponse(order);
			
			return response;
			
		//} catch (ServiceException e) {
		} catch (Exception e) {
			e.printStackTrace();
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
}
