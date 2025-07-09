package com.lcwd.hotel.controllers;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HomeController {
    @Autowired
    private HotelServices hotelService;

     @GetMapping
     public ResponseEntity<List<Hotel>> getAllHotels() {
         return ResponseEntity.ok(hotelService.getAllHotels());
     }

    @PostMapping
     public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
            Hotel createdHotel = hotelService.create(hotel);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id) {
        Hotel hotel = hotelService.getHotel(id);
        return ResponseEntity.ok(hotel);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel, @PathVariable String id) {
        Hotel updatedHotel = hotelService.updateHotel(hotel, id);
        return ResponseEntity.ok(updatedHotel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable String id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }

}
