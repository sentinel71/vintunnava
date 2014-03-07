package com.portal.service;

import com.portal.beans.SearchDetails;
import com.portal.model.Booking;

public interface BookingService {
	public Booking doBooking(SearchDetails searchDetails);
}
