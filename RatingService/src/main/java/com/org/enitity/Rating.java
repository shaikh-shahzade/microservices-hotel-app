package com.org.enitity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Rating")
public class Rating {
    @Id
    private String ratingId;
    private Integer rating;
    private String Feedback;
}
