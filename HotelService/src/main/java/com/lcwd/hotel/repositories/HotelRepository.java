package com.lcwd.hotel.repositories;

import com.lcwd.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {

    // Custom query methods can be defined here if needed
    // For example, to find hotels by location:
    // List<Hotel> findByLocation(String location);

}
