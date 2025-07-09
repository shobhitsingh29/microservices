package com.lcwd.user.service.external_services;

import com.lcwd.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @PostMapping("/ratings")
    Rating createRating(@RequestBody Rating rating);

    @PutMapping("/ratings")
    Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);
}