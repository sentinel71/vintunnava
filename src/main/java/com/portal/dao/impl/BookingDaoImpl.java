package com.portal.dao.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.portal.beans.CustomerDetails;
import com.portal.beans.SearchDetails;
import com.portal.dao.BookingDao;
import com.portal.model.Booking;

public class BookingDaoImpl implements BookingDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public Booking doBooking(SearchDetails searchDetails,CustomerDetails customerDetails) {
		Booking booking = new Booking();
//		booking.setFName(customerDetails.getfName());
//		booking.setLName(customerDetails.getlName());
//		booking.setEmail(customerDetails.getEmail());
//		booking.setMobileNo(customerDetails.getMobileNo());
//		booking.setCountryCode(customerDetails.getCountryCode());
//		booking.setPincode(customerDetails.getPincode());
//		booking.setCity(customerDetails.getCity());
//		booking.setCountry(customerDetails.getCountry());

		booking.setBookedForDate(new Date());
		booking.setBookingDate(new Date());
		booking.setRoomTypeId(searchDetails.getRoomType().getRoomTypeId());
		
		//entityManager.getTransaction().begin();
		entityManager.persist(booking);
		//entityManager.getTransaction().commit();
		
		entityManager.flush();
		return booking;		
	}
}
