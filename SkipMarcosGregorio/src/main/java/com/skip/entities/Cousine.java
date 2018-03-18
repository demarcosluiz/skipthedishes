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
@Table(name="cousine")

@NamedQueries({
	@NamedQuery(name="Cousine.list", query="SELECT c FROM Cousine c ")
	,
	@NamedQuery(name="Cousine.listNameLike", query="SELECT c FROM Cousine c where c.name like :nameLike ")
})

public class Cousine extends AbstractEntity<Integer> {
	
	private static final long serialVersionUID = 1L;
	
	@Expose
	@Id
	@Column(name="id", nullable=true, insertable=false, updatable=false)
	private Integer id;
	
	@Expose
	@Column(name="name", nullable=false, length=255, insertable=true, updatable=true)
	private String name;
	
	public Cousine() {
		super();
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

	@Override
	public Integer getTableId() {
		return id;
	}
	
}

