package com.portal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rateplan database table.
 *  
 */
@Entity
@NamedQuery(name="Rateplan.findAll", query="SELECT r FROM Rateplan r")
public class Rateplan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ratePlanId;

	//bi-directional many-to-one association to Tarifftype
	@ManyToOne
	@JoinColumn(name="tariffTypeId")
	private Tarifftype tarifftype;

	//bi-directional many-to-one association to Tariff
	@ManyToOne
	@JoinColumn(name="tariffId")
	private Tariff tariff;

	//bi-directional many-to-one association to Route
	@ManyToOne
	@JoinColumn(name="routeId")
	private Route route;

	//bi-directional many-to-one association to Roomtype
	@OneToMany(mappedBy="rateplan")
	private List<Roomtype> roomtypes;

	public Rateplan() {
	}

	public int getRatePlanId() {
		return this.ratePlanId;
	}

	public void setRatePlanId(int ratePlanId) {
		this.ratePlanId = ratePlanId;
	}

	public Tarifftype getTarifftype() {
		return this.tarifftype;
	}

	public void setTarifftype(Tarifftype tarifftype) {
		this.tarifftype = tarifftype;
	}

	public Tariff getTariff() {
		return this.tariff;
	}

	public void setTariff(Tariff tariff) {
		this.tariff = tariff;
	}

	public Route getRoute() {
		return this.route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public List<Roomtype> getRoomtypes() {
		return this.roomtypes;
	}

	public void setRoomtypes(List<Roomtype> roomtypes) {
		this.roomtypes = roomtypes;
	}

	public Roomtype addRoomtype(Roomtype roomtype) {
		getRoomtypes().add(roomtype);
		roomtype.setRateplan(this);

		return roomtype;
	}

	public Roomtype removeRoomtype(Roomtype roomtype) {
		getRoomtypes().remove(roomtype);
		roomtype.setRateplan(null);

		return roomtype;
	}

}