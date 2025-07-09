package com.lcwd.user.service.services.impl;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.external_services.HotelService;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    // Implement the methods from UserService interface here
    @Autowired
    private UserRepository userRepository; // Assuming UserRepository is defined and injected

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {

        String randomUserID= UUID.randomUUID().toString();
        user.setUserId(randomUserID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        // Implementation logic for retrieving all users
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElse(null);

        ResponseEntity<List<Rating>> response = restTemplate.exchange(
            "http://RATING-SERVICE/ratings/users/" + userId,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Rating>>() {}
        );
        List<Rating> ratingsOfUser = response.getBody();

        List<Rating> ratingList = ratingsOfUser.stream().map((rating ) -> {
            logger.info("Getting rating for user {}", rating.getUserId());
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        logger.info("User found: {}", user);
        user.setRatings(ratingList);
        return user;
    }

    @Override
    public User updateUser(User user, String userId) {
        // Implementation logic for updating a user
        return null; // Replace with actual implementation
    }

    @Override
    public User deleteUser(String userId) {
        // Implementation logic for deleting a user
        return null; // Replace with actual implementation
    }
}
