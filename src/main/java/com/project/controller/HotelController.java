package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Hotel;
import com.project.service.HotelService;

@RestController
public class HotelController {

	@Autowired
	private HotelService service;
	
	@PostMapping("/admin/hotels/addHotel")
	public void addHotel(@RequestBody Hotel hotel) {
		service.addHotel(hotel);
	}
	
	@PutMapping("/admin/hotels/updateHotel")
	public void updateHotel(@RequestBody Hotel hotel) {
		service.updateHotel(hotel);
	}
	
	@DeleteMapping("/admin/hotels/delete/{id}")
	public void deleteHotel(@PathVariable int id) {
		service.deleteHotel(id);
	}
	
	@GetMapping("/admin/hotels/getHotel/{id}")
	public Hotel getHotel(@PathVariable int id) {
		return service.getHotel(id).get();
	}
	
	@GetMapping("/admin/hotels/getHotels")
	public List<Hotel> getHotels() {
		return service.getHotels();
	}
}
