package com.rating.RatingService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("rating")
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private double rating;
    private String feedback;
}
