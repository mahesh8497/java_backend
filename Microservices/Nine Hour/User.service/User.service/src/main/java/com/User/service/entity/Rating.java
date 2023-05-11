package com.User.service.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.lang.annotation.Documented;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("user_ratings")
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private  int rating;
    private  String feedback;
}