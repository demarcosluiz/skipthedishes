package com.skip.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/**
 * @author Marcos.Gregorio
 *
 */

@Entity
@Table(name="product")

@NamedQueries({
	@NamedQuery(name="Product.list", query="SELECT p FROM Product p ")
	,
	@NamedQuery(name="Product.listNameLike", query="SELECT p FROM Product p where p.name like :nameLike ")
	,
	@NamedQuery(name="Product.listByStore", query="SELECT p FROM Product p where p.storeId = :storeId ")
})

public class Product extends AbstractEntity<Integer> {
	
	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@Column(name="id", nullable=true, insertable=false, updatable=false)
	private Integer id;
	
	@Expose
	@Column(name="name", nullable=false, length=255, insertable=true, updatable=true)
	private String name;
	
	@Expose
	@Column(name="description", nullable=false, length=255, insertable=true, updatable=true)
	private String descritpion;
	
	@Expose
	@Column(name="price", nullable=false, length=10, insertable=true, updatable=true)
	private Double price;
	
	@Expose
	@Column(name="store_id", nullable=false, length=255, insertable=true, updatable=true)
	private Integer storeId;
	
	
	public Product() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getStoreId() {
		return storeId;
	}
	
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescritpion() {
		return descritpion;
	}
	
	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public Integer getTableId() {
		return id;
	}
	
	
	
}
