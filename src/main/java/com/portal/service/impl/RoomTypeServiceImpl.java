package com.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.portal.beans.SearchDetails;
import com.portal.dao.RoomTypeDao;
import com.portal.model.Roomtype;
import com.portal.service.RoomTypeService;

public class RoomTypeServiceImpl implements RoomTypeService{

	@Autowired
	private RoomTypeDao roomTypeDao;
	
	public List<Roomtype> getRoomType(SearchDetails searchBean) {
		return roomTypeDao.findbySearchCriteria(searchBean);
	}

}
