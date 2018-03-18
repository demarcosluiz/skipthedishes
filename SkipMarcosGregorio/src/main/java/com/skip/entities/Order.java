package com.skip.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.google.gson.annotations.Expose;

/**
 * @author Marcos.Gregorio
 *
 */

@Entity
@Table(name="orders")

@DynamicInsert
@DynamicUpdate
public class Order extends AbstractEntity<Integer> {
	
	private static final long serialVersionUID = 1L;
	
	@Expose
	@Id
	@Column(name="id", nullable=true, insertable=false, updatable=false)
	private Integer id;
	
	@Expose
	@Column(name="date", nullable=false, length=255, insertable=true, updatable=true)
	private String date; /* Datetime */
	
	@Expose
	@Column(name="customer_id", nullable=false, length=255, insertable=true, updatable=true)
	private Integer customerId;
	
	@Expose
	@Column(name="delivery_address", nullable=false, length=255, insertable=true, updatable=true)
	private String deliveryAddress;
	
	@Expose
	@Column(name="contact", nullable=false, length=255, insertable=true, updatable=true)
	private String contact;
	
	@Expose
	@Column(name="store_id", nullable=false, length=255, insertable=true, updatable=true)
	private Integer storeId;
	
	
//	@Expose
//	@OneToMany(mappedBy = "order", targetEntity = OrderItem.class, fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
//	private Set<OrderItem> orderItems;
	
	@Expose
	@Column(name="total", nullable=false, length=255, insertable=true, updatable=true)
	private Double total;
	
	@Expose
	@Column(name="status", nullable=false, length=255, insertable=true, updatable=true)
	private String status;
	
	@Expose
	@Column(name="last_update", nullable=false, length=255, insertable=true, updatable=true)
	private String lastUpdate; /* Datetime */
	
	public Order() {
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
	
	@Override
	public Integer getTableId() {
		return id;
	}
	

}
