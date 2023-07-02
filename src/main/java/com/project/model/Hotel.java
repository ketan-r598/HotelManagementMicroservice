package com.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Hotel")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int hotelId;

	//	private int ownerId;
	private String hotelName;
	private int userId;
	private String address;
	private String city;
	private String state;
	private String country;
	private double avgRating;
	private String email;
	private String contactInfo;
	
	public Hotel() {
	
	}

	public Hotel(int hotelId, String hotelName, int userId, String address, String city, String state, String country,
			double avgRating, String email, String contactInfo) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.userId = userId;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.avgRating = avgRating;
		this.email = email;
		this.contactInfo = contactInfo;
	}



	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", userId=" + userId + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", avgRating=" + avgRating
				+ ", email=" + email + ", contactInfo=" + contactInfo + "]";
	}
}
