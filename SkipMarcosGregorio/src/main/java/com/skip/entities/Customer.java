package com.skip.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author Marcos.Gregorio
 *
 */
@Entity
@Table(name="customer")

@NamedQueries({
	@NamedQuery(name="Customer.auth", query="SELECT c FROM Customer c " + 
					 "where " +
					 "c.email = :email AND " +
					 "c.password = :password")
	
})

@DynamicInsert
@DynamicUpdate
public class Customer extends AbstractEntity<Integer> {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id", nullable=true, insertable=false, updatable=false)
	private Integer id;
	
	@Column(name="email", nullable=false, length=255, insertable=true, updatable=true)
	private String email;
	
	@Column(name="name", nullable=false, length=255, insertable=true, updatable=true)
	private String name;
	
	@Column(name="address", nullable=false, length=255, insertable=true, updatable=true)
	private String address;
	
	@Column(name="creation", nullable=false, length=255, insertable=true, updatable=true)
	private String creation; /* Datetime*/
	
	@Column(name="password", nullable=false, length=255, insertable=true, updatable=true)
	private String password;
	
	
	public Customer() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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
	
	public String getCreation() {
		return creation;
	}
	
	public void setCreation(String creation) {
		this.creation = creation;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Integer getTableId() {
		return id;
	}
	
	
}
