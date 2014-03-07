package com.portal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the addresstype database table.
 * 
 */
@Entity
@NamedQuery(name="Addresstype.findAll", query="SELECT a FROM Addresstype a")
public class Addresstype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte addressTypeId;

	private String name;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="addresstype")
	private List<Address> addresses;

	public Addresstype() {
	}

	public byte getAddressTypeId() {
		return this.addressTypeId;
	}

	public void setAddressTypeId(byte addressTypeId) {
		this.addressTypeId = addressTypeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setAddresstype(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setAddresstype(null);

		return address;
	}

}