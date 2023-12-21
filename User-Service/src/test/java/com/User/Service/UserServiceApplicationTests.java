package com.User.Service;

import com.User.Service.entities.Hotel;
import com.User.Service.entities.Rating;
import com.User.Service.externalService.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private RatingService ratingService;
	@Test
	void createRating(){
		Rating rating = Rating.builder()
				.rating(10).userId("123").hotelId("456").feedback("this is created by Shahzain")
				.hotel(new Hotel())
				.build();
		String save = ratingService.createRating(rating);
		System.out.println(save);
	}

}
