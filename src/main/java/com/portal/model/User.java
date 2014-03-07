package com.portal.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
@NamedQuery(name="User.findUserById", query="select u from User u where u.userId = :userid"),
@NamedQuery(name="User.findUserByEmail", query="select u from User u where u.email = :email")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_USER_BY_ID = "User.findUserById";

	public static final String FIND_USER_BY_EMAIL = "User.findUserByEmail";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String userId;
	
//	@UniqueConstraint
	@Column(unique=true)
	private String email;

	private String alternateContactNo;

	private String contactNo;

	private Timestamp createdOn;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String firstName;

	private String lastName;

	private String middleName;

	private String title;

	private Timestamp updatedOn;

	private String username;
	
	private String password;
	
	private String verificationKey;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
	private List<Address> addresses;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="user")
	private List<Booking> bookings;

	public User() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAlternateContactNo() {
		return this.alternateContactNo;
	}

	public void setAlternateContactNo(String alternateContactNo) {
		this.alternateContactNo = alternateContactNo;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setUser(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setUser(null);

		return address;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerificationKey() {
		return verificationKey;
	}

	public void setVerificationKey(String verificationKey) {
		this.verificationKey = verificationKey;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

//	public Booking addBooking(Booking booking) {
//		getBookings().add(booking);
//		booking.setUser(this);
//
//		return booking;
//	}
//
//	public Booking removeBooking(Booking booking) {
//		getBookings().remove(booking);
//		booking.setUser(null);
//
//		return booking;
//	}

}