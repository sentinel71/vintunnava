package com.portal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the areaofinterest database table.
 * 
 */
@Entity 
@NamedQuery(name="Areaofinterest.findAll", query="SELECT a FROM Areaofinterest a")
public class Areaofinterest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private byte areaId;

	private String areaName;

	private String description;

	//bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name="placeId")
	private Place place;

	public Areaofinterest() {
	}

	public byte getAreaId() {
		return this.areaId;
	}

	public void setAreaId(byte areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

}