package com.portal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the route database table.
 *  
 */
@Entity
@NamedQuery(name="Route.findAll", query="SELECT r FROM Route r")
public class Route implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private byte routeId;

	private String routeName;

	//bi-directional many-to-one association to Rateplan
	@OneToMany(mappedBy="route")
	private List<Rateplan> rateplans;

	public Route() {
	}

	public byte getRouteId() {
		return this.routeId;
	}

	public void setRouteId(byte routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return this.routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public List<Rateplan> getRateplans() {
		return this.rateplans;
	}

	public void setRateplans(List<Rateplan> rateplans) {
		this.rateplans = rateplans;
	}

	public Rateplan addRateplan(Rateplan rateplan) {
		getRateplans().add(rateplan);
		rateplan.setRoute(this);

		return rateplan;
	}

	public Rateplan removeRateplan(Rateplan rateplan) {
		getRateplans().remove(rateplan);
		rateplan.setRoute(null);

		return rateplan;
	}

}