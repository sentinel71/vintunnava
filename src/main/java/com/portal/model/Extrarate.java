package com.portal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the extrarate database table.
 * 
 */ 
@Entity
@NamedQuery(name="Extrarate.findAll", query="SELECT e FROM Extrarate e")
public class Extrarate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private byte extraRateId;

	private float perExtraBed;

	private float perExtraChild;

	public Extrarate() {
	}

	public byte getExtraRateId() {
		return this.extraRateId;
	}

	public void setExtraRateId(byte extraRateId) {
		this.extraRateId = extraRateId;
	}

	public float getPerExtraBed() {
		return this.perExtraBed;
	}

	public void setPerExtraBed(float perExtraBed) {
		this.perExtraBed = perExtraBed;
	}

	public float getPerExtraChild() {
		return this.perExtraChild;
	}

	public void setPerExtraChild(float perExtraChild) {
		this.perExtraChild = perExtraChild;
	}

}