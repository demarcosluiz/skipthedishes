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
@Table(name="order_items")

@DynamicInsert
@DynamicUpdate
public class OrderItem extends AbstractEntity<Integer> {
	
	@Expose
	@Id
	@Column(name="id", nullable=true, insertable=false, updatable=false)
	private Integer id;
	
//	@ManyToOne
//	@JoinColumn(name="order_id", nullable=false, insertable=true, updatable=true)
//	private Order order;
	
	@Expose
	@Column(name="order_id", nullable=false, length=255, insertable=true, updatable=true)
	private Integer orderId;
	
	@Expose
	@Column(name="product_id", nullable=false, length=255, insertable=true, updatable=true)
	private Integer productId;
	
	@Expose
	@Column(name="quantity", nullable=false, length=255, insertable=true, updatable=true)
	private Integer quantity;
	
	//private Product product;
	
	@Expose
	@Column(name="price", nullable=false, length=255, insertable=true, updatable=true)
	private Double price;
	
	@Expose
	@Column(name="total", nullable=false, length=255, insertable=true, updatable=true)
	private Double total;
	
	public OrderItem() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getTotal() {
		return total;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Override
	public Integer getTableId() {
		return id;
	}
	
	
}
