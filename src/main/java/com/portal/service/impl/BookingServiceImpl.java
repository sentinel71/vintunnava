package com.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.portal.beans.SearchDetails;
import com.portal.dao.BookingDao;
import com.portal.model.Booking;
import com.portal.service.BookingService;

public class BookingServiceImpl implements BookingService{
	@Autowired
	private BookingDao bookingDao;

	public Booking doBooking(SearchDetails searchDetails) {	
		return bookingDao.doBooking(searchDetails, searchDetails.getCustomerDetail());
	}

}
