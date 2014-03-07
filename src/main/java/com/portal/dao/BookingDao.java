package com.portal.dao;

import com.portal.beans.CustomerDetails;
import com.portal.beans.SearchDetails;
import com.portal.model.Booking;

public interface BookingDao {
	public Booking doBooking(SearchDetails searchDetails,CustomerDetails customerDetails);
}
