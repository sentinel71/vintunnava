package com.portal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.portal.beans.CustomerDetails;
import com.portal.beans.SearchDetails;
import com.portal.model.Address;
import com.portal.model.Addresstype;
import com.portal.model.Roomtype;
import com.portal.model.User;
import com.portal.service.AddressService;
import com.portal.service.BookingService;
import com.portal.service.HouseBoatService;
import com.portal.service.RoomTypeService;
import com.portal.service.RouteService;
import com.portal.service.UserService;
import com.portal.util.CommonEmail;

@Controller
@SessionAttributes("search")
@RequestMapping("/")
public class SearchController {
	
	static Logger logger = Logger.getLogger(SearchController.class.getName());
	
	
	@Autowired
	private RouteService routeService;
	@Autowired
	private HouseBoatService houseBoatService;
	@Autowired
	private RoomTypeService roomTypeService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private UserService userService;
	@Autowired
	private AddressService addressService;
	
	private List<Addresstype> addrTypeList  = new ArrayList<Addresstype>();
	
	@RequestMapping(value="search",method = RequestMethod.GET)
    public ModelAndView getSearchCriteria()    {
		logger.info("In SampleController.getUserId()");
//		SearchDetails searchBean = new SearchDetails();
//		searchBean.setHouseboatList(houseBoatService.findAllHouseBoatTypes());
//		searchBean.setRouteList(routeService.findAllRoutes());
//		return new ModelAndView("searchPage", "search",searchBean);
		try {
			addrTypeList = addressService.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return new ModelAndView("searchPage", "",null);
    }
	
	@RequestMapping(value = "searchResults", method = RequestMethod.POST)
	public ModelAndView  showSearchResults(@ModelAttribute("search") SearchDetails searchBean, BindingResult result){

//		searchBean.setHouseboatList(houseBoatService.findAllHouseBoatTypes());
//		searchBean.setRouteList(routeService.findAllRoutes());
		searchBean.setRoute(searchBean.getRouteList().get(searchBean.getRouteId()-1));
		searchBean.setHouseboattype(searchBean.getHouseboatList().get(searchBean.getHouseboatId()-1));
		searchBean.setRoomTypeList(roomTypeService.getRoomType(searchBean));
		return new ModelAndView("searchResult","search",searchBean);
	}
	
	@RequestMapping(value = "payment", method = RequestMethod.POST)
	public ModelAndView  showSelectedRoom(@RequestParam("roomSelectedid") int roomtypeid,@ModelAttribute("search") SearchDetails searchBean, BindingResult result){
		searchBean.setRoomType(searchBean.getRoomTypeList().get(roomtypeid-1));
		searchBean.setCustomerDetail(new CustomerDetails());
		return new ModelAndView("payment","search",searchBean);
	}
	
	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public ModelAndView  confirmBooking(@ModelAttribute("search") SearchDetails searchBean, BindingResult result){
		searchBean.setBookingId(bookingService.doBooking(searchBean).getBookingId());
		return new ModelAndView("bookingConfirmation","search",searchBean);
	}
	
	//-------Integration----------//
	@RequestMapping(value = "plainSearch", method = RequestMethod.POST)
	public ModelAndView doPlainSearch(){
		return new ModelAndView("searchResult","",null);		
	}
	
	@RequestMapping(value = "plainSearch", method = RequestMethod.GET)
	public ModelAndView doPlainSearchGet(){	
		return new ModelAndView("searchResult","",null);
	}
	
	@RequestMapping(value = "viewDetail", method = RequestMethod.GET)
	public ModelAndView viewDetailGet(){	
		return new ModelAndView("viewDetail","",null);
	}
	
	@RequestMapping(value = "viewDetail", method = RequestMethod.POST)
	public ModelAndView viewDetail(){	
		return new ModelAndView("viewDetail","",null);
	}
	
	@RequestMapping(value = "plainBooking", method = RequestMethod.POST)
	public ModelAndView doPlainBooking(){
		return new ModelAndView("payment","",null);	
	}
	
	@RequestMapping(value = "plainBooking", method = RequestMethod.GET)
	public ModelAndView doPlainBookingGet(){
		return new ModelAndView("payment","",null);	
	}
	
	@RequestMapping(value = "plainBookingConfirm", method = RequestMethod.POST)
	public ModelAndView doplainBookingConfirm(){
		return new ModelAndView("bookingConfirmation","",null);		
	}	
	
	@RequestMapping(value="login",method = RequestMethod.POST)
    public void doLogin(HttpServletRequest request, HttpServletResponse response){
		String email = request.getParameter("loginEmail").trim();
		String password = request.getParameter("loginPassword").trim();
		PrintWriter writer = null;
		try {
			switch(userService.validateLogin(request,email,password)){
				case 0: writer = response.getWriter();
						writer.write("<span style='color:red'>  Login Account doesn't exists.</span>");
						writer.close();
						break;
				case 1: writer = response.getWriter();
						writer.write("<span style='color:red'>  Password incorrect.</span>");
						writer.close();
						break;
				case 2: writer = response.getWriter();
						writer.write("<span style='color:red'> Account not activated.</span>");
						writer.close();
						break;
				case 3: System.out.println("logged in");
						request.getSession().setAttribute("loggedInUser", "yes");
						break;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			System.out.println("login failed due to error");
		}
	}

	
	@RequestMapping(value="signup",method = RequestMethod.POST)
    public void doSignUp(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter writer = null;	
		String email = request.getParameter("signupemail").trim();
		String password = request.getParameter("signuppword").trim();
		User user = null;
		try {
			writer = response.getWriter();
			user = userService.createUser(email, password);
		} catch (PersistenceException e) {
			logger.error(e.getMessage(), e);
	        writer.write("<span style='color:red'>  *Email already exists.</span>");    // returned as Ajax Response Text in this example	 
	        writer.close();
	        //response.setStatus(500);
	        return;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
//		return new ModelAndView("searchPage","",null);
		writer.write("<span style='color:green'>User Registered. Check inbox to verify.</span>");    // returned as Ajax Response Text in this example	 
        writer.close();
        //response.setStatus(200);
        
        CommonEmail commonEmail = new CommonEmail();
        commonEmail.sendSignUpMail(user);
        return;
	}
	
	@RequestMapping(value="profile",method = RequestMethod.POST)
    public void doProfileUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException{
		User user = (User)request.getSession().getAttribute("user");
		//System.out.println(request.getParameter("firstname"));
		user.setTitle(request.getParameter("selectTitle"));
		user.setFirstName(request.getParameter("firstname"));
		user.setMiddleName(request.getParameter("middlename"));
		user.setLastName(request.getParameter("lastname"));
		user.setContactNo((String)request.getParameter("mobileno"));
		user.setAlternateContactNo((String)request.getParameter("altmobileno"));
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//System.out.println((String)request.getParameter("dob"));
			Date date = sdf.parse((String)request.getParameter("dob"));
			//System.out.println(sdf.format(date));
			user.setDateOfBirth(date);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		}
		
		try {
			userService.updateUser(user);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	@RequestMapping(value="address",method = RequestMethod.POST)
    public void doAddressUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException{
		User user = (User)request.getSession().getAttribute("user");
		if(user.getAddresses().isEmpty()){
			Address addr = new Address();
			for(Addresstype address :addrTypeList){
				if(address.getName().contentEquals(request.getParameter("selectAddressType"))){
					addr.setAddresstype(address);
					break;
				}
			}
			addr.setAddressLine1(request.getParameter("addressLine1"));
			addr.setAddressLine2(request.getParameter("addressLine2"));
			addr.setCityStateCountry(request.getParameter("city"));
			addr.setZipcode(request.getParameter("zipcode"));
			addr.setUser(user);
			
			try {
				user.getAddresses().add(addressService.insertAddress(addr));
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}else{
			Address addr =user.getAddresses().get(0);
			for(Addresstype address :addrTypeList){
				if(address.getName().contentEquals(request.getParameter("selectAddressType"))){
					addr.setAddresstype(address);
					break;
				}
			}
			addr.setAddressLine1(request.getParameter("addressLine1"));
			addr.setAddressLine2(request.getParameter("addressLine2"));
			addr.setCityStateCountry(request.getParameter("city"));
			addr.setZipcode(request.getParameter("zipcode"));
			addr.setUser(user);
			try {
				user.getAddresses().set(0, addressService.updateAddress(addr));
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
	}
	
//	@RequestMapping(value="logout",method = RequestMethod.GET)
//    public ModelAndView doLogout(HttpServletRequest request, HttpServletResponse response){		
//		request.getSession().invalidate();
//		System.out.println("logged out");
//		return new ModelAndView("searchPage","",null);
//	}
	@RequestMapping(value="logout",method = RequestMethod.GET)
    public void doLogout(HttpServletRequest request, HttpServletResponse response){		
		if(request.getSession().getAttribute("loggedInUser")!=null){
			request.getSession().invalidate();
			System.out.println("logged out");
		}else
			System.out.println("Cannot logout.Session doesn't exists.");
	}
	
	@RequestMapping(value="profile",method = RequestMethod.GET)
	public ModelAndView goToProfile(HttpServletRequest request, HttpServletResponse response){		
		return new ModelAndView("profile","",null);
	}
	
	@RequestMapping(value="bookingHistory",method = RequestMethod.GET)
	public ModelAndView goToBookingHistory(){
		return new ModelAndView("profile","",null);
	}
	
	@RequestMapping(value="accountActivate",method = RequestMethod.GET)
    public ModelAndView activateAccount(HttpServletRequest request, HttpServletResponse response)    {
		String hashcode = request.getParameter("hash").trim();
		String uid = request.getParameter("uid").trim();
		System.out.println(hashcode);
		System.out.println(uid);
		User user = null;
		try {
			user = userService.getUserById(uid);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		//login
		String message = null;
		if(user.getVerificationKey().contentEquals(hashcode)){
			request.getSession().setAttribute("loggedInUser", "yes");
			user.setVerificationKey("");
			try {
				userService.updateUser(user);
				message = "Your account is activated.";
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			
		}else
			message = "Your account is already activated.";
		
		return new ModelAndView("accountActivate","msg",message);
	}
}
