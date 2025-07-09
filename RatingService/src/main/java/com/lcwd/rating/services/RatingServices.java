package com.lcwd.rating.services;

import com.lcwd.rating.entities.Rating;

import java.util.List;

public interface RatingServices {

    Rating create(Rating rating);
    List<Rating> getByHotelId(String hotelId);
    List<Rating> getByUserId(String userId);
    List<Rating> getAllRatings();

}
