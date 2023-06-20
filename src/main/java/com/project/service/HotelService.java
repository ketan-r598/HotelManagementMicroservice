package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.Hotel;

public interface HotelService {

	public void addHotel(Hotel hotel);
	public void updateHotel(Hotel hotel);
	public void deleteHotel(int id);
	public Optional<Hotel> getHotel(int id);
	public List<Hotel> getHotels();
}