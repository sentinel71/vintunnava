package com.portal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tarifftype database table.
 *  
 */
@Entity
@NamedQuery(name="Tarifftype.findAll", query="SELECT t FROM Tarifftype t")
public class Tarifftype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private byte tariffTypeId;

	private String tariffTypeName;

	//bi-directional many-to-one association to Rateplan
	@OneToMany(mappedBy="tarifftype")
	private List<Rateplan> rateplans;

	public Tarifftype() {
	}

	public byte getTariffTypeId() {
		return this.tariffTypeId;
	}

	public void setTariffTypeId(byte tariffTypeId) {
		this.tariffTypeId = tariffTypeId;
	}

	public String getTariffTypeName() {
		return this.tariffTypeName;
	}

	public void setTariffTypeName(String tariffTypeName) {
		this.tariffTypeName = tariffTypeName;
	}

	public List<Rateplan> getRateplans() {
		return this.rateplans;
	}

	public void setRateplans(List<Rateplan> rateplans) {
		this.rateplans = rateplans;
	}

	public Rateplan addRateplan(Rateplan rateplan) {
		getRateplans().add(rateplan);
		rateplan.setTarifftype(this);

		return rateplan;
	}

	public Rateplan removeRateplan(Rateplan rateplan) {
		getRateplans().remove(rateplan);
		rateplan.setTarifftype(null);

		return rateplan;
	}

}