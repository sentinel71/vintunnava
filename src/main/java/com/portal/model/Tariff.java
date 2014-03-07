package com.portal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tariff database table.
 *  
 */
@Entity
@NamedQuery(name="Tariff.findAll", query="SELECT t FROM Tariff t")
public class Tariff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tariffId;

	private float fare;

	private byte taxApplicableId;

	//bi-directional many-to-one association to Rateplan
	@OneToMany(mappedBy="tariff")
	private List<Rateplan> rateplans;

	public Tariff() {
	}

	public int getTariffId() {
		return this.tariffId;
	}

	public void setTariffId(int tariffId) {
		this.tariffId = tariffId;
	}

	public float getFare() {
		return this.fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}

	public byte getTaxApplicableId() {
		return this.taxApplicableId;
	}

	public void setTaxApplicableId(byte taxApplicableId) {
		this.taxApplicableId = taxApplicableId;
	}

	public List<Rateplan> getRateplans() {
		return this.rateplans;
	}

	public void setRateplans(List<Rateplan> rateplans) {
		this.rateplans = rateplans;
	}

	public Rateplan addRateplan(Rateplan rateplan) {
		getRateplans().add(rateplan);
		rateplan.setTariff(this);

		return rateplan;
	}

	public Rateplan removeRateplan(Rateplan rateplan) {
		getRateplans().remove(rateplan);
		rateplan.setTariff(null);

		return rateplan;
	}

}