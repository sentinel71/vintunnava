package com.portal.dao;

import com.portal.model.Address;

public interface AddressDao {
	public Address insertAddress(Address addr) throws Exception;

	public Address updateAddress(Address addr) throws Exception;
}
