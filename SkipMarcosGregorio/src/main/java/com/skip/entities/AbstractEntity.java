package com.skip.entities;

import java.io.Serializable;

/**
 * @author Marcos.Gregorio
 *
 */
public abstract class AbstractEntity<PkType> extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public AbstractEntity() {
		super();
	}
	
	public abstract PkType getTableId();
	
}
