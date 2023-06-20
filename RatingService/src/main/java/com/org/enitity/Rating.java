package com.org.enitity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("Rating")
public class Rating {
    @Id
    private String ratingId;
    private Integer rating;
    private String feedback;
}
