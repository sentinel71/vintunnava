package com.portal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the houseboattype database table.
 * 
 */ 
@Entity
@NamedQuery(name="Houseboattype.findAll", query="SELECT h FROM Houseboattype h")
public class Houseboattype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private byte houseboatTypeId;

	private String houseboatName;

	//bi-directional many-to-one association to Roomtype
	@OneToMany(mappedBy="houseboattype")
	private List<Roomtype> roomtypes;

	public Houseboattype() {
	}

	public byte getHouseboatTypeId() {
		return this.houseboatTypeId;
	}

	public void setHouseboatTypeId(byte houseboatTypeId) {
		this.houseboatTypeId = houseboatTypeId;
	}

	public String getHouseboatName() {
		return this.houseboatName;
	}

	public void setHouseboatName(String houseboatName) {
		this.houseboatName = houseboatName;
	}

	public List<Roomtype> getRoomtypes() {
		return this.roomtypes;
	}

	public void setRoomtypes(List<Roomtype> roomtypes) {
		this.roomtypes = roomtypes;
	}

	public Roomtype addRoomtype(Roomtype roomtype) {
		getRoomtypes().add(roomtype);
		roomtype.setHouseboattype(this);

		return roomtype;
	}

	public Roomtype removeRoomtype(Roomtype roomtype) {
		getRoomtypes().remove(roomtype);
		roomtype.setHouseboattype(null);

		return roomtype;
	}

}