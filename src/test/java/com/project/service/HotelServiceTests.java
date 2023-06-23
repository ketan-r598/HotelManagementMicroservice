package com.project.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.model.Hotel;
import com.project.repository.HotelRepository;

class HotelServiceTests {

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private HotelServiceImpl hotelService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddHotel() {
        Hotel hotel = new Hotel();
        hotel.setHotelId(1);
        hotel.setHotelName("Sample Hotel");
        hotel.setAddress("123 Main Street");
        hotel.setCity("Sample City");
        hotel.setState("Sample State");
        hotel.setCountry("Sample Country");
        hotel.setAvgRating(4.5);
        hotel.setEmail("sample@example.com");
        hotel.setContactInfo("1234567890");

        when(hotelRepository.save(hotel)).thenReturn(hotel);

        assertDoesNotThrow(() -> hotelService.addHotel(hotel));
        verify(hotelRepository, times(1)).save(hotel);
    }

    @Test
    void testUpdateHotel() {
        Hotel hotel = new Hotel();
        hotel.setHotelId(1);
        hotel.setHotelName("Sample Hotel");
        hotel.setAddress("123 Main Street");
        hotel.setCity("Sample City");
        hotel.setState("Sample State");
        hotel.setCountry("Sample Country");
        hotel.setAvgRating(4.5);
        hotel.setEmail("sample@example.com");
        hotel.setContactInfo("1234567890");

        when(hotelRepository.save(hotel)).thenReturn(hotel);

        assertDoesNotThrow(() -> hotelService.updateHotel(hotel));
        verify(hotelRepository, times(1)).save(hotel);
    }

    @Test
    void testDeleteHotel() {
        int hotelId = 1;

        assertDoesNotThrow(() -> hotelService.deleteHotel(hotelId));
        verify(hotelRepository, times(1)).deleteById(hotelId);
    }

    @Test
    void testGetHotel() {
        int hotelId = 1;

        Hotel hotel = new Hotel();
        hotel.setHotelId(hotelId);
        hotel.setHotelName("Sample Hotel");
        hotel.setAddress("123 Main Street");
        hotel.setCity("Sample City");
        hotel.setState("Sample State");
        hotel.setCountry("Sample Country");
        hotel.setAvgRating(4.5);
        hotel.setEmail("sample@example.com");
        hotel.setContactInfo("1234567890");

        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));

        Optional<Hotel> result = hotelService.getHotel(hotelId);

        assertTrue(result.isPresent());
        assertEquals(hotel, result.get());
        verify(hotelRepository, times(1)).findById(hotelId);
    }

    @Test
    void testGetHotels() {
        Hotel hotel1 = new Hotel();
        hotel1.setHotelId(1);
        hotel1.setHotelName("Sample Hotel 1");
        // Set other attributes

        Hotel hotel2 = new Hotel();
        hotel2.setHotelId(2);
        hotel2.setHotelName("Sample Hotel 2");
        // Set other attributes

        List<Hotel> hotels = Arrays.asList(hotel1, hotel2);

        when(hotelRepository.findAll()).thenReturn(hotels);

        List<Hotel> result = hotelService.getHotels();

        assertNotNull(result);
        assertEquals(hotels, result);
        verify(hotelRepository, times(1)).findAll();
    }
}

