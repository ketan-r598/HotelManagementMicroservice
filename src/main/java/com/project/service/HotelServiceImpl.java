package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Hotel;
import com.project.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository repo;

	@Override
	public void addHotel(Hotel hotel) {

		Optional<Hotel> h = repo.findById(hotel.getHotelId());

		if (h.isPresent()) {
			// TODO
			// throw Exception
		}

		repo.save(hotel);
		System.out.println("------------------------------");
		System.out.println("+  Hotel Added Successfully  +");
		System.out.println("------------------------------");
	}

	@Override
	public void updateHotel(Hotel hotel) {

		Optional<Hotel> h = repo.findById(hotel.getHotelId());

		if (h.isEmpty()) {
			// TODO
			// throw Exception
		}

		repo.save(hotel);
		System.out.println("--------------------------------");
		System.out.println("+  Hotel Updated Successfully  +");
		System.out.println("--------------------------------");
	}

	@Override
	public void deleteHotel(int id) {

		Optional<Hotel> h = repo.findById(id);

		if (h.isEmpty()) {
			// TODO
			// throw Exception
		}

		repo.deleteById(id);
		System.out.println("--------------------------------");
		System.out.println("+  Hotel Deleted Successfully  +");
		System.out.println("--------------------------------");
	}

	@Override
	public Optional<Hotel> getHotel(int id) {

		Optional<Hotel> h = repo.findById(id);
		return h;
	}

	@Override
	public List<Hotel> getHotels() {
		
		return repo.findAll();
	}

}
