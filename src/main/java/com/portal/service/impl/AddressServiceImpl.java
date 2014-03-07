package com.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.portal.dao.AddressDao;
import com.portal.dao.AddressTypeDao;
import com.portal.model.Address;
import com.portal.model.Addresstype;
import com.portal.service.AddressService;

public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressTypeDao addressTypeDao;
	@Autowired
	private AddressDao addressDao;
	
	public List<Addresstype> findAll() throws Exception {
		return addressTypeDao.findAll();
	}

	public Address insertAddress(Address addr) throws Exception {
		return addressDao.insertAddress(addr);
	}

	public Address updateAddress(Address addr) throws Exception {
		return addressDao.updateAddress(addr);		
	}

}
