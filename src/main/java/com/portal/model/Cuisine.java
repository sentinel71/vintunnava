package com.portal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cuisine database table.
 * 
 */
@Entity 
@NamedQuery(name="Cuisine.findAll", query="SELECT c FROM Cuisine c")
public class Cuisine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private byte cuisineId;

	private String cuisineName;

	public Cuisine() {
	}

	public byte getCuisineId() {
		return this.cuisineId;
	}

	public void setCuisineId(byte cuisineId) {
		this.cuisineId = cuisineId;
	}

	public String getCuisineName() {
		return this.cuisineName;
	}

	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}

}