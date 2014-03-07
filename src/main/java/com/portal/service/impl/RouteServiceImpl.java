package com.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.portal.dao.RouteDao;
import com.portal.model.Route;
import com.portal.service.RouteService;

public class RouteServiceImpl implements RouteService{

	@Autowired
	private RouteDao routeDao;
	
	public List<Route> findAllRoutes() {
		return routeDao.findAll();
	}

}
