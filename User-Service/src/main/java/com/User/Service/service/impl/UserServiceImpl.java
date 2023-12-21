package com.User.Service.service.impl;

import com.User.Service.Repository.UserRepository;
import com.User.Service.entities.Hotel;
import com.User.Service.entities.Rating;
import com.User.Service.entities.User;
import com.User.Service.exception.ResourceNotFoundException;
import com.User.Service.externalService.HotelService;
import com.User.Service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    HotelService hotelService;


//    private Logger logger = Logger.getLogger(String.valueOf(UserServiceImpl.class));//oggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User saveUser(User user) {
        String randomId= UUID.randomUUID().toString();
        user.setUserId(randomId);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user =  userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user with given id is not found on server userId: "+userId));

        Rating[] ratingOfUsers =  restTemplate.getForObject("http://RATING-SERVICE/rating/userId/"+user.getUserId(), Rating[].class);
        logger.info("{} ", ratingOfUsers);

        List<Rating> ratings = Arrays.stream(ratingOfUsers).toList();

        List<Rating> ratingList = ratings.stream().map(rating ->
        {
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/get/" + rating.getHotelId(), Hotel.class);
            //Hotel hotel = forEntity.getBody();
            //logger.info("Response status code: {} ", forEntity.getStatusCode());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;

    }
}
