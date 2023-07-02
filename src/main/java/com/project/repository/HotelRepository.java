package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Hotel;
import java.util.List;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	List<Hotel> findByUserId(int userId);
	List<Hotel> findByCity(String city);
}
