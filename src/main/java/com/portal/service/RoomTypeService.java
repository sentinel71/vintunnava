package com.portal.service;

import java.util.List;

import com.portal.beans.SearchDetails;
import com.portal.model.Roomtype;

public interface RoomTypeService {
	public List<Roomtype> getRoomType(SearchDetails searchBean);
}
