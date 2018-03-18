package com.skip.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.google.gson.annotations.Expose;

/**
 * @author Marcos.Gregorio
 *
 */

@Entity
@Table(name="store")

@NamedQueries({
	@NamedQuery(name="Store.list", query="SELECT s FROM Store s ")
	,
	@NamedQuery(name="Store.listNameLike", query="SELECT s FROM Store s where s.name like :nameLike ")
	,
	@NamedQuery(name="Store.listByCousine", query="SELECT s FROM Store s " + 
					 "where " +
					 "s.cousineId = :cousineId ")
	
})

@DynamicInsert
@DynamicUpdate
public class Store extends AbstractEntity<Integer> {
	
	@Expose
	@Id
	@Column(name="id", nullable=true, insertable=false, updatable=false)
	private Integer id;
	
	@Expose
	@Column(name="name", nullable=false, length=255, insertable=true, updatable=true)
	private String name;
	
	@Expose
	@Column(name="address", nullable=false, length=255, insertable=true, updatable=true)
	private String address;
	
	@Expose
	@Column(name="cousine_id", nullable=false, length=255, insertable=true, updatable=true)
	private Integer cousineId;
	
	public Store() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getCousineId() {
		return cousineId;
	}
	
	public void setCousineId(Integer cousineId) {
		this.cousineId = cousineId;
	}

	@Override
	public Integer getTableId() {
		return id;
	}
	
	
	
}
