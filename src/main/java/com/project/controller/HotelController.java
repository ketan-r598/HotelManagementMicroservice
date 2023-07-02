package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Hotel;
import com.project.service.HotelService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/hotels/owner/")
public class HotelController {

	@Autowired
	private HotelService service;
	
	@PostMapping("addHotel")
	public void addHotel(@RequestBody Hotel hotel) {
		service.addHotel(hotel);
	}
	
	@PutMapping("updateHotel")
	public ResponseEntity<Map<String, Boolean>> updateHotel(@RequestBody Hotel hotel) {
		service.updateHotel(hotel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("updated", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteHotel(@PathVariable int id) {
		service.deleteHotel(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("getHotel/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable int id) {
		Optional<Hotel> hotel = service.getHotel(id);
		
		if(hotel.isPresent()) {
			return ResponseEntity.ok(hotel.get());
		} else {
			return ResponseEntity.ofNullable(hotel.get());
		}
	}
	
	@GetMapping("getHotels")
	public List<Hotel> getHotels() {
		return service.getHotels();
	}
	
	@GetMapping("getHotels/{userId}")
	public List<Hotel> getHotelsByUserId(@PathVariable int userId) {
		return service.getHotelsByUserId(userId);
	}
}