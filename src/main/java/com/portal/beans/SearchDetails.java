package com.portal.beans;

import java.util.List;

import com.portal.model.Houseboattype;
import com.portal.model.Roomtype;
import com.portal.model.Route;

public class SearchDetails {
//	private Map<Houseboattype,String> houseboatList;
//	private Map<Route,String> routeList;
	private List<Houseboattype> houseboatList;
	private List<Route> routeList;
	private List<Roomtype> roomTypeList;
	private byte routeId;
	private byte houseboatId;
	private Route route;
	private Houseboattype houseboattype;
	private Roomtype roomType;
	private CustomerDetails customerDetail;
	private int bookingId;
	
	public byte getHouseboatId() {
		return houseboatId;
	}
	public void setHouseboatId(byte houseboatId) {
		this.houseboatId = houseboatId;
	}
	public byte getRouteId() {
		return routeId;
	}
	public void setRouteId(byte routeId) {
		this.routeId = routeId;
	}
	
	
//	public Map<Houseboattype, String> getHouseboatList() {
//		return houseboatList;
//	}
//	public void setHouseboatList(Map<Houseboattype, String> houseboatList) {
//		this.houseboatList = houseboatList;
//	}
//	
//	public Map<Route, String> getRouteList() {
//		return routeList;
//	}
//	public void setRouteList(Map<Route, String> routeList) {
//		this.routeList = routeList;
//	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Houseboattype getHouseboattype() {
		return houseboattype;
	}
	public void setHouseboattype(Houseboattype houseboattype) {
		this.houseboattype = houseboattype;
	}
	public List<Route> getRouteList() {
		return routeList;
	}
	public void setRouteList(List<Route> routeList) {
		this.routeList = routeList;
	}
	public List<Houseboattype> getHouseboatList() {
		return houseboatList;
	}
	public void setHouseboatList(List<Houseboattype> houseboatList) {
		this.houseboatList = houseboatList;
	}
	public List<Roomtype> getRoomTypeList() {
		return roomTypeList;
	}
	public void setRoomTypeList(List<Roomtype> roomTypeList) {
		this.roomTypeList = roomTypeList;
	}
	public Roomtype getRoomType() {
		return roomType;
	}
	public void setRoomType(Roomtype roomType) {
		this.roomType = roomType;
	}
	public CustomerDetails getCustomerDetail() {
		return customerDetail;
	}
	public void setCustomerDetail(CustomerDetails customerDetail) {
		this.customerDetail = customerDetail;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
//	public void convertRouteListtoMap(List<Route> routeList){
//		Map<Route,String> map=new HashMap<Route,String>();
//		for(Route route:routeList){
//			map.put(route, route.getRouteName());
//		}
//		setRouteList(map);
//	}
//	public void convertHouseboattypeListtoMap(List<Houseboattype> HouseboattypeList){
//		Map<Houseboattype,String> map=new HashMap<Houseboattype,String>();
//		for(Houseboattype houseboattype:HouseboattypeList){
//			map.put(houseboattype, houseboattype.getHouseboatName());
//		}
//		setHouseboatList(map);
//	}
}
