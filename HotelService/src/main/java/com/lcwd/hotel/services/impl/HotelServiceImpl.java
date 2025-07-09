package com.lcwd.hotel.services.impl;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.repositories.HotelRepository;
import com.lcwd.hotel.services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelServices {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String randomHotelId = UUID.randomUUID().toString();
        hotel.setId(randomHotelId);

        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        // Logic to get all hotels
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        // Logic to get a hotel by ID
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found")); // Replace with actual implementation
    }

    @Override
    public Hotel updateHotel(Hotel hotel, String hotelId) {
        // Logic to update a hotel
        return null; // Replace with actual implementation
    }

    @Override
    public Hotel deleteHotel(String hotelId) {
        // Logic to delete a hotel
        return null; // Replace with actual implementation
    }
}
