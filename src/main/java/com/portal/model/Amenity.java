package com.portal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the amenity database table.
 * 
 */ 
@Entity
@NamedQuery(name="Amenity.findAll", query="SELECT a FROM Amenity a")
public class Amenity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private byte amenityId;

	private String amenityName;

	private String description;

	public Amenity() {
	}

	public byte getAmenityId() {
		return this.amenityId;
	}

	public void setAmenityId(byte amenityId) {
		this.amenityId = amenityId;
	}

	public String getAmenityName() {
		return this.amenityName;
	}

	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}