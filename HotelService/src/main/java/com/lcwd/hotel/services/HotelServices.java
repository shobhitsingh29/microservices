package com.lcwd.hotel.services;

import com.lcwd.hotel.entities.Hotel;

import java.util.List;

public interface HotelServices {
    Hotel create(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotel(String id);

    Hotel updateHotel(com.lcwd.hotel.entities.Hotel hotel, String hotelId);

    Hotel deleteHotel(String hotelId);
}
