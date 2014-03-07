package com.portal.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String addressId;

	private String addressLine1;

	private String addressLine2;

	private String cityStateCountry;

	private String zipcode;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	//bi-directional many-to-one association to Addresstype
	@ManyToOne
	@JoinColumn(name="addressTypeId")
	private Addresstype addresstype;

	public Address() {
	}

	public String getAddressId() {
		return this.addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCityStateCountry() {
		return this.cityStateCountry;
	}

	public void setCityStateCountry(String cityStateCountry) {
		this.cityStateCountry = cityStateCountry;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Addresstype getAddresstype() {
		return this.addresstype;
	}

	public void setAddresstype(Addresstype addresstype) {
		this.addresstype = addresstype;
	}

}