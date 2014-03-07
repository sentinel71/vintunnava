package com.portal.dao;

import java.util.List;

import com.portal.beans.SearchDetails;
import com.portal.model.Roomtype;

public interface RoomTypeDao {
	public List<Roomtype> findbySearchCriteria(SearchDetails searchBean);
}
