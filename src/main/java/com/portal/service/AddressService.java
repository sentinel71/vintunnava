package com.portal.service;

import java.util.List;

import com.portal.model.Address;
import com.portal.model.Addresstype;

public interface AddressService {
	public List<Addresstype> findAll() throws Exception;

	public Address insertAddress(Address addr) throws Exception;

	public Address updateAddress(Address addr) throws Exception;
}
