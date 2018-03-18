package com.skip.entities;

import java.util.Set;

/**
 * @author Marcos.Gregorio
 *
 */

public class OrderRest {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String date; /* Datetime */
	
	private Integer customerId;
	
	private String deliveryAddress;
	
	private String contact;
	
	private Integer storeId;
	
	
	private Set<OrderItemRest> orderItems;
	
	private Double total;
	
	private String status;
	
	private String lastUpdate; /* Datetime */
	
	public OrderRest() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	public String getContact() {
		return contact;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public Integer getStoreId() {
		return storeId;
	}
	
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	
	public Double getTotal() {
		return total;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getLastUpdate() {
		return lastUpdate;
	}
	
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public Set<OrderItemRest> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItemRest> orderItems) {
		this.orderItems = orderItems;
	}


}
