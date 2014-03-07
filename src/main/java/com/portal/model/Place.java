package com.portal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the places database table.
 * 
 */ 
@Entity
@Table(name="places")
@NamedQuery(name="Place.findAll", query="SELECT p FROM Place p")
public class Place implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private byte placeId;

	private String description;

	private String placeName;

	//bi-directional many-to-one association to Areaofinterest
	@OneToMany(mappedBy="place")
	private List<Areaofinterest> areaofinterests;

	public Place() {
	}

	public byte getPlaceId() {
		return this.placeId;
	}

	public void setPlaceId(byte placeId) {
		this.placeId = placeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlaceName() {
		return this.placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public List<Areaofinterest> getAreaofinterests() {
		return this.areaofinterests;
	}

	public void setAreaofinterests(List<Areaofinterest> areaofinterests) {
		this.areaofinterests = areaofinterests;
	}

	public Areaofinterest addAreaofinterest(Areaofinterest areaofinterest) {
		getAreaofinterests().add(areaofinterest);
		areaofinterest.setPlace(this);

		return areaofinterest;
	}

	public Areaofinterest removeAreaofinterest(Areaofinterest areaofinterest) {
		getAreaofinterests().remove(areaofinterest);
		areaofinterest.setPlace(null);

		return areaofinterest;
	}

}