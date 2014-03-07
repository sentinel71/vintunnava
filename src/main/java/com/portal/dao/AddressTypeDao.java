package com.portal.dao;

import java.util.List;

import com.portal.model.Addresstype;

public interface AddressTypeDao {
	public List<Addresstype> findAll() throws Exception;
}
