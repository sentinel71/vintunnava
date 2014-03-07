package com.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.portal.dao.HouseBoatDao;
import com.portal.model.Houseboattype;
import com.portal.service.HouseBoatService;

public class HouseBoatServiceImpl implements HouseBoatService{

	@Autowired
	private HouseBoatDao houseBoatDao;
	
	public List<Houseboattype> findAllHouseBoatTypes() {
		return houseBoatDao.findAll();
	}

}
