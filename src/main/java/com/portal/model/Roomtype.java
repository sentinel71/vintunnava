package com.portal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the roomtype database table.
 * 
 */
@Entity
@Table(name="roomtype")
@NamedQueries({
@NamedQuery(name="Roomtype.findAll", query="SELECT r FROM Roomtype r"),
@NamedQuery(name="Roomtype.findRoomByUser", query="select room from Roomtype room join room.rateplan rate where rate.ratePlanId= :rateplanid")
})
public class Roomtype implements Serializable { 
	private static final long serialVersionUID = 1L;
	public static final String FIND_ROOMS_BY_USER = "Roomtype.findRoomByUser";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roomTypeId;

	private String amenity;

	private String extraRate;

	private String roomTypeName;

	//bi-directional many-to-one association to Houseboattype
	@ManyToOne
	@JoinColumn(name="houseBoatTypeId")
	private Houseboattype houseboattype;

	//bi-directional many-to-one association to Rateplan
	@ManyToOne
	@JoinColumn(name="ratePlanId")
	private Rateplan rateplan;

	public Roomtype() {
	}

	public int getRoomTypeId() {
		return this.roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getAmenity() {
		return this.amenity;
	}

	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}

	public String getExtraRate() {
		return this.extraRate;
	}

	public void setExtraRate(String extraRate) {
		this.extraRate = extraRate;
	}

	public String getRoomTypeName() {
		return this.roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public Houseboattype getHouseboattype() {
		return this.houseboattype;
	}

	public void setHouseboattype(Houseboattype houseboattype) {
		this.houseboattype = houseboattype;
	}

	public Rateplan getRateplan() {
		return this.rateplan;
	}

	public void setRateplan(Rateplan rateplan) {
		this.rateplan = rateplan;
	}

}